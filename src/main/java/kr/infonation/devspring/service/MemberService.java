package kr.infonation.devspring.service;


import kr.infonation.devspring.domain.member.Member;
import kr.infonation.devspring.dto.member.CreateMember;
import kr.infonation.devspring.dto.member.UpdateMember;
import kr.infonation.devspring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member create(CreateMember.Request request) {
        Member member = memberRepository.save(request.toEntity());
        return member;
    }
    @Transactional
    public Member update(Long id, UpdateMember.Request request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));
        member.update(request.toEntity());
        return member;
    }
}
