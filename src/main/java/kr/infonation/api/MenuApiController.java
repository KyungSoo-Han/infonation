package kr.infonation.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.infonation.domain.menu.Menu;
import kr.infonation.dto.menu.MenuDto;
import kr.infonation.service.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/menu")
public class MenuApiController {

    private final MenuService menuService;

    @ApiOperation(value = "메뉴 등록")
    @PostMapping
    public MenuDto createMenu(
            @ApiParam(value = "메뉴 등록 Request")
            @RequestBody MenuDto menuDto){

        System.out.println("menuDto = " + menuDto);
        Menu menu = menuService.createMenu(menuDto);
        System.out.println("menu = " + menu);
        return MenuDto.builder().menu(menu).build();


    }


}
