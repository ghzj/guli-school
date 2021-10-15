package io.github.ghzj.guli.system.convert;

import io.github.ghzj.guli.system.entity.Oauth2AccessTokenEntity;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.access.token.Oauth2AccessTokenSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.access.token.Oauth2AccessTokenUpdateDTO;
import io.github.ghzj.guli.system.object.view.oauth2.access.token.Oauth2AccessTokenPageVO;
import io.github.ghzj.guli.system.object.view.oauth2.access.token.Oauth2AccessTokenInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 访问令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Mapper
public interface  Oauth2AccessTokenMapStruct {
    Oauth2AccessTokenMapStruct INSTANCE = Mappers.getMapper(Oauth2AccessTokenMapStruct.class);

    /**
    * @param param Oauth2AccessTokenSaveDTO
    * @return DTO2P
    */
    Oauth2AccessTokenEntity DTO2P(Oauth2AccessTokenSaveDTO param);

    /**
    * @param param Oauth2AccessTokenUpdateDTO
    * @return DTO2P
    */
    Oauth2AccessTokenEntity DTO2P(Oauth2AccessTokenUpdateDTO param);

    /**
     * @param param Oauth2AccessTokenEntity
     * @return P2IV
     */
    Oauth2AccessTokenInfoVO P2IV(Oauth2AccessTokenEntity param);

    /**
     * @param param Oauth2AccessTokenEntity
     * @return P2GV
     */
    Oauth2AccessTokenPageVO P2GV(Oauth2AccessTokenEntity param);

    /**
     * @param param Oauth2AccessTokenEntity
     * @return P2GV
     */
    List<Oauth2AccessTokenPageVO> P2GV(List<Oauth2AccessTokenEntity> param);

    /**
     * @param param Oauth2AccessTokenEntity
     * @return P2GV
     */
    PageUtils<Oauth2AccessTokenPageVO> P2GV(PageUtils<Oauth2AccessTokenEntity> param);
}
