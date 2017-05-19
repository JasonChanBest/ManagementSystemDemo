package com.ms.business.user.service;

import com.ms.business.user.entity.User;

import java.util.List;

/**
 * @author Jason
 * @since v1.0
 */
public interface UserService {
    void delete(Long id);

    void save(User user);

    List<User> list();

    User get(Long id);
}
