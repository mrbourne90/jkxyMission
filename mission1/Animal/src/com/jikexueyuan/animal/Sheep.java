package com.jikexueyuan.animal;

/**
 * Created by Administrator on 2016/5/7 0007.
 * 羊类
 */
public class Sheep extends Animal {

    public Sheep(String name){
        setName(name);
    }

    @Override
    public void voice() {
        System.out.println("我是一只羊，我叫" + getName());
    }
}
