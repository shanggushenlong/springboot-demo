package com.shanggushenlong.springbootview.springboot_thymeleaf.bean;

public class Student {
    private Integer id;
    private String username;
    private String age;

    @Override
    public String toString() {
        return "StudentController{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
