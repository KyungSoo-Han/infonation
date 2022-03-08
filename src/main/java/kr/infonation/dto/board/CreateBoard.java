package kr.infonation.dto.board;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kr.infonation.domain.board.Board;
import kr.infonation.domain.member.Member;
import kr.infonation.dto.member.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


public class CreateBoard {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ApiModel("CreateBoard")
    public static class Request{

        @ApiModelProperty(value = "제목")
        private String title;
        @ApiModelProperty(value = "내용")
        private String content;
        @ApiModelProperty(value = "회원 ID")
        private Long member_id;
        @ApiModelProperty(value = "조회수")
        private int viewCnt;

        public Board toEntity(Optional<Member> member){
            return Board.builder()
                    .title(title)
                    .content(content)
                    .member(member.orElseThrow())
                    .viewCnt(viewCnt)
                    .build();
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel("CreateBoard")
    public static class Response{

        @ApiModelProperty(value = "게시판 ID")
        private Long board_id;
        @ApiModelProperty(value = "제목")
        private String title;
        @ApiModelProperty(value = "내용")
        private String content;
        @ApiModelProperty(value = "회원")
        private MemberDto member;
        @ApiModelProperty(value = "조회수")
        private int viewCnt;

        public Response(Board board, MemberDto memberDto) {
            this.board_id = board.getBoard_id();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.member = memberDto;
            this.viewCnt = board.getViewCnt();
        }
    }
}
