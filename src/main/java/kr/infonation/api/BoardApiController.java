package kr.infonation.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.infonation.domain.board.Board;
import kr.infonation.domain.member.Member;
import kr.infonation.dto.board.BoardDto;
import kr.infonation.dto.board.CreateBoard;
import kr.infonation.dto.board.DeleteBoard;
import kr.infonation.dto.board.UpdateBoard;
import kr.infonation.dto.member.MemberDto;
import kr.infonation.repository.MemberRepository;
import kr.infonation.service.BoardService;
import kr.infonation.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardApiController {

    private final BoardService boardService;
    private final MemberRepository memberRepository;

    @ApiOperation(value = "게시판 등록")
    @PostMapping(produces = "application/json; charset=UTF-8")
    public CreateBoard.Response createBoard(
            @ApiParam(value = "게시판 등록 Request")
            @RequestBody CreateBoard.Request boardRequest) {

        Board board = boardService.createBoard(boardRequest);
        Long member_id = boardRequest.getMember_id();
        Optional<MemberDto> memberDto = memberRepository.findByIds(member_id);
        return new CreateBoard.Response(board, memberDto.orElseThrow());

    }

    @ApiOperation(value = "게시판 수정")
    @PutMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
    public UpdateBoard.Response updateBoard(@PathVariable Long id, @RequestBody UpdateBoard.Request request) {

        Board board = boardService.updateBoard(id, request);
        Long member_id = request.getMember_id();
        Optional<MemberDto> memberDto = memberRepository.findByIds(member_id);
        return new UpdateBoard.Response(board,memberDto.orElseThrow());
    }

    @ApiOperation(value = "게시판 삭제")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public DeleteBoard.Response deleteBoard(@PathVariable Long id) {

        boardService.deleteBoard(id);
        return new DeleteBoard.Response(id);
    }


    @ApiOperation(value = "게시판 리스트 조회")
    @GetMapping
    public Result boardList(){
        List<BoardDto> boards = boardService.findBoardList();
        return new Result(boards.size(), boards);
    }


    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }

}
