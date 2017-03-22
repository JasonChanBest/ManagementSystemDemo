package com.ms.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Jason
 * @since v1.0
 */
@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        if(collection.isEmpty())
            return;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for(ConfigAttribute ca : collection) {
            for(GrantedAuthority ga : authorities) {
                if(StringUtils.equals(ca.getAttribute() , ga.getAuthority()))
                    return;
            }
        }

        throw new AccessDeniedException("没有访问权限！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
