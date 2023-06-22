package techproed.day17_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C05_StaleElementReferenceException extends TestBase {

    @Test
    public void StaleElementReferenceException1() {

        // Amazon sayfasına gidelim
        driver.get("https://amazon.com");


        // arama motoruna iphone yazıp aratalım
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone" + Keys.ENTER);


        // cıkan sonuclardan ilk 5'ine tıklayıp sayfa baslıklarını alalım konsola yazdıralım
        List<WebElement> iphoneUrunleri = driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));



        for (int i = 0; i < iphoneUrunleri.size(); i++) {
          //  iphoneUrunleri = driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));
          //  webelementi burada da yazmazsam yukarida aldigim locate bayatlar ve StaleElementReferenceException hatasi alirim.

            iphoneUrunleri.get(i).click();
            System.out.println(i+". urun title : " + driver.getTitle());
            driver.navigate().back();
            if(i==4){
                break;
            }
        }




    }
}
