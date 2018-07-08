package com.baidu.house.sysmanager.serviceimpl.authorityuser;

import com.baidu.house.sysmanager.dao.authorityuser.AuthorityUserMapper;
import com.baidu.house.sysmanager.pojo.authorityuser.AuthorityUser;
import com.baidu.house.sysmanager.pojo.common.PageUtils;
import com.baidu.house.sysmanager.service.authorityuser.AuthorityUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * user
 */

@Service
public class AuthorityUserServiceImpl implements AuthorityUserService {



    @Autowired
    private AuthorityUserMapper authorityUserMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long id) {

        authorityUserMapper.deleteByPrimaryKey(id);
        authorityUserMapper.deleteUserAndRole(id);
        return 0;
    }

    @Override
    public int insert(AuthorityUser record) {
        return 0;
    }

    @Transactional
    @Override
    public int insertSelective(AuthorityUser record,Long roleId) {

         authorityUserMapper.insertSelective(record);
        int i = 10/0;
        //添加关联表
        HashMap<String, Object> userAndRoleMap = getUserAndRoleMap(record.getId(), roleId);
        authorityUserMapper.insertUserAndRole(userAndRoleMap);
        return 0;
    }

    /**
     * 数据回显要查角色否
     * @param id
     * @return
     */
    @Override
    public AuthorityUser selectByPrimaryKey(Long id) {
        return authorityUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AuthorityUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(AuthorityUser record) {
        return 0;
    }

    @Transactional
    @Override
    public void insertUserAndRole(AuthorityUser user, Long roleId) {


    }

    @Transactional
    @Override
    public void updateUserAndRole(AuthorityUser user, Long roleId) {
        //根据用户的id修改用户的数据
        authorityUserMapper.updateByPrimaryKeySelective(user);

        //根据用户的id 修改角色的 id
        HashMap<String, Object> userAndRoleMap = getUserAndRoleMap(user.getId(), roleId);
        authorityUserMapper.updateRoleIdByUserId(userAndRoleMap);
    }

    @Override
    public Map selectByPrimaryKeyResuMap(Long id) {
        return authorityUserMapper.selectByPrimaryKeyResuMap(id);
    }


    @Override
    public PageInfo<Map> queryPageUsers(PageUtils page, String roleName, AuthorityUser user) {

        //
        int pagenum1 = page.getPageNum()==null? 1 : page.getPageNum();
        int pageSize1 = page.getPageSize()==null?5:page.getPageSize();


        Map<String,Object> map = new HashMap<String,Object>();

        map.put("roleName",roleName);

        map.put("userName",user.getUserName());

        PageHelper.startPage(pagenum1,pageSize1);

        List<Map> resu = authorityUserMapper.queryPageUsers(map);

        PageInfo<Map> ma  = new PageInfo<>(resu);

        System.out.println(ma);

        return ma;

    }

    //返回集合
    public HashMap<String,Object> getUserAndRoleMap(Long userId,Long roleId){

        HashMap<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("roleId",roleId);

        return map;
    }


}
