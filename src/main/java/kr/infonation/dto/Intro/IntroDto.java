package kr.infonation.dto.Intro;

import kr.infonation.domain.intro.IntroGbn;
import kr.infonation.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IntroDto {
    private Long intro_id;
    private String title;
    private String content;
    private IntroGbn introGbn;
    private User user;

    public IntroDto(Long intro_id, String title, String content, IntroGbn introGbn, User user) {
        this.intro_id = intro_id;
        this.title = title;
        this.content = content;
        this.introGbn = introGbn;
        this.user = user;
    }
}
