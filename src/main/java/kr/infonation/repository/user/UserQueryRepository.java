package kr.infonation.repository.user;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.infonation.domain.user.QUser;
import kr.infonation.domain.user.User;
import kr.infonation.dto.account.AuthorityDto;
import kr.infonation.dto.board.BoardDto;
import kr.infonation.dto.user.QUserDto;
import kr.infonation.dto.user.UserDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static kr.infonation.domain.board.QBoard.board;
import static kr.infonation.domain.user.QUser.user;

@Repository
public class UserQueryRepository {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory ;

    public UserQueryRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }


    public UserDto findById(String login_id) {
        UserDto userDto = queryFactory
                .select(new QUserDto(user.login_id, user.username,user.password, user.nickname, user.role))
                .from(user)
                .where(user.login_id.eq(login_id))
                .fetchOne();

        return userDto;

    }
    public Optional<User> findById2(String login_id) {
        return queryFactory
                .selectFrom(user)
                .where(user.login_id.eq(login_id))
                .stream().findFirst();

    }
}
