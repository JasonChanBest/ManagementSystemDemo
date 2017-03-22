package com.ms.service;

import com.ms.entity.Resource;

import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
public interface ResourceService {
    void save(Resource resource);

    void delete(Long id);

    List<Resource> list();

    Resource get(Long id);
}
