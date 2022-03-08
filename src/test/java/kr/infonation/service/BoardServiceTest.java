package kr.infonation.service;

import kr.infonation.dto.board.CreateBoard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    void createBoard() {
        CreateBoard.Request request = CreateBoard.Request.builder()
                .content("테스트")
                .title("제목")
                .viewCnt(1)
                .build();
    }
}