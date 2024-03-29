package kr.infonation.repository.board;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.infonation.domain.board.Board;
import kr.infonation.domain.member.Member;
import kr.infonation.dto.board.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select new kr.infonation.dto.board.BoardDto(b.board_id, b.title, b.content,m.name, m.login_id , b.viewCnt) from Board b join b.user m order by b.board_id desc ")
    List<BoardDto> findBoard();

    @Query("select new kr.infonation.dto.board.BoardDto(b.board_id, b.title, b.content,m.name, m.login_id , b.viewCnt) from Board b join b.user m")
    List<BoardDto> findByTitleLike(String title);

}
