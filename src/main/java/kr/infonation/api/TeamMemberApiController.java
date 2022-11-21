package kr.infonation.api;

import kr.infonation.domain.team.TeamMember;
import kr.infonation.dto.team.CreateTeamMember;
import kr.infonation.service.team.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/api/teamMember")
@RestController
public class TeamMemberApiController {

    private final TeamMemberService teamMemberService;

    @PostMapping
    public CreateTeamMember.Response createTeamMember(@RequestBody CreateTeamMember.Request request){

        TeamMember teamMember = teamMemberService.createTeamMember(request);
        return new CreateTeamMember.Response(teamMember.getRole(),teamMember.getTeam().getName(), teamMember.getUser().getName());
    }



}
