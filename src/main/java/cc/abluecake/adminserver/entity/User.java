package cc.abluecake.adminserver.entity;

// 实体类不推荐使用基本类型，推荐使用包装类，当没有传值时默认赋null，用作区分
public class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
