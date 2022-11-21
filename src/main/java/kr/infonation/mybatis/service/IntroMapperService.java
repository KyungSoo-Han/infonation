package kr.infonation.mybatis.service;

import kr.infonation.dto.board.BoardDto;
import kr.infonation.mybatis.dto.IntroMapperDto;
import kr.infonation.mybatis.repository.IntroMapperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class IntroMapperService {

    private final IntroMapperRepository introMapperRepository;

    public List<IntroMapperDto> findAll(){
        List<IntroMapperDto> boardDtos = introMapperRepository.listIntro();
        return boardDtos;
    }
}
