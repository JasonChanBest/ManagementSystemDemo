package com.ms.dao;

import com.ms.entity.User;
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
