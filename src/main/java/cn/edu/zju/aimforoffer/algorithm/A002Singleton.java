package cn.edu.zju.aimforoffer.algorithm;

/**
 * @description: 单例设计模式，线程懒汉式：静态内部类
 * @author: cnxsliu
 * @date: 2019/12/9 20:41
 */
public class A002Singleton {

    private static class SingletonHolder{
        private static A002Singleton ourInstance = new A002Singleton();
    }

    public static A002Singleton getInstance(){
        return SingletonHolder.ourInstance;
    }
    private A002Singleton(){
    }

}
