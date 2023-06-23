package techproed.day18_SecreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WebElementScreenshot extends TestBase {

    /*
    Bir webelementin resmini almak için önce Webelementi locate edip bir webelemente assing ederiz.
    ve bu webelementi direk getScreenShotAs() methodunu kullanarak resmini belirttimiz dosyaya kaydederiz.
    */

    @Test
    public void test04() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //iphone aratalim
        driver.findElement(By.xpath("//*[@id ='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);



        //Cikan sonucun ekran görüntüsünü alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String tarih = new SimpleDateFormat("_ddMMyyyy_hh_mm_ss").format(new Date());
        String dosyaYolu = "src/test/java/tumWebElementResimleri/WebElementScreenshot" + tarih+ ".jpg" ;
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }
}
