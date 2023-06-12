package techproed.day10_TestBase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C04_DropDown extends TestBase {

    @Test
    public void tes1() throws InterruptedException {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Yıl Drodown'undan "2020" seciniz
        WebElement ddmYil = driver.findElement(By.xpath("//select[@id='year']"));
        bekle(2);

         //ddmIndex(ddmYil,3);//--yeni yil eklendiginde indeks degisebilir bu yuzden hata alinabilir.
        ddmValue(ddmYil,"2020");//--> select'in yanindaki ok tusuna basinca acilan liteden istedigim secenegin valuesini aldim.

        // Ay Dropdown'undan "August" seciniz
        WebElement ddmAy = driver.findElement(By.xpath("//select[@id='month']"));
        bekle(2);
        ddmVisibleText(ddmAy,"August");

        // Gün Dropdown'undan "5" seciniz
        WebElement ddmGun = driver.findElement(By.xpath("//select[@id='day']"));
        bekle(2);
        ddmVisibleText(ddmGun,"5");

    }
}
