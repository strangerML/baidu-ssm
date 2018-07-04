package com.baidu.house.sysmanager.serviceimpl.authorityrole;

import com.baidu.house.sysmanager.dao.authorityrole.AuthorityRoleMapper;
import com.baidu.house.sysmanager.pojo.authorityrole.AuthorityRole;
import com.baidu.house.sysmanager.service.AuthorityRole.AuthorityRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorityRoleServiceImpl implements AuthorityRoleService {

    @Autowired
    private AuthorityRoleMapper authorityRoleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Transactional
    @Override
    public int insert(AuthorityRole record) {
        int insert = authorityRoleMapper.insert(record);
        return insert;
    }

    @Override
    public int insertSelective(AuthorityRole record) {
       return 0;
    }

    @Override
    public AuthorityRole selectByPrimaryKey(Long id) {

        return authorityRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AuthorityRole record) {
        return authorityRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AuthorityRole record) {
        return 0;
    }

    @Override
    public AuthorityRole queryByRoleName(String name) {
        return authorityRoleMapper.queryByRoleName(name);
    }
}
