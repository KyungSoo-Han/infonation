package kr.infonation.dto.user;

import io.swagger.annotations.ApiModel;
import kr.infonation.domain.member.Address;
import kr.infonation.domain.member.Member;
import kr.infonation.domain.user.Role;
import kr.infonation.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

public class CreateUser {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ApiModel("CreateUser")
    public static class Request {
        private String login_id;
        private String name;
        private String email;
        private String password;
        private String phoneNo;
        private String birthDate;
        private int age;
        private Address address;
        private boolean activated;
        private Role role;

        public User toEntity(PasswordEncoder passwordEncoder) {
            return User.builder()
                    .login_id(login_id)
                    .name(name)
                    .email(email)
                    .role(role)
                    .age(age)
                    .address(address)
                    .birthDate(birthDate)
                    .password(passwordEncoder.encode(password))
                    .phoneNo(phoneNo)
                    .activated(activated)
                    .build();
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel("CreateUser")
    public static class Response {

        private Long user_id;
        private String login_id;
        private String name;
        private String email;
        private String password;
        private String phoneNo;
        private String birthDate;
        private int age;
        private Address address;
        private Role role;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;

        public Response(User user) {
            this.user_id = user.getId();
            this.login_id = user.getLogin_id();
            this.name = user.getName();
            this.email = user.getEmail();
            this.password = user.getPassword();
            this.phoneNo = user.getPhoneNo();
            this.birthDate = user.getBirthDate();
            this.age = user.getAge();
            this.address = user.getAddress();
            this.role = user.getRole();
            this.createdDate = user.getCreatedDate();
            this.modifiedDate = user.getModifiedDate();
        }
    }
}
