package techproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;



public class C02_ExpilicitWait extends TestBase {
    @Test
    public void test1() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");


        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();


        //Hello World! Yazının sitede oldugunu test et.
        WebElement helloWorld = driver.findElement(By.xpath("(//h4)[2]"));
        visibleWait(helloWorld,20);


        Assert.assertEquals("Hello World!", helloWorld.getText());


    }

    @Test
    public void test2() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");


        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();
        visibleWait(By.xpath("(//h4)[2]"),20);

        Assert.assertEquals("Hello World!", driver.findElement(By.xpath("(//h4)[2]")).getText());
    }
}
