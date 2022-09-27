package kr.infonation.dto.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.querydsl.core.annotations.QueryProjection;
import kr.infonation.domain.board.Board;
import kr.infonation.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BoardDto {
    private Long board_id;
    private String title;
    private String content;
    private String name;
    private String login_id;
    private int viewCnt;

    public BoardDto(Board board) {
        this.board_id = board.getBoard_id();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.name = board.getUser().getUsername();
        this.login_id = board.getUser().getLogin_id();
        this.viewCnt = board.getViewCnt();
    }

    @QueryProjection
    public BoardDto(Long board_id, String title, String content, String name, String login_id, int viewCnt) {
        this.board_id = board_id;
        this.title = title;
        this.content = content;
        this.name = name;
        this.login_id = login_id;
        this.viewCnt = viewCnt;
    }

}
