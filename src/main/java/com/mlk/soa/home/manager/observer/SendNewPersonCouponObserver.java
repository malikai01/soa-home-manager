package com.mlk.soa.home.manager.observer;

import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * @author malikai
 * @date 2021年06月03日 15:07
 */
public class SendNewPersonCouponObserver implements Observer {

    ExecutorService pool = Executors.newFixedThreadPool(2);

    @Override
    public void update(String message) {
        Future<String> future = pool.submit(() -> {
            TimeUnit.SECONDS.sleep(3);
            // 处理响应的业务逻辑
            return "调用发券服务，返回结果";
        });
        try {
            // 假设等待200毫秒 没有获取到返回值结果则认为失败
            System.out.println(future.get(4000, TimeUnit.MILLISECONDS));
        } catch (Exception e) {
            // 执行异步获取失败
            // 记录日志，定时任务重试等
        }

        // 第一种不关心返回值结果
         pool.submit(() -> {
             try {
                 TimeUnit.SECONDS.sleep(3);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             // 处理响应的业务逻辑
            System.out.println("发送新人优惠券");
        });
    }
}
