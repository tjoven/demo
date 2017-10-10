package com.tjoven.dataStruct;

public class Child extends Parent {

    static {
        System.out.println("Static Child");
    }

    public Child() {
        System.out.println("Child");
    }

    public static void main(String[] args) {
//        new Child();
//        new Child();
//    	play();
    }
    public static void play(){
    	System.out.println("static method");
    }
}

class Parent {

    static {
        System.out.println("Static Parent");
    }

    public Parent() {
        System.out.println("Parent");
    }

}


