package kr.infonation.api;

import kr.infonation.domain.member.Member;
import kr.infonation.dto.member.CreateMember;
import kr.infonation.dto.member.UpdateMember;
import kr.infonation.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping
    public CreateMember.Response createMember(@RequestBody CreateMember.Request request) {
        Member member = memberService.create(request);
        return new CreateMember.Response(member);
    }

    @PutMapping("/{id}")
    public UpdateMember.Response updateMember(@PathVariable Long id,
                                              @RequestBody UpdateMember.Request request) {
        Member member = memberService.update(id, request);
        return new UpdateMember.Response(member);
    }







}
