package kr.infonation.mybatis.repository;

import kr.infonation.mybatis.dto.IntroMapperDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IntroMapperRepository {
    List<IntroMapperDto> listIntro();
}
