package kr.infonation.dto.Intro;


import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.infonation.domain.intro.Intro;
import kr.infonation.domain.intro.IntroGbn;
import kr.infonation.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

public class CreateIntro {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request{
        private String title;
        private String content;
        private Long user_id;
        private IntroGbn intro_gbn;

        public Intro toEntity(Optional<User> user){
            return Intro.builder()
                    .title(title)
                    .content(content)
                    .user(user.orElseThrow())
                    .intro_gbn(intro_gbn)
                    .build();
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long intro_id;
        private String title;
        private String content;

        @JsonIgnore
        private User user;
        private IntroGbn intro_gbn;

        public Response(Intro intro){
            this.intro_id = intro.getId();
            this.title = intro.getTitle();
            this.content = intro.getContent();
            this.user = intro.getUser();
            this.intro_gbn = intro.getIntro_gbn();
        }

    }
}
