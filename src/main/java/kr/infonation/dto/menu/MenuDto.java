package kr.infonation.dto.menu;

import com.querydsl.core.annotations.QueryProjection;
import kr.infonation.domain.menu.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuDto {

    private Long menu_id;
    private String menu_nm;
    private String iconCls;
    private boolean expended;
    private boolean selectable;

    private String module;
    private String page;
    private boolean leaf;

    private Menu parent;
    private List<MenuDto> children ;

    @Builder
    @QueryProjection
    public MenuDto(final Menu menu) {
        this.menu_id = menu.getMenu_id();
        this.menu_nm = menu.getMenu_nm();
        this.iconCls = menu.getIconCls();
        this.expended = menu.isExpended();
        this.selectable = menu.isSelectable();
        this.module = menu.getModule();
        this.page = menu.getPage();
        this.parent = menu.getParent();
        this.leaf = menu.isLeaf();
        this.children = menu.getChildren().stream().map(MenuDto::new).collect(Collectors.toList());
    }

//    public MenuDto(MenuDto menuDto) {
//        this.menu_id = menuDto.getMenu_id();
//        this.menu_nm = menuDto.getMenu_nm();
//        this.iconCls = menuDto.getIconCls();
//        this.expended = menuDto.isExpended();
//        this.selectable = menuDto.isSelectable();
//        this.module = menuDto.getModule();
//        this.page = menuDto.getPage();
//        this.parent = menuDto.getParent();
//        this.leaf = menuDto.isLeaf();
//        this.children = menuDto.getChildren().stream().map(MenuDto::new).collect(Collectors.toList());
//    }


//    public MenuDto(final Menu menu) {
//
//        this.menu_id = menu.getMenu_id();
//        this.menu_nm = menu.getMenu_nm();
//        this.iconCls = menu.getIconCls();
//        this.expended = menu.isExpended();
//        this.selectable = menu.isSelectable();
//        this.module = menu.getModule();
//        this.page = menu.getPage();
//        this.leaf = menu.isLeaf();
//        this.children = menu.getChildren().stream().map(MenuDto::new).collect(Collectors.toList());
//    }
}
