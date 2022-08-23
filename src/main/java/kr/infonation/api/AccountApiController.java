package kr.infonation.api;


import kr.infonation.dto.account.LoginAccount;
import kr.infonation.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountApiController {

    private final MemberService memberService;


}
