package com.mangostreet.mangostreetserspring.converter;

import com.mangostreet.mangostreetserspring.dataobject.User;
import com.mangostreet.mangostreetserspring.dto.TokenDTO;

public class User2TokenDTOConverter {

    public static TokenDTO convert(User user) {

        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setUserToken(user.getUserToken());
        return tokenDTO;
    }
}