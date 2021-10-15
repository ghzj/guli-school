package io.github.ghzj.guli.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.entity.AdminEntity;
import io.github.ghzj.guli.system.object.transfer.data.admin.AdminListDTO;

import java.util.Map;

/**
 * 系统用户
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
public interface AdminService extends IService<AdminEntity> {

    /**
     * 分页
     * @param params 分页选项
     * @return 分页数据
     */
    PageUtils<AdminEntity> queryPage(AdminListDTO params);

    /**
     * 创建系统用户
     * @param adminEntity po
     * @return true 创建成功
     */
    Boolean createAdmin(AdminEntity adminEntity);
}