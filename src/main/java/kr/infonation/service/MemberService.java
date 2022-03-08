package kr.infonation.service;


import kr.infonation.domain.member.Member;
import kr.infonation.dto.member.CreateMember;
import kr.infonation.dto.member.MemberDto;
import kr.infonation.dto.member.UpdateMember;
import kr.infonation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public Long deleteMember(Long id) {
        try {
            memberRepository.deleteById(id);
            return id;
        }
        catch (IllegalArgumentException e){
            new IllegalArgumentException("회원이 존재하지 않습니다.");
            return null;
        }
    }

    public List<MemberDto> findByNameLike(String name){
        return memberRepository.findByNameLike("%" + name + "%");
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findById(Long memberId){
        return memberRepository.findById(memberId);
    }
}
