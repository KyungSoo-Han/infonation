package kr.infonation.api;

import io.swagger.annotations.ApiOperation;
import kr.infonation.domain.member.Member;
import kr.infonation.dto.member.CreateMember;
import kr.infonation.dto.member.DeleteMember;
import kr.infonation.dto.member.MemberDto;
import kr.infonation.dto.member.UpdateMember;
import kr.infonation.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberApiController {

    private final MemberService memberService;

    @ApiOperation(value = "회원 등록")
    @PostMapping( produces = "application/json; charset=UTF-8")
    public CreateMember.Response createMember(@RequestBody CreateMember.Request request) {
        Member member = memberService.create(request);
        return new CreateMember.Response(member);
    }

    @ApiOperation(value = "회원정보 수정")
    @PutMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
    public UpdateMember.Response updateMember(@PathVariable Long id,
                                              @RequestBody UpdateMember.Request request) {
        Member member = memberService.update(id, request);
        return new UpdateMember.Response(member);
    }

    @ApiOperation(value = "회원 탈퇴")
    @DeleteMapping(value="/{id}", produces = "application/json; charset=UTF-8")
    public DeleteMember.Response deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return new DeleteMember.Response(id);
    }

    @ApiOperation(value = "회원 리스트 조회")
    @GetMapping
    public Result memberList(){
        List<Member> members = memberService.findMembers();

        List<MemberDto> collect = members.stream()
                .map(m -> new MemberDto(m.getMember_id(), m.getName(), m.getEmail()))
                .collect(Collectors.toList());

        return new Result(collect.size(), collect);
    }

    @ApiOperation(value = "회원 아이디로 조회")
    @GetMapping("/id/{id}")
    public Result memberById(@PathVariable Long id){
        Optional<Member> members = memberService.findById(id);

        List<MemberDto> collect = members.stream()
                .map(m -> new MemberDto(m.getMember_id(), m.getName(), m.getEmail()))
                .collect(Collectors.toList());

        return new Result(collect.size(), collect);
    }

    @ApiOperation(value = "회원 이름으로 조회")
    @GetMapping("/name/{name}")
    public Result memberListNameLike(@PathVariable String name){
        List<MemberDto> members = memberService.findByNameLike(name);

        return new Result(members.size(), members);
    }

    public

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }





}
