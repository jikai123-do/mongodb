package com.mongo.utils;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by x on 2023/3/26.
 */
public class MongoUtileTest {


    public static void main(String[] args) {


        //获取指定数据库
        MongoDatabase gj = MongodbUtile.instance.getMongoDatabase("gj");
        if (gj != null) {
            System.out.println("连接成功");
        } else {
            System.out.println("连接失败");
        }

        //获取数据
        MongoCollection<Document> person = MongodbUtile.instance.getCollection("gj","person");
        if (person != null) {
            Document document=new Document("name","zhangsan");
            FindIterable<Document> findIterable = person.find(document);
            MongoCursor<Document> iterator = findIterable.iterator();
            while (iterator.hasNext()) {
                System.out.println("个人信息："+iterator.next());
            }

        }






    }


}
