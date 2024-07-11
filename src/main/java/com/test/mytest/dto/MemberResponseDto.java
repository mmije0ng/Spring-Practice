package com.test.mytest.dto;

import lombok.Builder;
import lombok.Getter;

public class MemberResponseDto {
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
