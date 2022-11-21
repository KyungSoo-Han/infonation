package kr.infonation.api;

import kr.infonation.domain.intro.Intro;
import kr.infonation.domain.team.Team;
import kr.infonation.dto.Intro.CreateIntro;
import kr.infonation.dto.team.CreateTeam;
import kr.infonation.dto.team.UpdateTeam;
import kr.infonation.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/team")
public class TeamApiController {

    private final TeamService teamService;

    @PostMapping
    public CreateTeam.Response createTeam(@RequestBody CreateTeam.Request request) {

        Team team = teamService.createTeam(request);

        return new CreateTeam.Response(team.getId(), team.getName(), team.getIntroduce());

    }

    @PutMapping(value = "/{id}")
    public UpdateTeam.Response updateTeam(@PathVariable Long id,
                                          @RequestBody UpdateTeam.Request request) {
        System.out.println("request.toString() = " + request);

        Team team = teamService.updateTeam(id, request);
        return new UpdateTeam.Response(team.getName(), team.getIntroduce());
    }

}
