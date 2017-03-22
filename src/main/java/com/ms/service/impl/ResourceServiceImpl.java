package com.ms.service.impl;

import com.ms.dao.ResourceDao;
import com.ms.entity.Resource;
import com.ms.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public void save(Resource resource) {
        resourceDao.save(resource);
    }

    @Override
    public void delete(Long id) {
        resourceDao.delete(id);
    }

    @Override
    public List<Resource> list() {
        return resourceDao.findAll();
    }

    @Override
    public Resource get(Long id) {
        return resourceDao.findOne(id);
    }
}
