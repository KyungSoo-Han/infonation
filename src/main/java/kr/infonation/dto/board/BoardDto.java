package kr.infonation.dto.board;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class BoardDto {
    private Long board_id;
    private String title;
    private String content;
    private String name;
    private String login_id;
    private int viewCnt;

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
