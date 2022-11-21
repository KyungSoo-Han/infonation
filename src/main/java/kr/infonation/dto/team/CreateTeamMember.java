package kr.infonation.dto.team;

import io.swagger.annotations.ApiModel;
import kr.infonation.domain.team.Team;
import kr.infonation.domain.team.TeamMember;
import kr.infonation.domain.team.TeamRole;
import kr.infonation.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CreateTeamMember {

    @ApiModel("CreateTeamMember")
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Request{

        private TeamRole teamRole;
        private Long team_id;
        private Long user_id;

        public TeamMember toEntity(Team team, User user){

            return TeamMember.builder()
                    .role(teamRole)
                    .user(user)
                    .team(team)
                    .build();
        }

    }

    @ApiModel("CreateTeamMember")
    @NoArgsConstructor
    @Data
    public static class Response{

        private TeamRole teamRole;
        private String team_name;
        private String member_name;

        public Response(TeamRole teamRole, String teamNm, String memberNm) {
            this.teamRole = teamRole;
            this.team_name = teamNm;
            this.member_name = memberNm;
        }
    }

}
