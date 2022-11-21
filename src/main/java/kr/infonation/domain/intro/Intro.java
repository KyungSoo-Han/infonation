package kr.infonation.domain.intro;

import io.swagger.annotations.ApiModelProperty;
import kr.infonation.base.BaseEntity;
import kr.infonation.domain.user.User;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
public class Intro extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;

    @ApiModelProperty(hidden = true)
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private IntroGbn intro_gbn;
}
