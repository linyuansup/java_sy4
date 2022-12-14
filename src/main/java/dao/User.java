package dao;

public class User {
    private final String username;

    /**
     * 获取用户名
     *
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 获取密码
     *
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    private final String password;
    private final String sex;

    /**
     * 构建一个用户对象
     *
     * @param username 用户名
     * @param password 密码
     * @param sex      性别
     */
    public User(String username, String password, String sex) {
        this.username = username;
        this.password = password;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return username + "," + password + "," + sex;
    }

    /**
     * 比较密码
     *
     * @param password 需要比较的密码
     * @return 密码是否相同
     */
    public boolean comparePassword(String password) {
        return this.password.equals(password);
    }

    /**
     * 获取性别
     *
     * @return 性别
     */
    public String getSex() {
        return sex;
    }
}
