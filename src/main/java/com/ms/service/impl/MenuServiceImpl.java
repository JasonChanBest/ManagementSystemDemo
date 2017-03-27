package com.ms.service.impl;

import com.ms.dao.MenuDao;
import com.ms.entity.Menu;
import com.ms.service.MenuService;
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
    public List<Menu> findByParent(Menu parent) {
        return menuDao.findByParent(parent);
    }
}
