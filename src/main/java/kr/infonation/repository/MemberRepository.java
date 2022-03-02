package kr.infonation.repository;

import kr.infonation.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MemberRepository extends JpaRepository<Member, Long> {



}