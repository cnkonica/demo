package com.cnkonica.demo.example.service;

import com.cnkonica.demo.example.domain.OrmUser;

import java.util.List;

public interface UserService {
    List<OrmUser> getAllUser();

    public OrmUser selectByPrimaryKey(Long id);
}
