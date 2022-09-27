package kr.infonation.dto.member;

import kr.infonation.domain.member.Address;
import kr.infonation.domain.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {
    private Long member_id;
    private String loginId;
    private String name;
    private String email;
    private String phoneNo;
    private String birthDate;
    private int age;
    private Address address;
    private Role role;


}