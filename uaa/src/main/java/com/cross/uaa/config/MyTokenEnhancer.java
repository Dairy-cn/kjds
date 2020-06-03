package com.cross.uaa.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cross.uaa.handler.GlobalException;
import com.cross.utils.JsonUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/10
 ************************************************************/
public class MyTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        com.cross.uaa.security.QxhUserDetail user = (com.cross.uaa.security.QxhUserDetail) authentication.getPrincipal();
        final Map<String, Object> additionalInfo = new HashMap<>();
        //校验
        Collection<GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> stringList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(authorities)) {
            stringList = authorities.stream().map(GrantedAuthority::getAuthority).map(String::toString).collect(Collectors.toList());
        }
        Object details = authentication.getUserAuthentication().getDetails();
        Map<String, String> stringStringMap = JsonUtil.jsonToMap(details.toString());
        String web_type = stringStringMap.get("web_type");
        if ("user".equals(web_type)) {

            if (CollectionUtils.isEmpty(stringList) || !stringList.contains("ROLE_USER")) {
                additionalInfo.put("id", -1L);
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
                return accessToken;
            }
        } else if ("merchant".equals(web_type)) {
            if (CollectionUtils.isEmpty(stringList) || !stringList.contains("ROLE_ADMIN")) {
                additionalInfo.put("id", -1L);
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
                return accessToken;
            }
        } else if ("admin".equals(web_type)) {
            if (CollectionUtils.isEmpty(stringList) || !stringList.contains("ROLE_SUPER_ADMIN")) {
                additionalInfo.put("id", -1L);
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
                return accessToken;
            }
        } else {
            additionalInfo.put("id", null);
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        }
        additionalInfo.put("id", user.getUserId());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
