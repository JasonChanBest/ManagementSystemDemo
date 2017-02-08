package com.ms.service.impl;

import com.ms.dao.RoleDao;
import com.ms.entity.Role;
import com.ms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public void delete(Long roleId) {
        roleDao.delete(roleId);
    }

    @Override
    public List<Role> list() {
        return roleDao.findAll();
    }

    @Override
    public Role get(Long roleId) {
        return roleDao.findOne(roleId);
    }

}
