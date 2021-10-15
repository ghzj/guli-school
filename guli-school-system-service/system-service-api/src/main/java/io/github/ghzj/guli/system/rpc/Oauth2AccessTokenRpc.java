package io.github.ghzj.guli.system.rpc;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.access.token.Oauth2AccessTokenListDTO;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.access.token.Oauth2AccessTokenSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.access.token.Oauth2AccessTokenUpdateDTO;
import io.github.ghzj.guli.system.object.view.oauth2.access.token.Oauth2AccessTokenPageVO;
import io.github.ghzj.guli.system.object.view.oauth2.access.token.Oauth2AccessTokenInfoVO;

/**
 * 访问令牌 Rpc 接口
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface Oauth2AccessTokenRpc {

    /**
     * 访问令牌 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult<PageUtils<Oauth2AccessTokenPageVO>> pageOauth2AccessToken(Oauth2AccessTokenListDTO param);


    /**
     * 访问令牌 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult<Oauth2AccessTokenInfoVO> info(String id);

    /**
     * 访问令牌 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult<Boolean> save(Oauth2AccessTokenSaveDTO param);

    /**
     * 访问令牌 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult<Boolean> update(Oauth2AccessTokenUpdateDTO param);

    /**
     * 访问令牌 删除
     * @param param id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult<Boolean> delete(String[] ids);

}