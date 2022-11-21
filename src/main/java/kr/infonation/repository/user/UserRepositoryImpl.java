package kr.infonation.repository.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.infonation.domain.user.User;
import kr.infonation.dto.user.QUserDto;
import kr.infonation.dto.user.UserDto;

import javax.persistence.EntityManager;
import java.util.Optional;

import static kr.infonation.domain.user.QUser.user;

public class UserRepositoryImpl implements UserRepositoryCustom{
    private final JPAQueryFactory queryFactory ;

    public UserRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public UserDto findById(String login_id) {
        UserDto userDto = queryFactory
                .select(new QUserDto(user.login_id, user.name,user.password, user.nickname, user.role))
                .from(user)
                .where(user.login_id.eq(login_id))
                .fetchOne();

        return userDto;
    }

    @Override
    public Optional<User> findByLoginIdOptional(String login_id) {

        return queryFactory
                .selectFrom(user)
                .where(user.login_id.eq(login_id))
                .stream().findFirst();
    }

    @Override
    public Optional<User> findByIdOptional(Long user_id) {

        return queryFactory
                .selectFrom(user)
                .where(user.id.eq(user_id))
                .stream().findFirst();
    }
}
