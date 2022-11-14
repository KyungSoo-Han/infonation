package kr.infonation.repository.menu;


import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.infonation.domain.menu.Menu;
import kr.infonation.dto.menu.MenuDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;

import static kr.infonation.domain.menu.QMenu.menu;

@Repository
public class MenuQueryRepository {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public MenuQueryRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }


    public List<MenuDto> menuList(){

        List<Menu> menuList = queryFactory
                .selectFrom(menu)
                .fetch();


        return menuList.stream().map(MenuDto::new).collect(Collectors.toList());
    }

}
