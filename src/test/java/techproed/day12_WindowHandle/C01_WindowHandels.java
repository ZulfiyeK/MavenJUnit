package techproed.day12_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandels extends TestBase {

    @Test
    public void windowHandles() {


        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        //  ilk sayfasının Handle degerini alın yazdırın
        String herokuappHandle = driver.getWindowHandle();
        System.out.println("herokuappHandle = " + herokuappHandle);


        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actuelText = driver.findElement(By.xpath("//h3")).getText();

        Assert.assertEquals(actuelText,"Opening a new window");


        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.

        Assert.assertEquals(driver.getTitle(),"The Internet");
        bekle(2);


        //  "Click Here" butonuna tıklayın.
        WebElement clickHere = driver.findElement(By.xpath("(//a)[2]"));
        clickHere.click();
        Set<String> handleDegerlerSet = driver.getWindowHandles();//tüm sekmelerin sirasiyla handle degerini verir.
        System.out.println("handleDegerler = " + handleDegerlerSet);

        String sayfaikiHandle = "";
        for (String w: handleDegerlerSet) {
            if(!w.equals(herokuappHandle)){
                sayfaikiHandle=w;
            }
        }

        driver.switchTo().window(sayfaikiHandle);
        /*
        burada biz tikladigimizda kendisi yeni bir sekme aciyor. bu sekmeyi biz kendimiz acmadigimiz icin driver ilk satfada kaliyor
        bu sebeple ikinci acilan sayfanin handle degerini almam gerekiyor. getWindowHandles() methodu ile
        tum sekmelerin handle degerlerini set icine atarak istedigimiz handle degerine ulasabiliriz.

        //eger 2den fazla sekme acilirsa nested if yani coklu if kullanarak halledilebilir

         */


        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        bekle(2);
        String ikinciSayfaTitle = driver.getTitle();
        Assert.assertEquals("New Window",ikinciSayfaTitle);
        bekle(2);


        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(herokuappHandle);
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(2);


        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(sayfaikiHandle);
        bekle(2);


        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(herokuappHandle);
        bekle(2);






    }
}
