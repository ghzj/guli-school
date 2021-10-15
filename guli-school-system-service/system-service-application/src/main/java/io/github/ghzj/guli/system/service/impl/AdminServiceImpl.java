package io.github.ghzj.guli.system.service.impl;

import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.system.constant.AdminCodeConstants;
import io.github.ghzj.guli.system.convert.AdminMapStruct;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.system.dao.AdminDao;
import io.github.ghzj.guli.system.entity.AdminEntity;
import io.github.ghzj.guli.system.service.AdminService;
import io.github.ghzj.guli.system.object.transfer.data.admin.AdminListDTO;
import io.github.ghzj.guli.common.mybatis.util.PageUtil;
import io.github.ghzj.guli.common.utils.OrderCodeUtil;

/**
 * 系统用户
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements AdminService {

    @Override
    public PageUtils<AdminEntity> queryPage(AdminListDTO params) {
        IPage<AdminEntity> page = this.page(
            PageUtil.build(params, OrderCodeUtil.getSortingFields(params)),
            new QueryWrapper<AdminEntity>());

        return new PageUtils<>(page.getRecords(),(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent(),(int)page.getPages());
    }

    @Override
    public Boolean createAdmin(AdminEntity adminEntity) {
        LambdaQueryWrapper<AdminEntity> queryWrapper = new QueryWrapper<AdminEntity>()
                .lambda().eq(AdminEntity::getUsername, adminEntity.getUsername());

        //检查账号是否存在
        if(this.getOne(queryWrapper)!=null){
            throw ServiceExceptionUtil.exception(AdminCodeConstants.SYSTEM_ADMIN_USER_EXISTS);
        }

        //盐
        String passwordSalt = BCrypt.gensalt();
        //生成密文
        String password = BCrypt.hashpw(adminEntity.getPassword(), passwordSalt);

        adminEntity.setPassword(password);
        adminEntity.setPasswordSalt(passwordSalt);
        adminEntity.setCreateIp("192.168.100.1");
        adminEntity.setCreateAdminId(0L);

        boolean flag = this.save(adminEntity);
        if (!flag){
            throw ServiceExceptionUtil.exception(AdminCodeConstants.SYSTEM_ADMIN_SAVE_ERROR);
        }
        return true;
    }

}