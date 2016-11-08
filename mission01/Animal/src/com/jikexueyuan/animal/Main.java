package com.jikexueyuan.animal;

/**
 * Created by Administrator on 2016/5/7 0007.
 * 猫狗羊继承动物实现不同的叫声
 */
public class Main {

    public static void main(String args[]){

        Cat cat = new Cat("咪咪");
        Dog dog = new Dog("旺财");
        Sheep sheep = new Sheep("多利");

        cat.voice();
        dog.voice();
        sheep.voice();
    }
}
