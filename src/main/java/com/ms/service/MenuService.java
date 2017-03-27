package com.ms.service;

import com.ms.entity.Menu;

import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
public interface MenuService {
    List<Menu> findByParent(Menu parent);
}
