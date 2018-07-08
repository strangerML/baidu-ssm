package com.baidu.house.sysmanager.service.AuthorityRole;

import com.baidu.house.sysmanager.pojo.authorityrole.AuthorityRole;
import com.baidu.house.sysmanager.pojo.common.PageUtils;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface AuthorityRoleService {

    int deleteByPrimaryKey(Long id);

    int insert(AuthorityRole record);

    int insertSelective(AuthorityRole record);

    AuthorityRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthorityRole record);

    int updateByPrimaryKey(AuthorityRole record);

    AuthorityRole queryByRoleName(String name);

    PageInfo<AuthorityRole> queryPageRole(PageUtils page, AuthorityRole role);

    List<AuthorityRole> getAllRoles();
}
