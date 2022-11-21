package kr.infonation.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import kr.infonation.base.BaseEntity;
import kr.infonation.domain.board.Board;
import kr.infonation.domain.member.Address;
import kr.infonation.domain.team.TeamMember;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Entity
@Table(name = "`user`")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(accessMode = READ_ONLY, hidden = true)
public class User extends BaseEntity {

   @Id
   //@Column(name = "user_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "login_id", length = 50, unique = true, nullable = false)
   private String login_id;

   @Column(name = "name", length = 50, nullable = false)
   private String name;

   @Column(name = "password", length = 100, nullable = false)
   private String password;

   @Column(name = "email", length = 100, nullable = false)
   private String email;

   @Column(name = "nickname", length = 50)
   private String nickname;

   @Column(name = "activated")
   private boolean activated;

   private String phoneNo;

   private String birthDate;

   private int age;

   @JsonIgnore
   @Embedded
   private Address address;

   @Enumerated(EnumType.STRING)
   private Role role;

   @JsonIgnore
   @OneToMany(mappedBy = "user", orphanRemoval = true)
   private List<Board> boards;

   @JsonIgnore
   @OneToMany(
           mappedBy = "user",
           cascade = CascadeType.ALL
   )
   private final List<TeamMember> belongs = new ArrayList<>();

   @Builder
   public User(String login_id, String name, String password, String email, String nickname, boolean activated, String phoneNo, String birthDate, int age, Address address, Role role) {
      this.login_id = login_id;
      this.name = name;
      this.password = password;
      this.email = email;
      this.nickname = nickname;
      this.activated = activated;
      this.phoneNo = phoneNo;
      this.birthDate = birthDate;
      this.age = age;
      this.address = address;
      this.role = role;
   }
}
