package com.baidu.house.sysmanager.serviceimpl.authorityrole;

import com.baidu.house.sysmanager.dao.authorityrole.AuthorityRoleMapper;
import com.baidu.house.sysmanager.pojo.authorityrole.AuthorityRole;
import com.baidu.house.sysmanager.pojo.common.PageUtils;
import com.baidu.house.sysmanager.service.AuthorityRole.AuthorityRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorityRoleServiceImpl implements AuthorityRoleService {

    @Autowired
    private AuthorityRoleMapper authorityRoleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return authorityRoleMapper.deleteByPrimaryKey(id);
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

    @Override
    public PageInfo<AuthorityRole> queryPageRole(PageUtils page, AuthorityRole role) {

        int pageNum = page.getPageNum()==null?1:page.getPageNum();
        int pageSize = page.getPageSize()==null?5:page.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        //设置起始页和结束页
        //设置查询条件
        List<AuthorityRole> roleList = authorityRoleMapper.queryPageRole(role);

        PageInfo<AuthorityRole> resupage = new PageInfo<>(roleList);

        System.out.println(resupage);

        return resupage;
    }

}
