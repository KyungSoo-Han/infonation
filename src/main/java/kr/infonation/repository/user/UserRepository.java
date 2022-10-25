package kr.infonation.repository.user;

import kr.infonation.domain.user.User;
import kr.infonation.dto.user.UserDto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> , UserRepositoryCustom{

}
