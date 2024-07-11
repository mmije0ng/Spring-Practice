package com.test.mytest.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;


public class MemberResponseDto {
    @JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
    @Getter
    @Builder
    public static class MemberInfoDto{
        private Long id;
        private String userName; //사용자 이름
        private String nickName;
        private Integer age;
        private String profileImage;
        private Boolean isMember;
    }
}
