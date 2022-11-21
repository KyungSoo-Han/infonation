package kr.infonation.dto.team;

import io.swagger.annotations.ApiModel;
import kr.infonation.domain.team.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CreateTeam {

    @ApiModel("CreateTeam")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request{

        private String name;
        private String introduce;


        public Team toEntity(){

            return Team.builder()
                    .name(name)
                    .introduce(introduce)
                    .build();
        }

    }

    @ApiModel("CreateTeam")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long team_id;
        private String name;
        private String introduce;
    }
}
