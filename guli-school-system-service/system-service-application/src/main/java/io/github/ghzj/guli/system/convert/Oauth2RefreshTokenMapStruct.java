package io.github.ghzj.guli.system.convert;

import io.github.ghzj.guli.system.entity.Oauth2RefreshTokenEntity;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.refresh.token.Oauth2RefreshTokenSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.refresh.token.Oauth2RefreshTokenUpdateDTO;
import io.github.ghzj.guli.system.object.view.oauth2.refresh.token.Oauth2RefreshTokenPageVO;
import io.github.ghzj.guli.system.object.view.oauth2.refresh.token.Oauth2RefreshTokenInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 刷新令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Mapper
public interface  Oauth2RefreshTokenMapStruct {
    Oauth2RefreshTokenMapStruct INSTANCE = Mappers.getMapper(Oauth2RefreshTokenMapStruct.class);

    /**
    * @param param Oauth2RefreshTokenSaveDTO
    * @return DTO2P
    */
    Oauth2RefreshTokenEntity DTO2P(Oauth2RefreshTokenSaveDTO param);

    /**
    * @param param Oauth2RefreshTokenUpdateDTO
    * @return DTO2P
    */
    Oauth2RefreshTokenEntity DTO2P(Oauth2RefreshTokenUpdateDTO param);

    /**
     * @param param Oauth2RefreshTokenEntity
     * @return P2IV
     */
    Oauth2RefreshTokenInfoVO P2IV(Oauth2RefreshTokenEntity param);

    /**
     * @param param Oauth2RefreshTokenEntity
     * @return P2GV
     */
    Oauth2RefreshTokenPageVO P2GV(Oauth2RefreshTokenEntity param);

    /**
     * @param param Oauth2RefreshTokenEntity
     * @return P2GV
     */
    List<Oauth2RefreshTokenPageVO> P2GV(List<Oauth2RefreshTokenEntity> param);

    /**
     * @param param Oauth2RefreshTokenEntity
     * @return P2GV
     */
    PageUtils<Oauth2RefreshTokenPageVO> P2GV(PageUtils<Oauth2RefreshTokenEntity> param);
}
