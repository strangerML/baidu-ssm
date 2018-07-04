package com.baidu.house.sysmanager.service;

import com.baidu.house.sysmanager.pojo.contact.Contact;
import com.baidu.house.sysmanager.pojo.contact.ContactExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 李 on 2018/5/5.
 */
public interface SysContactService {

    int countByExample(ContactExample example);

    int deleteByExample(ContactExample example);

    int deleteByPrimaryKey(String id);

    int insert(Contact record);

   public int insertSelective(Contact record);

    List<Contact> selectByExample(ContactExample example);

    Contact selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Contact record, @Param("example") ContactExample example);

    int updateByExample(@Param("record") Contact record, @Param("example") ContactExample example);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);

}
