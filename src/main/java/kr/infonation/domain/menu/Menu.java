package kr.infonation.domain.menu;

import kr.infonation.base.BaseEntity;
import kr.infonation.dto.menu.MenuDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.el.parser.BooleanNode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Entity
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue
    private Long menu_id;
    private String menu_nm;
    private String iconCls;
    private boolean expended;
    private boolean selectable;

    private String module;
    private String page;
    private boolean leaf;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Menu parent;

    @OneToMany(mappedBy = "parent")
    private List<Menu> children = new ArrayList<>();


    @Builder
    public Menu(MenuDto menuDto) {

        this.menu_nm = menuDto.getMenu_nm();
        this.iconCls = menuDto.getIconCls();
        this.expended = menuDto.isExpended();
        this.selectable = menuDto.isSelectable();
        this.module = menuDto.getModule();
        this.page = menuDto.getPage();
        this.leaf = menuDto.isLeaf();
        this.parent = menuDto.getParent();
        if(menuDto.getChildren() != null)
            this.children = menuDto.getChildren().stream().map(Menu::new).collect(Collectors.toList());
    }

}
