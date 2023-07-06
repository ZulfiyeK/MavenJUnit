package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecutor_Type extends TestBase {

    @Test
    public void JSExecutorType() {

        //  https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        // Arama kutusuna "QA" yazıp aratın
        //********1. YOL***************
        WebElement aramaKutusu =driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));
        //JavascriptExecutor js= (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].value='QA'",aramaKutusu);

        //sendKeysJS(aramaKutusu,"QA"); hazir method olusturup utills'den aldik


        //********* 2. YOL ***********
        // WebElement aramaKutusu =driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));
        //JavascriptExecutor js= (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);

        sendAttributeJS(aramaKutusu,"QA");//method olsuturup

        aramaKutusu.submit();




    }
}
