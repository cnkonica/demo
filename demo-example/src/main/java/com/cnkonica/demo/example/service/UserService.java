package com.cnkonica.demo.example.service;

import com.cnkonica.demo.example.domain.OrmUser;

import java.util.List;

public interface UserService {
    List<OrmUser> getAllUser();

    OrmUser selectByPrimaryKey(Long id);

    OrmUser create(OrmUser user);

    OrmUser update(Long id, OrmUser user);

    int deleteByPrimaryKey(Long id);
}
