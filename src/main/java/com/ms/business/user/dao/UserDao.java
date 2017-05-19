package com.ms.business.user.dao;

import com.ms.business.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jason
 * @since v1.0
 */
@Repository
public interface UserDao extends JpaRepository<User , Long>{
    User findByName(String name);
}
