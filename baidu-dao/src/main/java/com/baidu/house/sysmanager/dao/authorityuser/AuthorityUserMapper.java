package com.baidu.house.sysmanager.dao.authorityuser;

import com.baidu.house.sysmanager.pojo.authorityuser.AuthorityUser;

import java.util.HashMap;
import java.util.Map;

public interface AuthorityUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthorityUser record);

    int insertSelective(AuthorityUser record);

    AuthorityUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthorityUser record);

    int updateByPrimaryKey(AuthorityUser record);

    void insertUserAndRole(HashMap<String,Object> map);

    void updateRoleIdByUserId(HashMap<String,Object> userAndRoleMap);

    void deleteUserAndRole(Long id);

    Map selectByPrimaryKeyResuMap(Long id);
}