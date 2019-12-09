package cn.edu.zju.aimforoffer.algorithm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author cnxsliu
 * @description
 * @date 2019/12/9 22:04
 */
class A003FindTest {

    A003Find a003Find;
    @BeforeEach
    void setUp() {
        a003Find = new A003Find();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void find() {
        int[][] array = {{1,2,3},{2,3,4}};
        int target = 2;
        System.out.println("result : " + a003Find.find(array,target));
    }
}