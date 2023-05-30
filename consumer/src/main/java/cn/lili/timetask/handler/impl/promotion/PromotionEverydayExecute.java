package cn.lili.timetask.handler.impl.promotion;

import cn.lili.modules.order.cart.entity.vo.FullDiscountVO;
import cn.lili.modules.promotion.entity.dos.MemberCoupon;
import cn.lili.modules.promotion.entity.dos.PromotionGoods;
import cn.lili.modules.promotion.entity.enums.MemberCouponStatusEnum;
import cn.lili.modules.promotion.entity.enums.PromotionStatusEnum;
import cn.lili.modules.promotion.entity.vos.CouponVO;
import cn.lili.modules.promotion.entity.vos.PintuanVO;
import cn.lili.modules.promotion.service.*;
import cn.lili.timetask.handler.EveryDayExecute;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 促销活动每日定时器
 *
 * @author Chopper
 * @date 2021/3/18 3:23 下午
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PromotionEverydayExecute implements EveryDayExecute {

    //Mongo
    private final MongoTemplate mongoTemplate;
    //满额活动
    private final FullDiscountService fullDiscountService;
    //拼团
    private final PintuanService pintuanService;
    //优惠券
    private final CouponService couponService;
    //会员优惠券
    private final MemberCouponService memberCouponService;
    //促销商品
    private final PromotionGoodsService promotionGoodsService;


    /**
     * 将已过期的促销活动置为结束
     */
    @Override
    public void execute() {

        Query query = new Query();
        query.addCriteria(Criteria.where("promotionStatus").ne(PromotionStatusEnum.END.name()).orOperator(Criteria.where("promotionStatus").ne(PromotionStatusEnum.CLOSE.name())));
        query.addCriteria(Criteria.where("endTime").lt(new Date()));

        List<String> promotionIds = new ArrayList<>();

        List<FullDiscountVO> fullDiscountVOS = mongoTemplate.find(query, FullDiscountVO.class);
        if (!fullDiscountVOS.isEmpty()) {
            List<String> ids = new ArrayList<>();
            for (FullDiscountVO vo : fullDiscountVOS) {
                vo.setPromotionStatus(PromotionStatusEnum.END.name());
                if (vo.getPromotionGoodsList() != null && !vo.getPromotionGoodsList().isEmpty()) {
                    for (PromotionGoods promotionGoods : vo.getPromotionGoodsList()) {
                        promotionGoods.setPromotionStatus(PromotionStatusEnum.END.name());
                    }
                }
                mongoTemplate.save(vo);
                ids.add(vo.getId());
            }
            fullDiscountService.update(this.getUpdatePromotionWrapper(ids));
            promotionIds.addAll(ids);
        }

        List<PintuanVO> pintuanVOS = mongoTemplate.find(query, PintuanVO.class);
        if (!pintuanVOS.isEmpty()) {
            List<String> ids = new ArrayList<>();
            for (PintuanVO vo : pintuanVOS) {
                vo.setPromotionStatus(PromotionStatusEnum.END.name());
                if (vo.getPromotionGoodsList() != null && !vo.getPromotionGoodsList().isEmpty()) {
                    for (PromotionGoods promotionGoods : vo.getPromotionGoodsList()) {
                        promotionGoods.setPromotionStatus(PromotionStatusEnum.END.name());
                    }
                }
                mongoTemplate.save(vo);
                ids.add(vo.getId());
            }
            pintuanService.update(this.getUpdatePromotionWrapper(ids));
            promotionIds.addAll(ids);
        }

        List<CouponVO> couponVOS = mongoTemplate.find(query, CouponVO.class);
        if (!couponVOS.isEmpty()) {
            List<String> ids = new ArrayList<>();
            for (CouponVO vo : couponVOS) {
                vo.setPromotionStatus(PromotionStatusEnum.END.name());
                if (vo.getPromotionGoodsList() != null && !vo.getPromotionGoodsList().isEmpty()) {
                    for (PromotionGoods promotionGoods : vo.getPromotionGoodsList()) {
                        promotionGoods.setPromotionStatus(PromotionStatusEnum.END.name());
                    }
                }
                mongoTemplate.save(vo);
                ids.add(vo.getId());
            }
            couponService.update(this.getUpdatePromotionWrapper(ids));
            LambdaUpdateWrapper<MemberCoupon> memberCouponLambdaUpdateWrapper = new LambdaUpdateWrapper<MemberCoupon>().in(MemberCoupon::getCouponId, ids).set(MemberCoupon::getMemberCouponStatus, MemberCouponStatusEnum.EXPIRE.name());
            memberCouponService.update(memberCouponLambdaUpdateWrapper);
            promotionIds.addAll(ids);
        }

        promotionGoodsService.update(this.getUpdatePromotionGoodsWrapper(promotionIds));

    }

    private UpdateWrapper getUpdatePromotionWrapper(List<String> ids) {
        UpdateWrapper updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("id", ids);
        updateWrapper.set("promotion_status", PromotionStatusEnum.END.name());
        return updateWrapper;
    }

    private UpdateWrapper getUpdatePromotionGoodsWrapper(List<String> ids) {
        UpdateWrapper updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("promotion_id", ids);
        updateWrapper.set("promotion_status", PromotionStatusEnum.END.name());
        return updateWrapper;
    }
}