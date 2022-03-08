package kr.infonation.repository.board;

import kr.infonation.dto.board.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardQueryRepository {
    private final EntityManager em;

}
