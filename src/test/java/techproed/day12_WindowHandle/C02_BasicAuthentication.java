package techproed.day12_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {

    /*
    ¬Authentication: kimlik dogrulama yontemidir.
    ¬Soz konusu sisteme dahil olup olunamayacagini belirleyen formu ifade eder.
    ¬Authentication uzerinde sag click yapip locate alinamaz.
    ¬Authentication bir alert degildir, bir kimlik dogrulama yontemidir.
    ¬Authentication yapabilmek icin uygulamanin kullanicilara,
     Authentication'i nasil yapacagina dair bilgilendirme yapmis olmasi gerkir.
    ¬https://username:password@URL gibi( bununla sayfanin kimlik dogrulamsini gecebiliriz.)

     */


    @Test
    public void BasicAuthentication() {

    // Aşağıdaki bilgileri kullanarak authentication yapınız:

    // Url: https://the-internet.herokuapp.com/basic_auth
    // Username: admin
    // Password: admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    //Paragrafın "Congratulations" kelimesini içerdiğini dorulayiniz
        String text = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(text.contains("Congratulations"));


    }
}
