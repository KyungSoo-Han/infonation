package kr.infonation.domain.member;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.infonation.base.BaseEntity;
import kr.infonation.domain.user.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@NoArgsConstructor
@Entity
@Getter
@Schema(accessMode = READ_ONLY)
public class Member extends BaseEntity {

    @Id @GeneratedValue
    private Long member_id;
    private String loginId;
    private String name;
    private String email;
    private String password;
    private String phoneNo;
    private String birthDate;
    private int age;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String loginId, String name, String email, String password, String phoneNo, String birthDate, int age, Address address, Role role) {
        this.loginId = loginId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.birthDate = birthDate;
        this.age = age;
        this.address = address;
        this.role = role;
    }

    public void update(Member request) {
        this.name = request.name;
        this.email = request.email;
        this.password = request.password;
        this.phoneNo = request.phoneNo;
        this.birthDate = request.birthDate;
        this.age = request.age;
        this.address = request.address;
        this.role = request.role;
    }
}
