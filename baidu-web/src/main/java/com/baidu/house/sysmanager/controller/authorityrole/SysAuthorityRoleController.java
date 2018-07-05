package com.baidu.house.sysmanager.controller.authorityrole;


import com.baidu.house.sysmanager.pojo.authorityrole.AuthorityRole;
import com.baidu.house.sysmanager.pojo.common.PageUtils;
import com.baidu.house.sysmanager.pojo.common.ResultUtils;
import com.baidu.house.sysmanager.service.AuthorityRole.AuthorityRoleService;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/role")
public class SysAuthorityRoleController {

    private static final  Logger logger = LoggerFactory.getLogger(SysAuthorityRoleController.class);





    @Autowired
    private AuthorityRoleService authorityRoleService;

    /**
     * request:
     * return:
     *
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public PageUtils<AuthorityRole> queryRole(PageUtils page, AuthorityRole role) {

        PageUtils<AuthorityRole> pageUtils = new PageUtils<AuthorityRole>();
        if(role.getName()!=null){
            pageUtils.getLike().put("name",role.getName());
        }
       if(role.getRemark()!=null){

           pageUtils.getLike().put("remark",role.getRemark());
       }

        PageInfo<AuthorityRole> pageRole = authorityRoleService.queryPageRole(page, role);

        //需要把具体搜索的参数也要带回去
        pageUtils.setPageInfo(pageRole);
        System.out.println(pageRole);
        System.out.println("进来了");
        return pageUtils;
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





    @RequestMapping("/delRole")
    @ResponseBody
    public ResultUtils delRole(AuthorityRole role) {

        if(role.getId()==null){
            return ResultUtils.build(500,"角色不能为空");
        }
        int i = 0;
        try {
            i = authorityRoleService.deleteByPrimaryKey(role.getId());

            if(i!=1){
                logger.error("error--id");
                return ResultUtils.build(500,"请输入正确的id");
            }
            logger.info("info----success");
            System.out.println("返回的结果------》"+i);
            return ResultUtils.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.build(500,"删除异常");
        }



    }

    @RequestMapping
    public String index(){
        return "index";
    }
}
