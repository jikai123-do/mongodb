package com.mongo.service;

import com.mongo.dao.UserDao;
import com.mongo.module.User;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by x on 2023/3/29.
 */
@Service
public class UserService {
    @Autowired
    public UserDao userDao;

    public  void insert(User user){
        userDao.insert(user);
    }

    public List<User> query(Document document){

        return  userDao.query(document);
    }

  public  void  update(Document conditon,Document content){
         userDao.update(conditon,content);
  }

  public  void delete(Document document){
       userDao.delete(document);
  }
}
