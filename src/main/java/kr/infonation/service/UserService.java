package kr.infonation.service;

import kr.infonation.dto.user.CreateUser;
import kr.infonation.dto.user.UserDto;
import kr.infonation.domain.user.User;
import kr.infonation.exception.DuplicateMemberException;
import kr.infonation.exception.NotFoundMemberException;
import kr.infonation.repository.user.UserQueryRepository;
import kr.infonation.repository.user.UserRepository;
import kr.infonation.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserQueryRepository userQueryRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserQueryRepository userQueryRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userQueryRepository = userQueryRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User create(CreateUser.Request request) {
        if (userQueryRepository.findById2(request.getLogin_id()).orElse(null) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }

        User user = userRepository.save(request.toEntity(passwordEncoder));
        return user;
    }

    @Transactional
    public UserDto signup(UserDto userDto) {
        if (userQueryRepository.findById2(userDto.getLogin_id()).orElse(null) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }

        User user = User.builder()
                .username(userDto.getUsername())
                .login_id(userDto.getLogin_id())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .role(userDto.getRole())
                .activated(true)
                .build();

        return UserDto.from(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    public UserDto getUserWithAuthorities(String login_id) {
        return UserDto.from(userQueryRepository.findById2(login_id).orElse(null));
    }

    @Transactional(readOnly = true)
    public UserDto getMyUserWithAuthorities() {
        return UserDto.from(
                SecurityUtil.getCurrentUsername()
                        .flatMap(userQueryRepository::findById2)
                        .orElseThrow(() -> new NotFoundMemberException("Member not found"))
        );
    }
}
