package zzw.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Description:
 *
 * @version 1.0
 * @Author zzw
 * @Date: 2018/2/27 19:53
 */
public class DemoTest {

    public Demo demo;
    @Before
    public void setUp() throws Exception {
        demo = new Demo ("1","1");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        Demo demo1 = new Demo ("1","1");

        int a = demo.add (3,5);
        System.out.println (a);
        assert (a == 8);
//        assert (demo.add(3,5)==8);
    }

    @Test
    public void minus() {
        Demo demo1 = new Demo ("1","1");
        int a = demo1.minus (5,3);
        System.out.println (a);

    }

    @Test
    public void getName() {
    }

    @Test
    public void setName() {
    }
}