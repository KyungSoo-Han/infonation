package kr.infonation.dto.member;

import kr.infonation.domain.member.Address;
import kr.infonation.domain.member.Member;
import kr.infonation.domain.member.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class CreateMember {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {

        private String name;
        private String email;
        private String password;
        private String phoneNo;
        private String birthDate;
        private int age;
        private Address address;
        private Role role;

        public Member toEntity(){
            return Member.builder()
                    .name(name)
                    .email(email)
                    .role(role)
                    .age(age)
                    .address(address)
                    .birthDate(birthDate)
                    .password(password)
                    .phoneNo(phoneNo)
                    .build();
        }

    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {

        private Long member_id;
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

        public Response(Member member) {
            this.member_id = member.getMember_id();
            this.name = member.getName();
            this.email = member.getEmail();
            this.password = member.getPassword();
            this.phoneNo = member.getPhoneNo();
            this.birthDate = member.getBirthDate();
            this.age = member.getAge();
            this.address = member.getAddress();
            this.role = member.getRole();
            this.createdDate = member.getCreatedDate();
            this.modifiedDate = member.getModifiedDate();
        }
    }

}
