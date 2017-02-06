package com.ms.dao;

import com.ms.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jason
 * @since v1.0
 */
@Repository
public interface RoleDao extends JpaRepository<Role , Long> {
}
