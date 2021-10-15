package io.github.ghzj.guli.system.rpc;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.refresh.token.Oauth2RefreshTokenListDTO;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.refresh.token.Oauth2RefreshTokenSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.refresh.token.Oauth2RefreshTokenUpdateDTO;
import io.github.ghzj.guli.system.object.view.oauth2.refresh.token.Oauth2RefreshTokenPageVO;
import io.github.ghzj.guli.system.object.view.oauth2.refresh.token.Oauth2RefreshTokenInfoVO;

/**
 * 刷新令牌 Rpc 接口
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface Oauth2RefreshTokenRpc {

    /**
     * 刷新令牌 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult<PageUtils<Oauth2RefreshTokenPageVO>> pageOauth2RefreshToken(Oauth2RefreshTokenListDTO param);


    /**
     * 刷新令牌 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult<Oauth2RefreshTokenInfoVO> info(String id);

    /**
     * 刷新令牌 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult<Boolean> save(Oauth2RefreshTokenSaveDTO param);

    /**
     * 刷新令牌 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult<Boolean> update(Oauth2RefreshTokenUpdateDTO param);

    /**
     * 刷新令牌 删除
     * @param param id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult<Boolean> delete(String[] ids);

}