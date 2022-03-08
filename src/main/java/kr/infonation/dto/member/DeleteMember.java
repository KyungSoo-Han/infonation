package kr.infonation.dto.member;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

public class DeleteMember {

    @Data
    @AllArgsConstructor
    @ApiModel("DeleteMember")
    public static class Request{
        private Long id;
    }


    @Data
    @AllArgsConstructor
    @ApiModel("DeleteMember")
    public static class Response{
        private Long id;
    }
}
