package cn.edu.zju.aimforoffer.algorithm;

/**
 * @description: 单例设计模式，线程懒汉式：静态内部类
 * @author: cnxsliu
 * @date: 2019/12/9 20:41
 */
public class A002_Singleton {

    private static class SingletonHolder{
        private static A002_Singleton ourInstance = new A002_Singleton();
    }

    public static A002_Singleton getInstance(){
        return SingletonHolder.ourInstance;
    }
    private A002_Singleton(){
    }

}
