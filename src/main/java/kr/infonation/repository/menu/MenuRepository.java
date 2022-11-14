package kr.infonation.repository.menu;

import kr.infonation.domain.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Long>{
}
