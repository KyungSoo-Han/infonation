package kr.infonation.repository.menu;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.infonation.domain.menu.Menu;
import kr.infonation.domain.menu.QMenu;
import kr.infonation.dto.menu.MenuDto;

import javax.persistence.EntityManager;

import static kr.infonation.domain.menu.QMenu.menu;

public class MenuRepositoryImpl implements MenuRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public MenuRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Menu save(MenuDto menuDto) {

        Long menu_id = queryFactory
                .insert(menu)
                .columns(menu.menu_nm, menu.children, menu.expended, menu.iconCls, menu.leaf,
                        menu.module, menu.page, menu.selectable)
                .values(menuDto.getMenu_nm(), menuDto.getChildren(), menuDto.isExpended(), menuDto.getIconCls(), menuDto.isLeaf(),
                        menuDto.getModule(), menuDto.getPage(), menuDto.isSelectable())
                .execute();
        System.out.println("menu_id = " + menu_id);

        Menu new_menu = queryFactory.selectFrom(QMenu.menu)
                .where(QMenu.menu.menu_id.eq(menu_id))
                .fetchOne();
        System.out.println("new_menu = " + new_menu);

        return new_menu;
    }
}
