package kr.infonation.service.intro;

import kr.infonation.domain.intro.Intro;
import kr.infonation.domain.user.User;
import kr.infonation.dto.Intro.CreateIntro;
import kr.infonation.repository.intro.IntroRepository;
import kr.infonation.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class IntroService {

    private final IntroRepository introRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public Intro createIntro(CreateIntro.Request request){

//        System.out.println("request = " + request);
//         Intro intro = modelMapper.map(request, Intro.class);
//        System.out.println("intro = " + intro.getTitle());

        Optional<User> user = userRepository.findByIdOptional(request.getUser_id());
        System.out.println("user = " + user);
       return introRepository.save(request.toEntity(user));
    }

}
