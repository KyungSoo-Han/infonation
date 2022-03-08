package kr.infonation.service;

import kr.infonation.domain.board.Board;
import kr.infonation.domain.member.Member;
import kr.infonation.dto.board.BoardDto;
import kr.infonation.dto.board.CreateBoard;
import kr.infonation.dto.board.DeleteBoard;
import kr.infonation.dto.board.UpdateBoard;
import kr.infonation.repository.board.BoardRepository;
import kr.infonation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Board createBoard(CreateBoard.Request request) {

        Optional<Member> member = memberRepository.findById(request.getMember_id());
        return boardRepository.save(request.toEntity(member));
    }

    @Transactional
    public Board updateBoard(Long board_id, UpdateBoard.Request request) {
        Board board = boardRepository.findById(board_id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        Optional<Member> member = memberRepository.findById(request.getMember_id());
        board.update(request.toEntity(member));

        return board;
    }

    @Transactional
    public Long deleteBoard(Long board_id) {
        try {
            boardRepository.deleteById(board_id);
            return board_id;
        } catch (IllegalArgumentException e) {
            new IllegalArgumentException("게시글이 존재하지 않습니다.");
            return null;
        }
    }

    public List<BoardDto> findBoardList(){
        List<BoardDto> boardDtos = boardRepository.findBoard();
        return boardDtos;
    }

}
