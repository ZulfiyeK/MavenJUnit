package techproed.day17_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {

    /*
        StaleElementReferenceException :
        Bir web sayfasindaki bir webelementin gecerliligini kaybettigi durumlarda olusur.
        Yani bir webelementi'ni locate ettikten sonra sayfada refresh ve ya back-forward kullandiktan sonra
        yeniden o webelemente ulasmak istedigimizde StaleElementReferenceException hatasi aliriz.

        Bunu handle edebilmek icin webelemente yeniden ayni locate'i atamaliyiz.
        (web element artik bayatlamistir, webelementin locate'ini hatirlatma yapmaliyi.)

     */

    @Test
    public void StaleElementReferenceException1() {

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);


        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);


        //sayfayi yenileyelim
        driver.navigate().refresh();


        //LMS login butonuna tiklayalim.
        driver.findElement(By.xpath("(//a[@class='elementor-item'])[5]")).click();
    }

    @Test
    public void StaleElementReferenceException2() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);


        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);


        //LMS login butonuna locate'ini alalim
        WebElement login = driver.findElement(By.xpath("(//a[@class='elementor-item'])[5]"));


        //sayfayi yenileyelim
        driver.navigate().refresh();


        //LMS login butonuna tiklayalim.

        login.click();
        // yukarida aldigim locate, sayfa yenilenmesinden sonra bayatlamis oldu ve artik kullanilmaz durumda.
        //bu sebeple yenileme sonrasindaki  login.click(); kod calismadi.
        // Bunu handle yapabilmek icin yukaridaki locate'i burada da kullanmak zorundayim.

       // login = driver.findElement(By.xpath("(//a[@class='elementor-item'])[5]")); --> seklinde
       // login.click();

    }
}
