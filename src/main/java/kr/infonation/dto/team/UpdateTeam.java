package kr.infonation.dto.team;

import io.swagger.annotations.ApiModel;
import kr.infonation.domain.team.Team;
import lombok.*;

public class UpdateTeam {

    @ApiModel("UpdateTeam")
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Request {
        private String team_nm;
        private String introduce;

        public Team toEntity(){
            System.out.println("team_nm = " + team_nm);
            System.out.println("introduce = " + introduce);
            return Team.builder()
                    .name(team_nm)
                    .introduce(introduce)
                    .build();
        }
    }

    @ApiModel("UpdateTeam")
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Response {
        private String team_nm;
        private String introduce;

    }

}
