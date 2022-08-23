package kr.infonation.repository.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.infonation.domain.member.Member;
import kr.infonation.domain.member.QMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import static kr.infonation.domain.member.QMember.member;

@Repository
@RequiredArgsConstructor
public class MemberQueryRepository {
    private final EntityManager em;
    JPAQueryFactory queryFactory ;


    public Member test(Long memberId){
        queryFactory = new JPAQueryFactory(em);
        return queryFactory
                .select(member)
                .from(member)
                .where(member.member_id.eq(memberId))
                .fetchOne();

    }
}
