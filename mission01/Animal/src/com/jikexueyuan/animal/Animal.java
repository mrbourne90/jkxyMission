package com.jikexueyuan.animal;

/**
 * Created by Administrator on 2016/5/7 0007.
 * 动物类
 */
abstract public class Animal {

    private String name;

    public abstract void voice();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
