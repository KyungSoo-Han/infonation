package kr.infonation.repository.team;

import kr.infonation.domain.team.Team;
import kr.infonation.domain.team.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamMemberRepository extends JpaRepository<TeamMember,Long> {

    @Query("select tm from TeamMember tm where tm.team.id = :team_id and tm.user.id = :user_id")
    List<TeamMember> checkDuplicate(@Param("team_id") Long team_id, @Param("user_id") Long user_id);
}
