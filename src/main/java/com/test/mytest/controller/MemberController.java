package com.test.mytest.controller;

import com.test.mytest.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "MemberController", description = "Member API")
@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }

    @Operation(summary = "사용자 이름으로 멤버 조회", description = "사용자 이름 userName과 일치하는 Member 조회 API")
    @GetMapping()
    public ResponseEntity<?> findMemberByUserName(@RequestParam(name="userName") String userName){
        try {
            return ResponseEntity.ok(memberService.findMemberByUserName(userName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @Operation(summary = "모든 멤버 조회", description = "db에 저장되어 있는 모든 Member 조회 API")
    @GetMapping("/all")
    public ResponseEntity<?> findAllMembers(){
        try {
            return ResponseEntity.ok(memberService.findAllMembers());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}