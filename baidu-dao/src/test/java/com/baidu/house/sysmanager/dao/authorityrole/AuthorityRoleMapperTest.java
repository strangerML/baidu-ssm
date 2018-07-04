package com.baidu.house.sysmanager.dao.authorityrole;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-dao.xml")
public class AuthorityRoleMapperTest {

    @Test
    public void selectByPrimaryKey() {

        System.out.println("进来了");
    }
}