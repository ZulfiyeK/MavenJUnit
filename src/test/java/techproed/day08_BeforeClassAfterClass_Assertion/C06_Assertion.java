package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertion {
    @Test
    public void test01() {
        Assert.assertEquals(2,2);
        System.out.println("Test basarili bir sekilde calisti");
    }

    @Test
    public void test02() {
        Assert.assertEquals(3,3);
        System.out.println("Test basarili bir sekilde calisti");
    }
    @Test
    public void test03() {
        Assert.assertNotEquals(5,5);
        System.out.println("Test basarili bir sekilde calisti");// hata aldigi yerden sonraki testleri de calismiyor.
    }
    @Test
    public void test04() {
       String actualName= "Zulfiye";
       String expectedName = "ZULFIYE";

        System.out.println("Test basarili bir sekilde calisti");
        System.out.println("Test basarili bir sekilde calisti");
        System.out.println("Test basarili bir sekilde calisti");
        System.out.println("Test basarili bir sekilde calisti");
        System.out.println("Test basarili bir sekilde calisti");
        Assert.assertNotEquals(actualName,expectedName);//burdan sonrasini yazdirmaz.
        System.out.println("Test basarili bir sekilde calisti");
        System.out.println("Test basarili bir sekilde calisti");
        System.out.println("Test basarili bir sekilde calisti");
        System.out.println("Test basarili bir sekilde calisti");
        System.out.println("Test basarili bir sekilde calisti");
    }
    @Test
    public void test05() {
        int yas1 = 37;
        int yas2 =45;
        Assert.assertTrue(yas1>yas2);
        System.out.println("Test basarili bir sekilde calisti");
    }
    @Test
    public void test06() {
        int yas1 = 37;
        int yas2 =45;
        Assert.assertTrue(yas1<yas2);
        System.out.println("Test basarili bir sekilde calisti");
    }
    @Test
    public void test07() {
        int yas1 = 37;
        int yas2 =45;
        Assert.assertFalse(yas1<yas2);
        System.out.println("Test basarili bir sekilde calisti");
    }
}
