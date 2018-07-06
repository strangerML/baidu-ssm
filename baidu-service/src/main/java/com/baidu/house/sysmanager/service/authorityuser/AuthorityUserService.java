package com.baidu.house.sysmanager.service.authorityuser;

import com.baidu.house.sysmanager.pojo.authorityuser.AuthorityUser;

import java.util.Map;

public interface AuthorityUserService {

    int deleteByPrimaryKey(Long id);

    int insert(AuthorityUser record);

    int insertSelective(AuthorityUser record,Long roleId);

    AuthorityUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthorityUser record);

    int updateByPrimaryKey(AuthorityUser record);

    void insertUserAndRole(AuthorityUser user, Long roleId);

    void updateUserAndRole(AuthorityUser user, Long roleId);

    Map selectByPrimaryKeyResuMap(Long id);
}
