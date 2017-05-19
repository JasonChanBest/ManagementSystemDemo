package com.ms.business.role.service;

import com.ms.business.role.entity.Role;

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

    List<Role> findAll(Iterable<Long> ids);
}
