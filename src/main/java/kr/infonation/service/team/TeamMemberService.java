package kr.infonation.service.team;

import kr.infonation.domain.team.Team;
import kr.infonation.domain.team.TeamMember;
import kr.infonation.domain.user.User;
import kr.infonation.dto.team.CreateTeamMember;
import kr.infonation.repository.team.TeamMemberRepository;
import kr.infonation.repository.team.TeamRepository;
import kr.infonation.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    @Transactional
    public TeamMember createTeamMember(CreateTeamMember.Request request){

        Team team = teamRepository.findById(request.getTeam_id()).get();
        User user = userRepository.findById(request.getUser_id()).get();

        List<TeamMember> findTeamMember= teamMemberRepository.checkDuplicate(team.getId(), user.getId());
        if(!findTeamMember.isEmpty())
            throw new IllegalStateException("이미 모임에 가입되어 있습니다.");

        TeamMember teamMember = request.toEntity(team, user);

        return teamMemberRepository.save(teamMember);
    }

}
