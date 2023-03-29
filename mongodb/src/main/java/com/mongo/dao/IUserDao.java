package com.mongo.dao;

import com.mongo.module.User;

import org.bson.Document;
import java.util.List;

/**
 * Created by x on 2023/3/29.
 */
public interface IUserDao {

    public void insert(User user);

    public List<User> query(Document document);

    public  void update(Document conditon,Document content);

    public  void delete(Document document);

}
