package kr.infonation.dto.board;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

public class DeleteBoard {

    @Data
    @AllArgsConstructor
    @ApiModel("DeleteBoard")
    public static class Request{
        private Long id;
    }


    @Data
    @AllArgsConstructor
    @ApiModel("DeleteBoard")
    public static class Response{
        private Long id;
    }
}
