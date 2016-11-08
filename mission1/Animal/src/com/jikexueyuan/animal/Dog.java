package com.jikexueyuan.animal;

/**
 * Created by Administrator on 2016/5/7 0007.
 * 狗类
 */
public class Dog extends Animal {

    public Dog(String name){
        setName(name);
    }
    @Override
    public void voice() {
        System.out.println("我是一只狗，我叫" + getName());
    }
}
