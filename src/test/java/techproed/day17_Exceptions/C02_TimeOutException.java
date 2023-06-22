package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    /*
                 TimeOutException:
     Explicit wait kullanildiginda, ve element bulunamadiginda
     alinir.
     Explicit wait & yanlis locator-> timeout
     Explicit wait & doğru locator & sure yeterli degil -> timeout
     Explicit wait & dogru locator & sure yeterli & iframe var ->
     time out


                 Solution:
     -Sureyi arttirmak
     -Farkli explicit kullanmak: wait visibilityOfElementLocated
      YERINE presenceOfElementLocated. Yada javascript executor
      da ki waiter sayfa geçişlerini beklemek icin kullanabilirim
     -Locatori tekrar kontrol etmek
     -Frameworkunde hazir reusable method lar var Bu durumda
      timeoutexception aldigimda hızlıca o metotlar yardımıyla
      problemi cozebiliyoruz

 */

    @Test
    public void TimeOutExceptionTest1() {

        //techproEducation sayfasina gidiniz.
        driver.get("https://techproeducation.com");
        bekle(2);


        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);


        //searchBox gorunur olana kadar bekleyiniz.

        WebElement searchBox =  driver.findElement(By.xpath("/input[@id='elementor-search-form-9f26725']"));//HATALI KOD
        //hata alabilmek icin hatali girilmis kod..

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
       //2. yol
        // wait.until(ExpectedConditions.visibilityOf(By.xpath("//input[@id='elementor-search-form-9f26725']")));


        /*
        TimeOutException alabilmek icin visibilityOfElementLocated methodunu kullanarak yanlis bir
        locate aldik. Webelementi eklerken o webelementin locate ini bulamadigi icin max belittigimiz sure
        kadar ve TimeOutException hatasini verdi.
        */

    }

    @Test
    public void TimeOutExceptionTest2() {

        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Start butonuna tıklayınız
        driver.findElement(By.xpath("//button")).click();



        // Hello World! yazısının görünürlügünü test ediniz
        WebElement helloWorld = driver.findElement(By.xpath("(//h4)[2]"));
        //hello word yazisi gorunur oluncaya kadar bekledim.

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));// 15' i 1 yaparsak hata olacak, cunku webelementin gorunur olmasi icin yeterli degil.
        wait.until(ExpectedConditions.visibilityOf(helloWorld));

        Assert.assertTrue(helloWorld.isDisplayed());


        /*
        gercekte Hello World! yazisi ortalama 6 saniyede gozukuyor
        TimeOutException alabilmek icin Explicit Wait'e max bekleme sureisni 1 saniye verdik.
        Bu sebeple TimeOutException hatasi aldik.
 */


    }
}
