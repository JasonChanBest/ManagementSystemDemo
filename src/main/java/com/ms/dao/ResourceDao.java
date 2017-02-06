package com.ms.dao;

import com.ms.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jason
 * @since v1.0
 */
@Repository
public interface ResourceDao extends JpaRepository<Resource, Long> {
    Resource findByUrl(String url);
}
