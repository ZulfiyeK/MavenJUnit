package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_AlertMethods extends TestBase {
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
        bekle(2);//TestBase classimizdan

        //1. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        bekle(2);//TestBase classimizdan

        // uyarıdaki OK butonuna tıklayın
        alertAccept();  //TestBase classimizdan
        bekle(2); //TestBase classimizdan


        // ve result mesajının "successfuly" icermedigini
        String actuelResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";

        Assert.assertEquals(actuelResult,expectedResult);

    }

    @Test
    public void dismissAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        bekle(2);


        //2. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        bekle(2);


        //uyarıdaki Cancel butonuna tıklayın
        alertDismiss();
        bekle(2);


        // ve result mesajının "successfuly" icermedigini test edin.
        String actuelResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "successfuly";

        Assert.assertFalse(actuelResult.contains(expectedResult));

    }


    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        bekle(2);

        //3. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        bekle(2);


        //uyarıdaki mesajı konsolda yazdırın,
        alertText();


        // uyarıdaki metin kutusuna isminizi yazin,
        alertPrompt("Zulfiye");
        bekle(2);


        // OK butonuna tıklayın
        alertAccept();
        bekle(2);


        // ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actuelResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "Zulfiye";

        Assert.assertTrue(actuelResult.contains(expectedResult));
    }
}
