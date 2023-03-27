package com.mongo.utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 * Created by x on 2023/3/27.
 */
public enum  MongodbUtile {

    instance;//枚举元素，代表了此类的一个实例
    private MongoClient mongoClient;

     static {
      String ip="localhost";
      int port=27017;
      instance.mongoClient=new MongoClient(ip,port);

     }

     //获取数据库
     public MongoDatabase getMongoDatabase(String dbName){

         MongoDatabase database = mongoClient.getDatabase(dbName);
         return database;
     }

     //获取集合
    public MongoCollection<Document> getCollection(String dbName,String colName){
        MongoDatabase mongoDatabase = getMongoDatabase(dbName);
       if(mongoDatabase!=null){
           return mongoDatabase.getCollection(colName);
       }
        return null;

    }

    //查询
    public  MongoCursor<Document> query(MongoCollection<Document> cl, Bson filter){
        return  cl.find(filter).iterator();//filter 查询条件，键值对格式

    }

    //插入
    public  void inserOne(MongoCollection<Document> cl,Document document){
        cl.insertOne(document);
    }

   //更新
    public  void update(MongoCollection<Document> cl,Document queryDocument,Document updateDocument){
        Document modify=new  Document();
        modify.put("$set",updateDocument);
        cl.updateMany(queryDocument,modify);

    }

    //删除

    public  void delete(MongoCollection<Document> cl,Document condition){
        cl.deleteMany(condition);
    }












}
