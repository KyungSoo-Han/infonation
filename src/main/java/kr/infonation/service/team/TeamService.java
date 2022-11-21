package kr.infonation.service.team;

import kr.infonation.domain.team.Team;
import kr.infonation.dto.team.CreateTeam;
import kr.infonation.dto.team.UpdateTeam;
import kr.infonation.repository.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public Team createTeam(CreateTeam.Request request){
       return teamRepository.save(request.toEntity());
    }

    public Team findById(Long team_id) {
        return teamRepository.findById(team_id).get();
    }

    @Transactional
    public Team updateTeam(Long team_id, UpdateTeam.Request request) {
        Team team = teamRepository.findById(team_id)
                .orElseThrow(() -> new IllegalArgumentException("팀이 존재하지 않습니다."));

        team.update(request.toEntity());
        return team;
    }
}
