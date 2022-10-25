package kr.infonation.service;

import kr.infonation.dto.user.CreateUser;
import kr.infonation.dto.user.UserDto;
import kr.infonation.domain.user.User;
import kr.infonation.exception.DuplicateMemberException;
import kr.infonation.exception.NotFoundMemberException;
import kr.infonation.repository.user.UserRepository;
import kr.infonation.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User create(CreateUser.Request request) {
        if (userRepository.findByIdOptional(request.getLogin_id()).orElse(null) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }

        User user = userRepository.save(request.toEntity(passwordEncoder));
        return user;
    }

    @Transactional
    public UserDto signup(UserDto userDto) {
        if (userRepository.findByIdOptional(userDto.getLogin_id()).orElse(null) != null) {
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
        System.out.println("getUserWithAuthorities login_id = " + login_id);
        return UserDto.from(userRepository.findByIdOptional(login_id).orElse(null));
    }

    @Transactional(readOnly = true)
    public UserDto getMyUserWithAuthorities() {
        return UserDto.from(
                SecurityUtil.getCurrentUsername()
                        .flatMap(userRepository::findByIdOptional)
                        .orElseThrow(() -> new NotFoundMemberException("Member not found"))
        );
    }
}
