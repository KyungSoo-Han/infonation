package kr.infonation.domain.team;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import kr.infonation.base.BaseEntity;
import kr.infonation.domain.meeting.Meeting;
import kr.infonation.domain.mission.Mission;
import kr.infonation.domain.user.User;
import kr.infonation.dto.team.UpdateTeam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;
import static javax.persistence.FetchType.LAZY;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Schema(accessMode = READ_ONLY, hidden = true)
public class Team extends BaseEntity
{

    @GeneratedValue
    @Id
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(
            mappedBy = "team",
            cascade = CascadeType.ALL
    )
    private List<TeamMember> members = new ArrayList<>();

    private String introduce;

    @JsonIgnore
    @OneToMany(
            mappedBy = "team",
            cascade = CascadeType.ALL
    )
    private List<Meeting> meeting = new ArrayList<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "team",
            cascade = CascadeType.ALL
    )
    private List<Mission> mission = new ArrayList<>();

    public void update(Team request) {
        this.name = request.getName();
        this.introduce = request.getIntroduce();

        System.out.println("request = " + request.introduce);
    }

}
