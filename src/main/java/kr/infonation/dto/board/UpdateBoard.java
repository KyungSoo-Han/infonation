package kr.infonation.dto.board;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kr.infonation.domain.board.Board;
import kr.infonation.domain.member.Member;
import kr.infonation.domain.user.User;
import kr.infonation.dto.member.MemberDto;
import kr.infonation.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


public class UpdateBoard {


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    @ApiModel("UpdateBoard")
    public static class Request{

        @ApiModelProperty(value = "제목")
        private String title;
        @ApiModelProperty(value = "내용")
        private String content;
        @ApiModelProperty(value = "회원 ID")
        private String login_id;
        @ApiModelProperty(value = "조회수")
        private int viewCnt;

        public Board toEntity(Optional<User> user){
            return Board.builder()
                    .title(title)
                    .content(content)
                    .user(user.orElseThrow())
                    .viewCnt(viewCnt)
                    .build();
        }

    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel("UpdateBoard")
    public static class Response{

        @ApiModelProperty(value = "게시판 ID")
        private Long board_id;
        @ApiModelProperty(value = "제목")
        private String title;
        @ApiModelProperty(value = "내용")
        private String content;
        @ApiModelProperty(value = "회원")
        private UserDto user;
        @ApiModelProperty(value = "조회수")
        private int viewCnt;

        public Response(Board board, UserDto userDto) {
            this.board_id = board.getBoard_id();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.user = userDto;
            this.viewCnt = board.getViewCnt();
        }
    }
}
