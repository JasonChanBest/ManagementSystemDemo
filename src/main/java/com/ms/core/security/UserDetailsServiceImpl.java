package com.ms.core.security;

import com.ms.business.user.dao.UserDao;
import com.ms.business.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        return user;
    }
}
