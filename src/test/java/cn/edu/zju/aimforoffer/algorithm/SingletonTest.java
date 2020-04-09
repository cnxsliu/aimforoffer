package cn.edu.zju.aimforoffer.algorithm;


import org.junit.Before;
import org.junit.Test;

/**
 * @author cnxsliu
 * @description
 * @date 2019/12/9 20:55
 */
public class SingletonTest {

    A001Assign.MyString ms1;
    A001Assign.MyString ms2;

    @Before
    public void setUp() {
        System.out.println("Enter the method");
        ms1 = new A001Assign.MyString("a");
        ms2 = new A001Assign.MyString("b");
        ms2.assign(ms1);
    }

    @Test
    public void add() {
        System.out.println(ms2.equals(ms1));
    }

}