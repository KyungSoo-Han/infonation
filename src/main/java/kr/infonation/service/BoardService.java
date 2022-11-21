package kr.infonation.service;

import kr.infonation.domain.board.Board;
import kr.infonation.domain.user.User;
import kr.infonation.dto.board.BoardDto;
import kr.infonation.dto.board.CreateBoard;
import kr.infonation.dto.board.UpdateBoard;
import kr.infonation.repository.board.BoardQueryRepository;
import kr.infonation.repository.board.BoardRepository;
import kr.infonation.repository.user.UserQueryRepository;
import kr.infonation.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardQueryRepository boardQueryRepository;
    private final UserRepository userRepository;

    @Transactional
    public Board createBoard(CreateBoard.Request request) {

        Optional<User> user = userRepository.findByLoginIdOptional(request.getLogin_id());
        return boardRepository.save(request.toEntity(user));
    }


    @Transactional
    public Board updateBoard(Long board_id, UpdateBoard.Request request) {
        Board board = boardRepository.findById(board_id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        Optional<User> user = userRepository.findByLoginIdOptional(request.getLogin_id());
        board.update(request.toEntity(user));

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
    public List<BoardDto> findByTitleLike(String title){
        return boardRepository.findByTitleLike("%" + title + "%");
    }

    public List<BoardDto> findQueryDslBoardList(){

        return boardQueryRepository.QueryProjectionBoardList();
    }


}
