package com.mlk.soa.home.manager.observer;

/**
 * @author malikai
 * @date 2021年06月03日 15:08
 */
public class SendSuccessMessageObserver implements Observer {
    @Override
    public void update(String message) {
        // 处理业务逻辑
        System.out.println("注册成功");
    }
}
