package com.baidu.contact.mapper;

import com.baidu.house.sysmanager.dao.contact.ContactMapper;
import com.baidu.house.sysmanager.pojo.contact.Contact;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by 李 on 2018/5/5.
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-dao.xml")*/
public class ContactMapperTest {


    @Resource
    private ContactMapper contactMapper;

    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {
        System.out.println("aa");
    }

    @Test
    public void testSelectByExample() throws Exception {

    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {

                String id = "38090246-37ba-44a5-857f-e9f252e27a88";
        Contact contact = contactMapper.selectByPrimaryKey(id);
        System.out.println(contact.getOfficename());
    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {

    }
}