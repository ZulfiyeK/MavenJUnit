package techproed.day19_extentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C02_ExtentReport extends TestBase {

    @Test
    public void test() {

        extentReport("Chrome","Amazaon Testi");
        extentTest = extentReports.createTest("ExtentReport","Test raporu");

        //amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasina gidildi");


        //sayfanin resmini aliniz
        allscreenShots();
        extentTest.info("Sayfanin resmi alindi");


        //arama kutusunda iphone aratiniz.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratıldı");
        extentTest.pass("Sayfa kapatıldı");

    }
}
