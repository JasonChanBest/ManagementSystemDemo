package com.ms.security;

import com.ms.dao.ResourceDao;
import com.ms.dao.RoleDao;
import com.ms.entity.Resource;
import com.ms.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Component
public class CustomSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomSecurityMetadataSource.class);

    @Autowired
    private ResourceDao resourceDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation)o;
        String url = fi.getRequestUrl();

        LOGGER.info("============{}=============" , url);

        Resource r = resourceDao.findByUrl(url);
        List<Role> roles = r.getRoles();
        List<ConfigAttribute> attributes = new ArrayList<>();
        for(Role role : roles) {
            attributes.add(new SecurityConfig(role.getName()));
        }
        return attributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        List<Role> roles = roleDao.findAll();
        List<ConfigAttribute> attributes = new ArrayList<>();
        for(Role role : roles) {
            attributes.add(new SecurityConfig(role.getName()));
        }
        return attributes;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
