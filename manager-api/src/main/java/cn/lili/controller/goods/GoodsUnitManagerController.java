package cn.lili.controller.goods;


import cn.lili.common.enums.MessageCode;
import cn.lili.common.enums.ResultCode;
import cn.lili.common.utils.PageUtil;
import cn.lili.common.utils.ResultUtil;
import cn.lili.common.vo.PageVO;
import cn.lili.common.vo.ResultMessage;
import cn.lili.modules.goods.entity.dos.GoodsUnit;
import cn.lili.modules.goods.service.GoodsUnitService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 管理端,商品计量单位接口
 *
 * @author Bulbasaur
 * @date: 2020/11/26 16:15
 */
@RestController
@Api(tags = "管理端,商品计量单位接口")
@RequestMapping("/manager/goods/goodsUnit")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GoodsUnitManagerController {

    private final GoodsUnitService goodsUnitService;


    @ApiOperation(value = "分页获取商品计量单位")
    @GetMapping
    public ResultMessage<IPage<GoodsUnit>> getByPage(PageVO pageVO) {
        return ResultUtil.data(goodsUnitService.page(PageUtil.initPage(pageVO)));
    }

    @ApiOperation(value = "获取商品计量单位")
    @ApiImplicitParam(name = "id", value = "计量单位ID", required = true, paramType = "path")
    @GetMapping("/get/{id}")
    public ResultMessage<GoodsUnit> getById(@NotNull @PathVariable String id) {
        return ResultUtil.data(goodsUnitService.getById(id));
    }

    @ApiOperation(value = "添加商品计量单位")
    @PostMapping
    public ResultMessage<GoodsUnit> save(@Valid GoodsUnit goodsUnit) {
        goodsUnitService.save(goodsUnit);
        return ResultUtil.data(goodsUnit);
    }

    @ApiOperation(value = "编辑商品计量单位")
    @ApiImplicitParam(name = "id", value = "计量单位ID", required = true, paramType = "path")
    @PutMapping("/{id}")
    public ResultMessage<GoodsUnit> update(@NotNull @PathVariable String id, @Valid GoodsUnit goodsUnit) {
        goodsUnit.setId(id);
        goodsUnitService.updateById(goodsUnit);
        return ResultUtil.data(goodsUnit);
    }

    @ApiOperation(value = "删除商品计量单位")
    @ApiImplicitParam(name = "ids", value = "计量单位ID", required = true, paramType = "path")
    @DeleteMapping("/delete/{ids}")
    public ResultMessage<Object> delete(@NotNull @PathVariable List<String> ids) {
        goodsUnitService.removeByIds(ids);
        return ResultUtil.success(ResultCode.SUCCESS);
    }


}