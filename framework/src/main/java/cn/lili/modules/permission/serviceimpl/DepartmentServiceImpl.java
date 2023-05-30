package cn.lili.modules.permission.serviceimpl;

import cn.lili.common.enums.ResultCode;
import cn.lili.common.exception.ServiceException;
import cn.lili.modules.permission.entity.dos.AdminUser;
import cn.lili.modules.permission.entity.dos.Department;
import cn.lili.modules.permission.entity.vo.DepartmentVO;
import cn.lili.modules.permission.mapper.DepartmentMapper;
import cn.lili.modules.permission.service.AdminUserService;
import cn.lili.modules.permission.service.DepartmentRoleService;
import cn.lili.modules.permission.service.DepartmentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门业务层实现
 *
 * @author Chopper
 * @date 2020/11/17 3:47 下午
 */
@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    //管理员
    private AdminUserService adminUserService;
    //部门角色
    private DepartmentRoleService departmentRoleService;

    @Autowired
    public void setDepartmentRoleService(DepartmentRoleService departmentRoleService) {
        this.departmentRoleService = departmentRoleService;
    }

    @Autowired
    public void setAdminUserService(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @Override
    public void deleteByIds(List<String> ids) {
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("department_id", ids);
        if (adminUserService.count(queryWrapper) > 0) {
            throw new ServiceException(ResultCode.PERMISSION_DEPARTMENT_DELETE_ERROR);
        }
        this.removeByIds(ids);
        departmentRoleService.deleteByDepartment(ids);
    }

    @Override
    public List<DepartmentVO> tree(QueryWrapper<Department> initWrapper) {
        try {
            List<Department> departments = this.list(initWrapper);

            List<DepartmentVO> all = new ArrayList<>();
            departments.forEach(item -> all.add(new DepartmentVO(item)));

            List<DepartmentVO> tree = new ArrayList<>();
            all.forEach(item -> {
                if (item.getParentId().equals("0")) {
                    initChild(item, all);
                    tree.add(item);
                }
            });

            return tree;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 递归初始化子树
     *
     * @param tree          树结构
     * @param departmentVOS 数据库对象集合
     */
    private void initChild(DepartmentVO tree, List<DepartmentVO> departmentVOS) {
        departmentVOS.stream()
                .filter(item -> (item.getParentId().equals(tree.getId())))
                .forEach(child -> {
                    DepartmentVO childTree = new DepartmentVO(child);
                    initChild(childTree, departmentVOS);
                    tree.getChildren().add(childTree);
                });
    }


}