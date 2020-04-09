package cn.edu.zju.aimforoffer.algorithm;

/**
 * @description: 实现单例设计模式
 * @author: cnxsliu
 * @date: 2019/12/9 20:41
 * @strategy: 1、由于只能生成一个实例，必须把构造函数设置为私有函数以禁止他人创建实例。
 * 2、加锁是一个非常耗时的过程，在没有必要的情况应该尽量避免。
 * 3、静态构造函数可以保证只调用一次。
 */

public class A002Singleton {

    private static class SingletonHolder {
        private static A002Singleton ourInstance = new A002Singleton();
    }

    public static A002Singleton getInstance() {
        return SingletonHolder.ourInstance;
    }

    private A002Singleton() {
    }

}
