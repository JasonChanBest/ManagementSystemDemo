package com.ms.business.menu.service.impl;

import com.ms.business.menu.dao.MenuDao;
import com.ms.business.menu.entity.Menu;
import com.ms.business.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> list() {
        return menuDao.findAll();
    }

    @Override
    public Menu get(Long id) {
        return menuDao.findOne(id);
    }

    @Override
    public void save(Menu menu) {
        menuDao.save(menu);
    }

    @Override
    public void delete(Long id) {
        menuDao.delete(id);
    }

    @Override
    public List<Menu> rootMenus() {
        return menuDao.rootMenus();
    }
}
