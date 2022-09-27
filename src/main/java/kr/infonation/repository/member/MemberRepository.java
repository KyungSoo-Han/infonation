package kr.infonation.repository.member;

import kr.infonation.domain.member.Member;
import kr.infonation.dto.member.MemberDto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select new kr.infonation.dto.member.MemberDto(m.member_id, m.loginId, m.name, m.email, m.phoneNo, m.birthDate, m.age, m.address, m.role) from Member m ")
    List<MemberDto> findByNameLike(String name);

    @Query("select new kr.infonation.dto.member.MemberDto(m.member_id, m.loginId, m.name, m.email, m.phoneNo, m.birthDate, m.age, m.address, m.role) from Member m where m.member_id = :id")
    Optional<MemberDto> findByIds(@Param("id") Long id);

        /*

         */

}