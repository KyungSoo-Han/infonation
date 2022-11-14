package kr.infonation.service.menu;

import kr.infonation.domain.menu.Menu;
import kr.infonation.dto.menu.MenuDto;
import kr.infonation.repository.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public Menu createMenu(MenuDto menuDto){
        System.out.println("menuDto = " + menuDto);
        Menu menu = Menu.builder()
                .menuDto(menuDto)
                .build();
        menuRepository.save(menu);
        System.out.println("menu = " + menu);
        return menu;
    }

}
