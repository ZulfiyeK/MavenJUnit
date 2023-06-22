package techproed.day17_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_NullPointerException {
  /*
    NullPointerException:

    degisken yada obje olusturup bu degiskene atama yapmadıgımızda yada esitlemedigimizde
    NullPointerException hatası alırız.

     */


    WebDriver driver;

    Faker faker;

    Actions actions;

    Integer sayi;

    String isim;


    @Test
    public void NullPointerExceptionTest1() {
        // driver = new ChromeDriver(); atamasını yapmadıgımız icin NullPointerException hatasını aldık.
        driver.get("https://amazon.com");
    }


    @Test
    public void NullPointerExceptionTest2() {
        //faker = new Faker(); atamasini yapmadigimiz icin NullPointerException hatasi aldik.
        System.out.println(faker.name().firstName());//atama yapmadan yazdirmaya calisirsak hata aliriz.
    }

    @Test
    public void NullPointerExceptionTest3() {
     // actions = new Actions(driver); atamasını yapmadıgımız icin NullPointerException hatasını aldık.
        actions.doubleClick().perform();

    }

    @Test
    public void NullPointerExceptionTest4() {
        // sayi = 11; sayi degiskenine atama yapmadigim icin hata aldim.
        System.out.println(sayi+5);
    }
    @Test
    public void NullPointerExceptionTest5() {
        // iism degiskenine atama yapmadigim icin hata aldim.
        System.out.println(isim.charAt(0));
    }
}
