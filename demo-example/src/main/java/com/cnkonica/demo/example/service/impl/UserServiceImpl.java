package com.cnkonica.demo.example.service.impl;

import com.cnkonica.demo.example.domain.OrmUser;
import com.cnkonica.demo.example.repository.OrmUserRepository;
import com.cnkonica.demo.example.service.UserService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private OrmUserRepository ormUserRepository;
    @Override
    public List<OrmUser> getAllUser() {
        return ormUserRepository.findAll();
    }
    @Override
    public OrmUser selectByPrimaryKey(Long id) {
        return ormUserRepository.findById(id).orElse(null);
    }

    @Override
    public OrmUser create(OrmUser user) {
        if (user == null) {
            return null;
        }
        user.setId(null);
        return ormUserRepository.save(user);
    }

    @Override
    public OrmUser update(Long id, OrmUser user) {
        if (id == null || user == null || !ormUserRepository.existsById(id)) {
            return null;
        }
        user.setId(id);
        return ormUserRepository.save(user);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        if (!ormUserRepository.existsById(id)) {
            return 0;
        }
        ormUserRepository.deleteById(id);
        return 1;
    }
}
