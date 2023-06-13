package com.cnkonica.demo.example.mapper;

import com.cnkonica.demo.example.domain.OrmUser;

import java.util.List;

/**
* @author konyliu
* @description 针对表【orm_user(Spring Boot Demo Orm 系列示例表)】的数据库操作Mapper
* @createDate 2023-06-14 01:10:57
* @Entity com.cnkonica.demo.example.domain.OrmUser
*/
public interface OrmUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(OrmUser record);

    int insertSelective(OrmUser record);

    OrmUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrmUser record);

    int updateByPrimaryKey(OrmUser record);

    List<OrmUser> selectAllUser();

}
