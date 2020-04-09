package cn.edu.zju.aimforoffer.algorithm;

/**
 * 赋值运算符函数
 * 1.对于传入的参数，不应该被修改，使用final修饰；
 * 2.如果两个对象相同或值相等，不进行操作，直接返回；
 * 3.返回值最好为this，这样可以使赋值链接起来。
 * 一个缺点：此赋值从左到右进行，a=b=c等价于a=c，b不会被赋值；
 * 而如果是String的=运算，a,b都会被赋成c的值。
 *
 * @author cnxsliu
 * @strategy: 1、要把返回类型声明为该类型的引用，在函数结束前返回实例自身的引用；
 * 2、把传入的参数的类型声明为常量引用。这样可以避免调用一次复制构造函数，提高代码效率。同时我们在
 * 赋值运算函数内部不会改变传入的实例的状态，因此应该为传入的引用参数加上const参数。
 * 3、释放实例自身的已有的内存。防止内存泄露。
 * 4、判断传入的参数和当前的实例是否是同一个实例。
 */
public class A001Assign {
    public static class MyString {
        private String data;

        public MyString(String data) {
            this.data = data;
        }

        public MyString assign(final MyString another) {
            if (this == another || this.data.equals(another.data)) {
                return this;
            } else {
                this.data = another.data;
                return this;
            }
        }

        @Override
        public String toString() {
            return "MyString{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }

}
