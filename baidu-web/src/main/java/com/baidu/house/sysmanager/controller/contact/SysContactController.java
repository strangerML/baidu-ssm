package com.baidu.house.sysmanager.controller.contact;

import com.baidu.house.sysmanager.contact.service.SysContactService;
import com.baidu.house.sysmanager.pojo.contact.Contact;
import com.baidu.house.sysmanager.pojo.contact.ContactExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 李 on 2018/5/5.
 */
@Controller
public class SysContactController {

    @Autowired
    private SysContactService sysContactService;

    @RequestMapping("getContact")
    public String getContact(HttpServletRequest request,String id ,Model model){

        String id1 = "38090246-37ba-44a5-857f-e9f252e27a88";
    //    Contact contact = sysContactService.selectByPrimaryKey(id);

        ContactExample test = new ContactExample();
        test.setDistinct(true);

        List<Contact> contacts = sysContactService.selectByExample(test);

        model.addAttribute("contact",contacts);


        return "test";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
