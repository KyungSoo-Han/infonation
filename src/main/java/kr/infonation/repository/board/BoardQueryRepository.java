package kr.infonation.repository.board;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.infonation.domain.board.Board;
import kr.infonation.dto.board.BoardDto;
import kr.infonation.dto.board.QBoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

import java.util.List;

import static kr.infonation.domain.board.QBoard.board;
import static kr.infonation.domain.member.QMember.member;
import static kr.infonation.domain.user.QUser.user;


@Repository
public class BoardQueryRepository {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory ;

    public BoardQueryRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

/*
    public List<Board> BoardList(){
        return queryFactory
                .select(board)
                .from(board)
                .leftJoin(board.member, member).fetchJoin()
                .fetch();

    }
*/

    public List<BoardDto> QueryBoardList() {
        List<BoardDto> boardDtoList = queryFactory
                .select(Projections.fields(BoardDto.class))
                .from(board)
                .orderBy(board.board_id.desc())
                .fetch();

        return boardDtoList;

    }
  public List<BoardDto> QueryProjectionBoardList() {
        List<BoardDto> boardDtoList = queryFactory
                .select(new QBoardDto(board.board_id,board.title,board.content,
                        ExpressionUtils.as(member.name,"username"),user.login_id, board.viewCnt))
                .from(board)
                .leftJoin(board.user, user)
                .fetch();
        System.out.println("boardDtoList = " + boardDtoList);
        return boardDtoList;

    }

}
