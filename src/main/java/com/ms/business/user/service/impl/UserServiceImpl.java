package com.ms.business.user.service.impl;

import com.ms.business.user.dao.UserDao;
import com.ms.business.user.entity.User;
import com.ms.business.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Override
    public User get(Long id) {
        return userDao.findOne(id);
    }
}
