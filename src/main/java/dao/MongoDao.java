package dao;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoDao {
    private final MongoCollection<Document> mongoDatabase;

    /**
     * 构建一个 MongoDB 数据库读取对象
     *
     * @param URL MongoDB 地址
     */
    public MongoDao(String URL) {
        mongoDatabase = MongoClients.create(URL).getDatabase("JavaWeb").getCollection("user"); // 链接数据库
    }

    /**
     * 查找一个用户名是否在数据库中
     *
     * @param username 用户名
     * @return 找到的用户信息，不存在返回 null
     */
    public User find(String username) {
        Document data = mongoDatabase.find(new Document("username", username)).first(); // 获取数据库中用户名相同的数据
        if (data == null || data.isEmpty()) { // 如果找不到则返回空
            return null;
        }
        return new User((String) data.get("username"), (String) data.get("password"), (String) data.get("sex")); // 否则返回获取的内容
    }

    /**
     * 添加一个新用户
     *
     * @param user 新用户
     */
    public void addUser(User user) {
        Document data = new Document("username", user.getUsername()).append("password", user.getPassword()).append("sex", user.getSex());
        mongoDatabase.insertOne(data);
    }
}
