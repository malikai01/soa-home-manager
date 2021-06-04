package com.mlk.soa.home.manager.observer;

/**
 * @author malikai
 * @date 2021年06月03日 15:09
 */
public class TestMain {
    public static void main(String[] args) {
        // 假设用户注册成功直接通知观察者，改干自己的事情了
        ConcreteSubject subject = buildSubject();
        subject.notifyObservers("");
    }

    private static ConcreteSubject buildSubject() {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new SendSuccessMessageObserver());
        subject.attach(new SendNewPersonCouponObserver());
        return subject;
    }
}
