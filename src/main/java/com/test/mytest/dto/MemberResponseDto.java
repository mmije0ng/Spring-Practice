package com.test.mytest.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class MemberResponseDto {
    @Getter
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class MemberInfoDto{
        private Long id;
        private String userName; //사용자 이름
        private String nickName;
        private Integer age;
        private String profileImage;
        private boolean isMember;
    }
}
