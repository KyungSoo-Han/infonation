package kr.infonation.api;

import kr.infonation.domain.intro.Intro;
import kr.infonation.dto.Intro.CreateIntro;
import kr.infonation.dto.Intro.IntroDto;
import kr.infonation.mybatis.dto.IntroMapperDto;
import kr.infonation.mybatis.repository.IntroMapperRepository;
import kr.infonation.mybatis.service.IntroMapperService;
import kr.infonation.service.intro.IntroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/api/intro")
@RestController
public class IntroApiController {

    private final IntroMapperService introMapperService;
    private final IntroService introService;

    @PostMapping
    public CreateIntro.Response createIntro(@RequestBody CreateIntro.Request request){

        System.out.println("request = " + request);
        Intro intro = introService.createIntro(request);

        return new CreateIntro.Response(intro);
    }

    @GetMapping
    public @ResponseBody Map<String, Object> list(){

        Map<String, Object> rtnObj = new HashMap<>();
        List<IntroMapperDto> listIntro = introMapperService.findAll();
        rtnObj.put("listIntro", listIntro);
        System.out.println("listIntro = " + listIntro);
        return rtnObj;
    }

}
