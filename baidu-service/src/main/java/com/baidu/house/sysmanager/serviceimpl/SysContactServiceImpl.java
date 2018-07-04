package com.baidu.house.sysmanager.serviceimpl;


import com.baidu.house.sysmanager.pojo.contact.Contact;
import com.baidu.house.sysmanager.pojo.contact.ContactExample;
import com.baidu.house.sysmanager.service.SysContactService;
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
        return 0;
    }

    @Override
    public int insert(Contact record) {
        return 0;
    }

    @Override
    public int insertSelective(Contact record) {
        return 0;
    }

    @Override
    public List<Contact> selectByExample(ContactExample example) {
        return null;
    }

    @Override
    public Contact selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Contact record, ContactExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Contact record, ContactExample example) {
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
