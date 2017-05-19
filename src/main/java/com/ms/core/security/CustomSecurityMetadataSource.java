package com.ms.core.security;

import com.ms.business.resource.dao.ResourceDao;
import com.ms.business.role.dao.RoleDao;
import com.ms.business.resource.entity.Resource;
import com.ms.business.role.entity.Role;
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

        System.err.println("===========" + url + "===========");

        List<ConfigAttribute> attributes = new ArrayList<>();

        Resource r = resourceDao.findByUrl(url);

        if(r == null) {
            return attributes;
        }


        List<Role> roles = r.getRoles();
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
