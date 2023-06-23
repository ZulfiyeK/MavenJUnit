package techproed.day18_SecreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_TarihFormatliScreenShot extends TestBase {

    @Test
    public void test03() throws IOException {
        /*
        Kaydettiğimiz ekran resmini her seferinde aynı dosya üzerine yazmaması için dosya isminden sonra
        String bir değişkene tarih formatı atayabiliriz.
        */

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        String tarih = new SimpleDateFormat("_ddMMyyyy_hh_mm").format(new Date());//tarih ile ilgili yeni bir format olusturdum.
        //new SimpleDateFormat("_hh_mm_ss_ddMMyyyy") icini istedgimiz gibi duzenleyebiliriz.

        String dosyaYolu = "src/test/java/tumSayfaResmi/screenShot" + tarih+ ".png" ;
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }

    @Test
    public void test04() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //Ve ekran görüntüsünü alalım

        String tarih = new SimpleDateFormat("_ddMMyyyy_hh_mm").format(new Date());
        String dosyaYolu = "src/test/java/tumSayfaResmi/screenShot" + tarih+ ".jpg" ;
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }




}
