package kr.infonation.devspring.repository;

import kr.infonation.devspring.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MemberRepository extends JpaRepository<Member, Long> {



}