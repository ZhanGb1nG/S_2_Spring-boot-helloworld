package com.example.demo.config;

import com.example.demo.pojo.GirlFriend;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * person容器注入配置
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/9 16:33
 * @Version 1.0
 **/
@Component
//@PropertySource({"application.yml"})
@ConfigurationProperties(prefix = "person")
public class PersonConfig {
    private String name;
    private String age;
    private String sex;
    private String birthDate;
    private GirlFriend girlFriend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public GirlFriend getGirlFriend() {
        return girlFriend;
    }

    public void setGirlFriend(GirlFriend girlFriend) {
        this.girlFriend = girlFriend;
    }

    @Override
    public String toString() {
        return "PersonConfig{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", girlFriend=" + girlFriend +
                '}';
    }
}
