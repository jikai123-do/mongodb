package com.mongo.controller;

import com.mongo.module.User;
import com.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import org.bson.Document;

/**
 * Created by x on 2023/3/29.
 */
@Controller
public class UserController {

    @Autowired
    public UserService userService;

   @RequestMapping(value = "/insert",method = RequestMethod.POST,consumes = "application/json")
    public @ResponseBody String insert(@RequestBody User user){
        userService.insert(user);
        return "插入成功";
    }


    @RequestMapping(value = "/query",method = RequestMethod.POST,consumes = "application/json")
    public @ResponseBody List<User> query(@RequestBody Document  condtion){
       org.bson.Document document=new org.bson.Document();
       if(condtion.get("name")!=null &&condtion.get("name").toString().length()>0){
           document.put("name",condtion.get("name"));
       }
        if(condtion.get("age")!=null &&condtion.get("age").toString().length()>0){
            document.put("age",Integer.parseInt(condtion.get("age").toString()));
        }

        return userService.query(document);
    }



    @RequestMapping(value = "/update",method = RequestMethod.POST,consumes = "application/json")
    public @ResponseBody String update(@RequestBody Document  condtion){
        org.bson.Document con=new org.bson.Document();
        if(condtion.get("name_c")!=null &&condtion.get("name_c").toString().length()>0){
            con.put("name",condtion.get("name_c"));
        }
        if(condtion.get("age_c")!=null &&condtion.get("age_c").toString().length()>0){
            con.put("age",Integer.parseInt(condtion.get("age_c").toString()));
        }

        Document content=new Document();
        content.put("name",condtion.get("name_n"));
        content.put("age",condtion.get("age_n"));

        userService.update(con,content);

        return "更新成功";
    }


    @RequestMapping(value = "/delete",method = RequestMethod.POST,consumes = "application/json")
    public @ResponseBody String delete(@RequestBody  Document  condtion){
        Document con=new Document();
        if(condtion.get("name_d")!=null && condtion.get("name_d").toString().length()>0){
            con.put("name",condtion.get("name_d"));
        }
        if(condtion.get("age_d")!=null && condtion.get("age_d").toString().length()>0){
            con.put("age",Integer.parseInt(condtion.get("age_d").toString()));
        }

        if(con.get("name")==null && con.get("age")==null ){
            return "请输入删除条件";
        }

        userService.delete(con);
        return "删除成功";
    }





}
