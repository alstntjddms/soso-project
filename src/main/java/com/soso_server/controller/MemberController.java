package com.soso_server.controller;

import com.soso_server.dto.MemberDTO;
import com.soso_server.service.itf.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    /**
     * 암호화된 kakao테이블 id로 정보를 찾아 멤버에 등록한다.
     * @param id
     * @return 암호화된 member의 userId
     * @throws Exception
     */
    @PostMapping("/member")
    public ResponseEntity<String> registerMember(@RequestBody String id){
        try {
            return new ResponseEntity<>(memberService.registerMember(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(-999, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * userId로 Member를 찾는다.
     * @param userId
     * @return MemberDTO
     * @throws Exception
     */
    @GetMapping("/memberbyuserid/{userId}")
    public ResponseEntity<MemberDTO> findMemberByUserId(@PathVariable String userId){
        try {
            return new ResponseEntity<>(memberService.findMemberByUserId(userId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(-999, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * 모든 멤버를 조회한다.
     * @return List<MemberDTO>
     */
    @GetMapping("/memberall")
    public ResponseEntity<List<MemberDTO>> findMemberAll(){
        try {
            return new ResponseEntity<>(memberService.findMemberAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(-999, HttpStatus.BAD_REQUEST);
        }
    }

}
