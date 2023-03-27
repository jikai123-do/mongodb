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
public class ConnectTest {


    public static void main(String[] args) {

        MongoClient mc = new MongoClient("localhost", 27017);
        //查找有哪些数据库
        List<String> databaseNames = mc.getDatabaseNames();
        for (String dbs : databaseNames) {
            System.out.println(dbs);
        }

        //获取指定数据库
        MongoDatabase gj = mc.getDatabase("gj");
        if (gj != null) {
            System.out.println("连接成功");
        } else {
            System.out.println("连接失败");
        }

        //获取数据
        MongoCollection<Document> person = gj.getCollection("person");
        if (gj != null) {
            Document document=new Document("name","zhangsan");
            FindIterable<Document> findIterable = person.find(document);
            MongoCursor<Document> iterator = findIterable.iterator();
            while (iterator.hasNext()) {
                System.out.println("个人信息："+iterator.next());
            }

        }


        //插入数据
        Document document=new Document();
        document.put("name","zhaoliu");
        document.put("age",5);
        person.insertOne(document);
        FindIterable<Document> findIterable1 = person.find();
        MongoCursor<Document> iterator1 = findIterable1.iterator();
        while (iterator1.hasNext()) {
            System.out.println("个人信息1："+iterator1.next());
        }

        //插入多条
        List<Document> list=new ArrayList<>();
        for(int i=1;i<10;i++){
            Document doc=new Document();
            doc.put("name","name"+i);
            doc.put("age",i);
            list.add(doc);

        }
        person.insertMany(list);




        //修改数据
        document.put("name","wangwu");
        Document content=new Document();
        content.put("$set",new Document("age",100).append("class","三年级"));
        person.updateMany(document,content);

       //删除数据
        person.deleteMany(new Document("name","wangwu"));



    }


}
