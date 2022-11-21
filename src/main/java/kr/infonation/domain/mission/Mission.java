package kr.infonation.domain.mission;


import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.infonation.base.BaseEntity;
import kr.infonation.domain.meeting.Meeting;
import kr.infonation.domain.team.Team;
import kr.infonation.domain.team.TeamMember;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@Getter
@Entity
public class Mission extends BaseEntity {

    @Column(name = "mission_id")
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int point;

    @Enumerated(EnumType.STRING)
    private MissionLevel level;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "team_member_id")
    private TeamMember teamMember;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

}
