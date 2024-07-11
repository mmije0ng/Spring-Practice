package com.test.mytest.service;

import com.test.mytest.dto.MemberResponseDto;
import com.test.mytest.entity.Member;
import com.test.mytest.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    public MemberResponseDto.MemberInfoDto findMemberByUserName(String userName){
        log.info("MemberService userName: "+userName);

        List<Member> allMembers = memberRepository.findAll();
        allMembers.forEach(member -> log.info(member.getUserName()));

        Member member = memberRepository.findByUserName(userName)
                .orElseThrow( () -> new IllegalArgumentException("일치하는 멤버가 없습니다.") );

        return MemberResponseDto.MemberInfoDto.builder()
                .id(member.getId())
                .userName(member.getUserName())
                .nickName(member.getNickName())
                .age(member.getAge())
                .profileImage(member.getProfileImage())
                .isMember(true)
                .build();
    }
}
