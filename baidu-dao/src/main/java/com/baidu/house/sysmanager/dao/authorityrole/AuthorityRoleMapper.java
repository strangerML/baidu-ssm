package com.baidu.house.sysmanager.dao.authorityrole;


import com.baidu.house.sysmanager.pojo.authorityrole.AuthorityRole;

public interface AuthorityRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthorityRole record);

    int insertSelective(AuthorityRole record);

    AuthorityRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthorityRole record);

    int updateByPrimaryKey(AuthorityRole record);

    AuthorityRole queryByRoleName(String name);
}