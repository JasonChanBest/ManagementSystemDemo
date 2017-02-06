package com.ms.security;

import com.ms.dao.UserDao;
import com.ms.entity.Role;
import com.ms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByName(s);
        if(user == null)
            throw new UsernameNotFoundException(String.format("没有'%s'这个用户！" , s));

        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role : user.getRoles()) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
            authorities.add(authority);
        }
        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
        return userDetails;
    }
}
