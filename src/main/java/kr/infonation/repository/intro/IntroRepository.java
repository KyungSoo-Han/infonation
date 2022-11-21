package kr.infonation.repository.intro;

import kr.infonation.domain.intro.Intro;
import kr.infonation.dto.Intro.CreateIntro;
import kr.infonation.dto.Intro.IntroDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntroRepository extends JpaRepository<Intro,Long> {

}
