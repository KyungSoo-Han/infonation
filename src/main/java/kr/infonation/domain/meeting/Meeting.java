package kr.infonation.domain.meeting;


import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.infonation.base.BaseEntity;
import kr.infonation.domain.team.Team;
import kr.infonation.domain.team.TeamMember;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@Getter
@Entity
public class Meeting extends BaseEntity {

    @Column(name = "meeting_id")
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String startDate;
    private String endDate;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @JsonIgnore
    @OneToMany(
            mappedBy = "team",
            cascade = CascadeType.ALL
    )
    private List<TeamMember> members = new ArrayList<>();


}
