package io.github.ghzj.guli.education.rpc;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherListDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherUpdateDTO;
import io.github.ghzj.guli.education.object.view.teacher.TeacherPageVO;
import io.github.ghzj.guli.education.object.view.teacher.TeacherInfoVO;

/**
 * 讲师 Rpc 接口
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
public interface TeacherRpc {

    /**
     * 讲师 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult<PageUtils<TeacherPageVO>> pageTeacher(TeacherListDTO param);


    /**
     * 讲师 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult<TeacherInfoVO> info(String id);

    /**
     * 讲师 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult<Boolean> save(TeacherSaveDTO param);

    /**
     * 讲师 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult<Boolean> update(TeacherUpdateDTO param);

    /**
     * 讲师 删除
     * @param param id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult<Boolean> delete(String[] param);

}