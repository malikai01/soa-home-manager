package com.mlk.soa.home.manager.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author malikai
 * @date 2021年06月03日 15:10
 */
public class ConcreteSubject implements Subject {
    // 订阅者容器
    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        // 添加订阅关系
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        // 移除订阅关系
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        // 通知订阅者们
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
