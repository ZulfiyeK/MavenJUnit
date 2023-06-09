package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.WatchEvent;

public class C02_Alert extends TestBase {

      /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.


    Bir metod olusturun: acceptAlert
    1. butona tıklayın,
    uyarıdaki OK butonuna tıklayın
    ve result mesajının "You successfully clicked an alert" oldugunu test edin.



    Bir metod olusturun: dismissAlert
    2. butona tıklayın,
    uyarıdaki Cancel butonuna tıklayın
    ve result mesajının "successfuly" icermedigini test edin.



    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın,
    uyarıdaki mesajı konsolda yazdırın,
    uyarıdaki metin kutusuna isminizi yazin,
    OK butonuna tıklayın
    ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    @Test
    public void acceptAlert() throws InterruptedException {


        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        Thread.sleep(1500);

        //1. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        //2.yol : driver.findElement(By.xpath("(//button)[1]")).click();
        Thread.sleep(1500);

        // uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept();  //switchTo(); gecmek, degistirmek anlaminda kullanilir. driver i bulundugu konumdan alert durumna gecirir.
        Thread.sleep(1500);            // driver'imi alert'un oldugu ortama gecirdim, accept ile de cikan uyariyi ok ile onayladim.


        // ve result mesajının "successfuly" icermedigini
         String actuelResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";

        Assert.assertEquals(actuelResult,expectedResult);

    }

    @Test
    public void dismissAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        Thread.sleep(1500);


        //2. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        //2.yol : driver.findElement(By.xpath("(//button)[2]")).click();
        Thread.sleep(1500);

        //    uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();
        Thread.sleep(1500);


        // ve result mesajının "successfuly" icermedigini test edin.
        String actuelResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "successfuly";

        Assert.assertFalse(actuelResult.contains(expectedResult));

    }


    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        Thread.sleep(1500);

        //3. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        //2.yol : driver.findElement(By.xpath("(//button)[2]")).click();
        Thread.sleep(1500);


        //    uyarıdaki mesajı konsolda yazdırın,
        System.out.println(driver.switchTo().alert().getText());


        // uyarıdaki metin kutusuna isminizi yazin,
         driver.switchTo().alert().sendKeys("Zulfiye");


        // OK butonuna tıklayın
        driver.switchTo().alert().accept();


        //    ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actuelResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "Zulfiye";

        Assert.assertTrue(actuelResult.contains(expectedResult));
    }
}
