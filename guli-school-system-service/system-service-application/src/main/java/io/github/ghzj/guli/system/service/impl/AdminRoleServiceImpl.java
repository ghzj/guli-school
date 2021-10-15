package io.github.ghzj.guli.system.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.system.dao.AdminRoleDao;
import io.github.ghzj.guli.system.entity.AdminRoleEntity;
import io.github.ghzj.guli.system.service.AdminRoleService;
import io.github.ghzj.guli.system.object.transfer.data.admin.role.AdminRoleListDTO;
import io.github.ghzj.guli.common.mybatis.util.PageUtil;
import io.github.ghzj.guli.common.utils.OrderCodeUtil;

/**
 * 管理员角色连表
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Service("adminRoleService")
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleDao, AdminRoleEntity> implements AdminRoleService {

    @Override
    public PageUtils<AdminRoleEntity> queryPage(AdminRoleListDTO params) {
        IPage<AdminRoleEntity> page = this.page(
            PageUtil.build(params, OrderCodeUtil.getSortingFields(params)),
            new QueryWrapper<AdminRoleEntity>());

        return new PageUtils<>(page.getRecords(),(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent(),(int)page.getPages());
    }

}