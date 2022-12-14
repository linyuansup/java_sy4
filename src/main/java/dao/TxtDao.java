package dao;

import java.io.*;

public class TxtDao {

    private final BufferedReader bufferedReader;
    private final BufferedWriter bufferedWriter;

    /**
     * 构建一个 txt 数据库读取对象
     *
     * @param filePath txt 路径
     */
    public TxtDao(String filePath) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查找一个用户名是否在数据库中
     *
     * @param username 用户名
     * @return 找到的用户信息，不存在返回 null
     */
    public User find(String username) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            if (data[0].equals(username)) {
                return new User(data[0], data[1], data[2]);
            }
        }
        return null;
    }

    /**
     * 添加一个新用户
     *
     * @param user 新用户
     * @throws IOException IO 错误
     */
    public void addUser(User user) throws IOException {
        bufferedWriter.write(user.toString());
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
}
