package com.ms.business.menu.service;

import com.ms.business.menu.entity.Menu;

import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
public interface MenuService {
    List<Menu> list();

    Menu get(Long id);

    void save(Menu menu);

    void delete(Long id);

    List<Menu> rootMenus();
}
