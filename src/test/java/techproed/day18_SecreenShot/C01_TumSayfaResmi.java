package techproed.day18_SecreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_TumSayfaResmi extends TestBase {

    /*
      SCREENSHOT
      Selenium'da tüm ekran görüntüsünü alabilmek için TakeScreenShot arayüzünden bir obje oluşturup
      driver'a eşitleriz. Arayüzler farklı olduğu için casting yaparız ve bu oluşturduğumuz obje ile
      getScreenshotAs methodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek
      oranın yolunu belirtiriz.
     */

    @Test
    public void test() throws IOException {
        //Techproeducation sayfasine gidelim
        driver.get("https://www.techproeducation.com");
        bekle(1);

        //Cikan reklami kapatalim
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        bekle(1);

        //Ve ekran goruntusunu alalim.

         /*
         -İlk olarak SS aldığımızda nereye kaydetmek istiyorsak oranın yolunu belirtelim
         -İkinci olarak TakesScreenShot arayüzünden obje oluştururuz
         -Üçüncü olarak FileUtils class'ından copyFile() methodu ile ts objemizi kullanarak getScreenShotAs methodu ile
          dosya yolunu belirteceğiz
         */

        String dosyaYolu = "src/test/java/tumSayfaResmi/screenShot.png";// yolumuzun sonuna " /screenShot.png " bunu ekliyoruz.
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }

    @Test
    public void test02() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("ScreenShot/screenShot.png"));// .idea dosyasi altinda olusturdu altinda olusturacak
    }


}
