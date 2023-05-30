package cn.lili.controller.permission;

import cn.lili.common.enums.ResultCode;
import cn.lili.common.utils.PageUtil;
import cn.lili.common.utils.ResultUtil;
import cn.lili.common.vo.ResultMessage;
import cn.lili.common.vo.SearchVO;
import cn.lili.modules.permission.entity.dos.Department;
import cn.lili.modules.permission.entity.vo.DepartmentVO;
import cn.lili.modules.permission.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 管理端,部门管理接口
 *
 * @author Chopper
 * @since 2020/11/22 12:06
 */
@RestController
@Api(tags = "管理端,部门管理接口")
@RequestMapping("/manager/department")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DepartmentManagerController {

    private final DepartmentService departmentService;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "查看部门详情")
    public ResultMessage<Department> get(@PathVariable String id) {
        Department department = departmentService.getById(id);
        return ResultUtil.data(department);
    }

    @GetMapping
    @ApiOperation(value = "获取树状结构")
    public ResultMessage<List<DepartmentVO>> getByPage(Department entity,
                                                       SearchVO searchVo) {
        return ResultUtil.data(departmentService.tree(PageUtil.initWrapper(entity, searchVo)));

    }

    @PostMapping
    @ApiOperation(value = "新增部门")
    public ResultMessage<Department> save(Department department) {
        if (departmentService.save(department)) {
            return ResultUtil.data(department);
        }
        return ResultUtil.error(ResultCode.ERROR);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新部门")
    public ResultMessage<Department> update(@PathVariable String id, Department department) {
        if (departmentService.updateById(department)) {
            return ResultUtil.data(department);
        }
        return ResultUtil.error(ResultCode.ERROR);
    }

    @DeleteMapping(value = "/{ids}")
    @ApiOperation(value = "删除部门")
    public ResultMessage<Object> delAllByIds(@PathVariable List<String> ids) {
        departmentService.deleteByIds(ids);
        return ResultUtil.success(ResultCode.SUCCESS);
    }
}