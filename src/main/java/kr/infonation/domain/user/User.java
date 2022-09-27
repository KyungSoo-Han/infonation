package kr.infonation.domain.user;

import kr.infonation.base.BaseEntity;
import kr.infonation.domain.board.Board;
import kr.infonation.domain.member.Address;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "`user`")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

   @Id
   @Column(name = "user_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long user_id;

   @Column(name = "login_id", length = 50, unique = true, nullable = false)
   private String login_id;

   @Column(name = "username", length = 50, nullable = false)
   private String username;

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

   @Embedded
   private Address address;

   @Enumerated(EnumType.STRING)
   private Role role;

   @OneToMany(mappedBy = "user", orphanRemoval = true)
   private List<Board> boards;

   @Builder
   public User(String login_id, String username, String password, String email, String nickname, boolean activated, String phoneNo, String birthDate, int age, Address address, Role role) {
      this.login_id = login_id;
      this.username = username;
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
