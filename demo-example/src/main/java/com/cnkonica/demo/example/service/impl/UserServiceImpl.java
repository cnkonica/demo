package com.cnkonica.demo.example.service.impl;

import com.cnkonica.demo.example.domain.OrmUser;
import com.cnkonica.demo.example.mapper.OrmUserMapper;
import com.cnkonica.demo.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private OrmUserMapper ormUserMapper;
    @Override
    public List<OrmUser> getAllUser() {
        return ormUserMapper.selectAllUser();
    }
    @Override
    public OrmUser selectByPrimaryKey(Long id) {
        return ormUserMapper.selectByPrimaryKey(id);
    }
}
