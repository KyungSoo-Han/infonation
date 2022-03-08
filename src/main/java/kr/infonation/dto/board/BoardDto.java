package kr.infonation.dto.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import kr.infonation.domain.board.Board;
import kr.infonation.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardDto {
    private Long board_id;
    private String title;
    private String content;
    private String name;
    private Long member_id;
    private int viewCnt;

    public BoardDto(Board board) {
        this.board_id = board.getBoard_id();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.name = board.getMember().getName();
        this.member_id = board.getMember().getMember_id();
        this.viewCnt = board.getViewCnt();
    }

}
