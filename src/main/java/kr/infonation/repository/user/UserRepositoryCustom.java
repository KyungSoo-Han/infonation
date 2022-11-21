package kr.infonation.repository.user;

import kr.infonation.domain.user.User;
import kr.infonation.dto.user.UserDto;

import java.util.Optional;

public interface UserRepositoryCustom {

    UserDto findById(String login_id);
    Optional<User> findByLoginIdOptional(String login_id);
    Optional<User> findByIdOptional(Long id);
}
