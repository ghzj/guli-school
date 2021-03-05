package io.github.ghzj.guli.education.rpc;

import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherListDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherUpdateDTO;
import io.github.ghzj.guli.education.object.view.teacher.TeacherInfoVO;
import io.github.ghzj.guli.education.object.view.teacher.TeacherPageVO;

/**
 * @author ghzj
 * @date 2021/1/20 21:25
 * 教师 Rpc 接口
 */
public interface TeacherRpc {

    /**
     * 列表
     * @param param param
     * @return 分页数据
     */
    CommonResult<PageUtils<TeacherPageVO>> pageTeacher(TeacherListDTO param);


    /**
     * 信息
     * @param id id
     * @return 获取信息
     */
    CommonResult<TeacherInfoVO> info(String id);

    /**
     * 保存
     */
    CommonResult<Boolean> save( TeacherSaveDTO param);

    /**
     * 修改
     */
    CommonResult<Boolean> update(TeacherUpdateDTO param);

    /**
     * 删除
     */
    CommonResult<Boolean> delete(String[] ids);
}
