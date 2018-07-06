package com.baidu.house.sysmanager.controller.authorityuser;


import com.baidu.house.sysmanager.controller.authorityrole.SysAuthorityRoleController;
import com.baidu.house.sysmanager.pojo.authorityrole.AuthorityRole;
import com.baidu.house.sysmanager.pojo.authorityuser.AuthorityUser;
import com.baidu.house.sysmanager.pojo.common.PageUtils;
import com.baidu.house.sysmanager.pojo.common.ResultUtils;
import com.baidu.house.sysmanager.service.authorityuser.AuthorityUserService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/sysuser")
public class AuthorityUserController {


    private static final Logger logger = LoggerFactory.getLogger(AuthorityUserController.class);

    @Autowired
    private AuthorityUserService authorityUserService;

    /**
     * request:
     * return:
     *
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public PageUtils<AuthorityUser> queryRole(PageUtils page, AuthorityUser role) {

        return null;
    }

    /**
     * 此方法包含（添加的，修改的）
     * 用户的名称不得重复
     * 角色id
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/mergeUser", produces = "application/json")
    @ResponseBody
    public ResultUtils mergeUser(AuthorityUser user, Long roleId) {

        AuthorityUser authorityUser = null;
        try {
            if (user.getId() == null) {
                addUser(user, roleId);
            } else {
                //修改
                authorityUserService.updateUserAndRole(user, roleId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.build(500, "user操作错误");
        }


        return ResultUtils.ok();
    }


    /**
     * 用户进行增加的方法
     * TODO 未对用户名等称进行判断
     *
     * @param user
     */
    private void addUser(AuthorityUser user, Long roleId) {

        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        authorityUserService.insertSelective(user, roleId);

    }

    /**
     * 根据用户的id修改角色
     * 查询用户信息
     * 查询角色的信息
     * 关联查询数据
     *
     * @param id
     */

    @RequestMapping(value = "/updateByUserId",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtils updateByUserId(@RequestParam  Long id) {

        Map resuMap = null;
        try {
            resuMap = authorityUserService.selectByPrimaryKeyResuMap(id);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return ResultUtils.build(500, "查询异常");
        }
        return ResultUtils.build(200, "成功", resuMap);
    }

    //根据角色的名称进行数据的查询
    private AuthorityUser queryByUserName(String name) {
        return null;
    }


    /**
     * 操作不可逆
     *
     * @param id
     * @return
     */
    @RequestMapping("/delUser")
    @ResponseBody
    public ResultUtils delUser(Long id) {

        try {
            authorityUserService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.build(500, "删除-操作失败");
        }
        return ResultUtils.ok();

    }


}
