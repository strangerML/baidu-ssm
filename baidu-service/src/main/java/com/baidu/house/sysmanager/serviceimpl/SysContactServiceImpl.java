package com.baidu.house.sysmanager.contact.serviceimpl;

import com.baidu.house.sysmanager.dao.contact.ContactMapper;
import com.baidu.house.sysmanager.pojo.contact.Contact;
import com.baidu.house.sysmanager.pojo.contact.ContactExample;
import com.baidu.house.sysmanager.contact.service.SysContactService;
import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 李 on 2018/5/5.
 */
@Service
public class SysContactServiceImpl implements SysContactService {


    @Autowired
    private ContactMapper contactMapper;




    @Override
    public int countByExample(ContactExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(ContactExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return contactMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Contact record) {
        return 0;
    }

    @Override
    @Transactional
    public int insertSelective(Contact record) {
        int i ;
        try {
            contactMapper.insertSelective(record);

            i = 1;
        } catch (Exception e) {
            e.printStackTrace();


            i =0;
        }
        return i;
    }

    @Override
    public List<Contact> selectByExample(ContactExample example) {
        return contactMapper.selectByExample(example);
    }

    @Override
    public Contact selectByPrimaryKey(String id) {
        return contactMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(@Param("record") Contact record, @Param("example") ContactExample example) {
        return 0;
    }

    @Override
    public int updateByExample(@Param("record") Contact record, @Param("example") ContactExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Contact record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Contact record) {
        return 0;
    }
}
