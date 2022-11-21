package kr.infonation.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryProjection;
import kr.infonation.domain.user.Role;
import kr.infonation.dto.account.AuthorityDto;
import lombok.*;
import kr.infonation.domain.user.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class UserDto {

   @NotNull
   @Size(min = 3, max = 50)
   private String login_id;

   @NotNull
   @Size(min = 3, max = 50)
   private String name;

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   @NotNull
   @Size(min = 3, max = 100)
   private String password;

   @NotNull
   @Size(min = 3, max = 50)
   private String nickname;

   private Role role;

   @QueryProjection
   public UserDto(String login_id, String name, String password, String nickname, Role role) {
      this.login_id = login_id;
      this.name = name;
      this.password = password;
      this.nickname = nickname;
      this.role = role;
   }

   public static UserDto from(User user) {
      if(user == null) return null;

      return UserDto.builder()
              .login_id(user.getLogin_id())
              .name(user.getName())
              .nickname(user.getNickname())
              .role(user.getRole())
              .build();
   }
}