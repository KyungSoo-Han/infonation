package kr.infonation.api;

import kr.infonation.dto.board.UpdateBoard;
import kr.infonation.dto.member.MemberDto;
import kr.infonation.repository.MemberRepository;
import kr.infonation.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardApiControllerTest {

    @Autowired
    BoardService boardService;

    @Autowired
    MemberRepository memberRepository;


    @Test
    void updateBoard() {
        //Optional<MemberDto> memberdto = memberRepository.findByIds(1L);

        UpdateBoard.Request request = new UpdateBoard.Request();
        request.setContent("수정");
        request.setViewCnt(2);
        request.setTitle("SUBJECT UPDATE");
        request.setMember_id(1L);

        boardService.updateBoard(2L, request);
    }
}