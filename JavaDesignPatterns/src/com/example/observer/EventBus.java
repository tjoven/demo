package com.example.observer;
/**
 * 
 * @author car
 *1,EventBus类似于观察者模式,通过register函数将需要订阅事件的对象注册到事件总线中
 *2,根据@Subcriber注解来查找对象中的订阅方法,并且将这些订阅方法和订阅对象存储在map中
 *3,当用户在某个地方发布一个事件时,事件总线根据事件的参数类型和tag找到对应的订阅者对象
 *4,最后执行订阅者对象中的方法。这些订阅方法会执行在用户指定的线程模型中
 *	比如mode=ThreadMode.ASYNC则表示该订阅方法执行在子线程中
 */
public class EventBus {
}
