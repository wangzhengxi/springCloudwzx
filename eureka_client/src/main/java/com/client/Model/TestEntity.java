package com.client.Model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by wangzhengxi on 2019/6/10.
 */
public class TestEntity {

    @NotEmpty
    private String name ;
    @NotNull
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
