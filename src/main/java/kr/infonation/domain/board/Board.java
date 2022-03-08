package kr.infonation.domain.board;

import io.swagger.annotations.ApiModelProperty;
import kr.infonation.base.BaseEntity;
import kr.infonation.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@Getter
@Entity
public class Board extends BaseEntity {

    @Id
    @GeneratedValue
    private Long board_id;
    private String title;
    private String content;

    @ApiModelProperty(hidden = true)
    @ManyToOne(fetch = LAZY)
    private Member member;

    private int viewCnt;


    @Builder
    public Board(String title, String content, Member member, int viewCnt) {
        this.title = title;
        this.content = content;
        this.viewCnt = viewCnt;
        this.member = member;
    }

    public void update(Board board) {
        this.title = board.title;
        this.content = board.content;
        this.viewCnt = board.viewCnt;
        this.member = board.member;
    }

}
