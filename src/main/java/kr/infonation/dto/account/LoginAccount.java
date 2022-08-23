package kr.infonation.dto.account;

import kr.infonation.domain.member.Address;
import kr.infonation.domain.member.Role;
import lombok.Data;

@Data
public class LoginAccount {

    public static class Request {
        private String name;
        private String email;
        private int age;
        private Address address;
        private Role role;
    }


}
