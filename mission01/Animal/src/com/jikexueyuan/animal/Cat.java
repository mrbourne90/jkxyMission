package com.jikexueyuan.animal;

/**
 * Created by Administrator on 2016/5/7 0007.
 * 猫类
 */

public class Cat extends Animal {

    public Cat(String name){
        setName(name);
    }
    @Override
    public void voice() {
        System.out.println("我是一只猫，我叫" + getName());
    }
}
