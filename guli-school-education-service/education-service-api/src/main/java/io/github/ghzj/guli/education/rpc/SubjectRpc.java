package io.github.ghzj.guli.education.rpc;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectListDTO;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectUpdateDTO;
import io.github.ghzj.guli.education.object.view.subject.SubjectPageVO;
import io.github.ghzj.guli.education.object.view.subject.SubjectInfoVO;

/**
 * 课程科目 Rpc 接口
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
public interface SubjectRpc {

    /**
     * 课程科目 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult<PageUtils<SubjectPageVO>> pageSubject(SubjectListDTO param);


    /**
     * 课程科目 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult<SubjectInfoVO> info(String id);

    /**
     * 课程科目 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult<Boolean> save(SubjectSaveDTO param);

    /**
     * 课程科目 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult<Boolean> update(SubjectUpdateDTO param);

    /**
     * 课程科目 删除
     * @param param id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult<Boolean> delete(String[] ids);

}