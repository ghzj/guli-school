package io.github.ghzj.guli.education.rpc;

import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherListDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherUpdateDTO;
import io.github.ghzj.guli.education.object.view.teacher.TeacherInfoVO;
import io.github.ghzj.guli.education.object.view.teacher.TeacherPageVO;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author ghzj
 * @date 2021/1/21 21:25
 */
@DubboService(version = "1.0.0")
public class TeacherRpcImpl implements TeacherRpc {
    @Override
    public CommonResult<PageUtils<TeacherPageVO>> pageTeacher(TeacherListDTO param) {
        return null;
    }

    @Override
    public CommonResult<TeacherInfoVO> info(String id) {
        return null;
    }

    @Override
    public CommonResult<Boolean> save(TeacherSaveDTO param) {
        return null;
    }

    @Override
    public CommonResult<Boolean> update(TeacherUpdateDTO param) {
        return null;
    }

    @Override
    public CommonResult<Boolean> delete(String[] ids) {
        return null;
    }
}
