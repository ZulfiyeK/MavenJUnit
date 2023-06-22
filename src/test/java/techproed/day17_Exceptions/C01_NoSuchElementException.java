package techproed.day17_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    /*
    yanlis locator, sayfanin yuklenmesinde yavaslamalar ve problemler,
    sakli olan elementlet veya alert, iframe gibi durumlarda  bu hata alinir.

    locat kontrol edilerek sorun giderilir.
     */


    @Test
    public void NoSuchElementException() {

        //techproEducation sayfasina gidiniz.
        driver.get("https://techproeducation.com");
        bekle(2);


        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);


        //searchBox'a java yazip aratalim
        driver.findElement(By.xpath("/input[@id='elementor-search-form-9f26725']")).sendKeys("Java", Keys.ENTER);
        //bilerek hata yaptik ve NoSuchElementException hatasi aldik.



    }
}
