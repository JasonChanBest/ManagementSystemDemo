package com.ms.business.menu.dao;

import com.ms.business.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Repository
public interface MenuDao extends JpaRepository<Menu, Long> {
    @Query("select m from Menu m where m.parent is null")
    List<Menu> rootMenus();
}