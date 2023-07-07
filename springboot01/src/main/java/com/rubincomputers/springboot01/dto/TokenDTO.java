package com.rubincomputers.springboot01.dto;

import com.rubincomputers.springboot01.model.Token;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenDTO {
    private String value;

    public static TokenDTO from(Token token){
        return new TokenDTO(token.getValue());
    }
}
