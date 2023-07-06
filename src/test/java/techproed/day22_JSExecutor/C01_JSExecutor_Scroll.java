package techproed.day22_JSExecutor;

import junit.extensions.TestSetup;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecutor_Scroll extends TestBase {

    JavascriptExecutor js;
    @Test
    public void jsExecutorScrollTest() {

    //  https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


    // "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement weOffer = driver.findElement(By.xpath("//*[text()='we offer']"));
       // js = (JavascriptExecutor) driver;
       // js.executeScript("arguments[0].scrollIntoView(true);",weOffer);

        jsScroll(weOffer);
        bekle(3);


    // Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
       WebElement enrollFree=  driver.findElement(By.xpath("//span[text()='Enroll Free Course']"));
      // jsScroll(enrollFree); method ile

        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);
        bekle(3);


    // Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement whyUs = driver.findElement(By.xpath("//h3[text()='WHY US?']"));
        js.executeScript("arguments[0].scrollIntoView(true);",whyUs);
        bekle(3);


    // Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        jsScroll(enrollFree);
        bekle(3);


    // Sayfayi en üste scroll et (sayfayı kaydır)
      //  js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

        jsScrollHome();
        bekle(3);


    // Sayfayı en alta scroll et (sayfayı kaydır)

       // js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        jsScrollEnd();











    }
}
