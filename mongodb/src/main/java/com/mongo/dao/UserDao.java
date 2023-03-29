package com.mongo.dao;

import com.mongo.module.User;
import com.mongo.utils.MongodbUtile;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by x on 2023/3/29.
 */
@Repository
public class UserDao implements IUserDao {


    public void insert(User user){
        MongoCollection<Document> collection = MongodbUtile.instance.getCollection("gj", "person");
        Document document=new Document();
        document.put("name",user.getName());
        document.put("age",user.getAge());
        collection.insertOne(document);

    }


    public List<User> query(Document document){
        List<User> users=new ArrayList<>();
        MongoCollection<Document> collection = MongodbUtile.instance.getCollection("gj", "person");
        MongoCursor<Document> iterator =  MongodbUtile.instance.query(collection,document);
        while (iterator.hasNext()){
            User user=new User();
            Document documentNext=iterator.next();
            user.setName(documentNext.get("name").toString());
            user.setAge(Integer.parseInt(documentNext.get("age").toString()));
            users.add(user);
        }
     return users;
    }


    public  void update(Document conditon,Document content){

        MongoCollection<Document> collection = MongodbUtile.instance.getCollection("gj", "person");
        MongodbUtile.instance.update(collection,conditon,content);

    }


    public  void delete(Document document){
        MongoCollection<Document> collection = MongodbUtile.instance.getCollection("gj", "person");
        MongodbUtile.instance.delete(collection,document);

    }

}
