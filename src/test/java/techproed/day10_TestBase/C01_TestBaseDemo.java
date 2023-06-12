package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    @Test
    public void test1() {
        //techproeducation sayfasına gidiniz
        driver.get("https://techproeducation.com");


        //Baslıgın "Bootcamp" icerdigini test ediniz
        Assert.assertTrue(driver.getTitle().contains("Bootcamp"));

        //2. yol
        String actuelTitle = driver.getTitle();
        String expectedTitle= "Bootcamp";
        Assert.assertTrue(actuelTitle.contains(expectedTitle));

    }

    /*
    ALERT = kullaniciyaq bilgi vermek icin ya da izin istemek icin goruntulenen mesaj kutusudur.
     - Html Alerts
     - Js Alerts
        - Simple Alert : Basit bilgi ve uyari iceriri, ok deyince kapanir.
        - Confirmation Alert : Bir tur islem yapma izni ister, ok yada cancel botununa basinca kapanir.
        - Prompt Alert : Bazi girdiler ister, sendKeys() kullanilarak giderilir.
*/
}
