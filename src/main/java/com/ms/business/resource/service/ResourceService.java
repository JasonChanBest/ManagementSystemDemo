package com.ms.business.resource.service;

import com.ms.business.resource.entity.Resource;

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
