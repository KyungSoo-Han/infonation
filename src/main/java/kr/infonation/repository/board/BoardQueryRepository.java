package kr.infonation.repository.board;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.infonation.domain.board.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

import java.util.List;

import static kr.infonation.domain.board.QBoard.board;

@Repository
@RequiredArgsConstructor
public class BoardQueryRepository {
    private final EntityManager em;
    JPAQueryFactory queryFactory ;

    public List<Board> BoardList(){
        queryFactory = new JPAQueryFactory(em);
        return queryFactory
                .selectFrom(board)
                .fetch();

    }

}
