package com.ms.dao;

import com.ms.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Repository
public interface MenuDao extends JpaRepository<Menu , Long> {
    List<Menu> findByParent(Menu parent);
}
