package techproed.day18_SecreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C05_ScreenShotClassWork extends TestBase {

    @Test
    public void test() {

    //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//-->Reklamı kapatır
        bekle(2);


    //sayfanın resmini alalım
        allscreenShots();


    //Arama bölümünde java aratalım
        driver.findElement(By.id("elementor-search-form-9f26725")).sendKeys("java", Keys.ENTER);



    //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='elementor-heading-title elementor-size-default'])[1]"));
        WebElementscreenShots(sonucYazisi);



    //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");


    //sayfanın resmini alalım
        allscreenShots();


    //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);


    //ve sonuc yazısının resmini alalım
        WebElement amazonsonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        WebElementscreenShots(amazonsonucYazisi);

    //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        switchToWindow(0);//indeks'e gore ilk sayfaya gectik
        allscreenShots();//tum ekranin resmini aldik




    }
}
