package com.ms.service;

import com.ms.entity.Role;

import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
public interface RoleService {
    void save(Role role);

    void delete(Long roleId);

    List<Role> list();

    Role get(Long roleId);
}
