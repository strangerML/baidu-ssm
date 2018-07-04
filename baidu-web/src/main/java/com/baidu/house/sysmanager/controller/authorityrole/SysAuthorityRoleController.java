package com.baidu.house.sysmanager.controller.authorityrole;


import com.baidu.house.sysmanager.pojo.authorityrole.AuthorityRole;
import com.baidu.house.sysmanager.pojo.common.ResultUtils;
import com.baidu.house.sysmanager.service.AuthorityRole.AuthorityRoleService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/role")
public class SysAuthorityRoleController {


    @Autowired
    private AuthorityRoleService authorityRoleService;

    @RequestMapping("/query")
    @ResponseBody
    public String queryRole() {
        AuthorityRole authorityRole = authorityRoleService.selectByPrimaryKey(6L);
        System.out.println(authorityRole);
        System.out.println("进来了");
        return "wwww";
    }

    /**
     * 此方法包含（添加的，修改的）
     * 角色的名称不得重复
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/mergeRole",produces = "application/json")
    @ResponseBody
    public ResultUtils mergeRole(AuthorityRole role) {

        AuthorityRole authorityRole = null;

        try {
            //如果为空
            if (StringUtils.isEmpty(role.getName())) {
                return ResultUtils.build(500, "用户名不能为空");
            } else {
                //根据角色名称进行查询
                authorityRole = queryByRoleName(role.getName());
            }

            if (authorityRole != null) {
                return ResultUtils.build(500, "用户名重复");
            }

            //查看是否是修改
            if (null != role.getId()) {
                //根据ID进行数据的修改
                updateByRoleId(role);
                return ResultUtils.ok();
            }

            if (role.getId() == null) {
                System.out.println("角色id为空");
            }
            //进行增加
            addRole(role);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.build(500,"数据操作异常");
        }

        return ResultUtils.ok();
    }

    /**
     * 角色进行增加的方法
     *
     * @param role
     */
    private void addRole(AuthorityRole role) {
        authorityRoleService.insert(role);

    }

    /**
     * 根据用户的id修改角色
     *
     * @param role
     */
    private void updateByRoleId(AuthorityRole role) {
        authorityRoleService.updateByPrimaryKeySelective(role);
    }

    //根据角色的名称进行数据的查询
    private AuthorityRole queryByRoleName(String name) {

        return authorityRoleService.queryByRoleName(name);
    }


    @RequestMapping("/updateRole")
    public void updateRole() {
        System.out.println("进来了--updateRole");
    }


    @RequestMapping("/delRole")
    public void delRole() {
        System.out.println("进来了--updateRole");
    }

    @RequestMapping
    public String index(){
        return "index";
    }
}
