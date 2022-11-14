package kr.infonation.repository.menu;

import kr.infonation.domain.menu.Menu;
import kr.infonation.dto.menu.MenuDto;

public interface MenuRepositoryCustom {
    Menu save(MenuDto menuDto);
}
