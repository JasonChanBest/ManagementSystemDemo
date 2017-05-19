package com.ms.business.role.dao;

import com.ms.business.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jason
 * @since v1.0
 */
@Repository
public interface RoleDao extends JpaRepository<Role , Long> {
}
