package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuter_GetValue extends TestBase {

    @Test
    public void JSExecuter_GetValue() {

        //  https://www.carettahotel.com/ sayfasına gidiniz
        driver.get("https://www.carettahotel.com/");

        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();

        //Check-In Date kisminin JS ile locate ediniz
       // JavascriptExecutor js = (JavascriptExecutor) driver;
       // WebElement date = (WebElement)js.executeScript("return document.getElementById('checkin_date')");

        JavascriptExecutor js = (JavascriptExecutor) driver;
       WebElement date = (WebElement) js.executeScript("return document.querySelector(\"input[id='checkin_date']\")");
       // basa  (WebElement) ekleyerek type casting yapmis olduk.


      /*
        Eger bir Web sayfasinda Web elementler olusturulurken Java Script kullanilmissa,
        yani developer bu html kodunda java script kullanmissa normal olarak locate almakta zorlanabiliriz.
        Bu gibi durumlarda "JavascriptExecutor" kullanarak webelement'i locate edebiliriz.

      */

        //Check-In Date kismina 05/25/2023 tarihini yaziniz
        date.clear();
        date.sendKeys("5/25/2023");

        //  Date webelementinin Attribute degerlerini yazdiralim

        String idAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').id").toString();
        String typeAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').type").toString();
        String nameAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').name").toString();
        String valueAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').value").toString();
        System.out.println("id Attribute Degeri = " + idAttributeDegeri);
        System.out.println("type Attribute Degeri = " + typeAttributeDegeri);
        System.out.println("name Attribute Degeri = " + nameAttributeDegeri);
        System.out.println("value Attribute Degeri = " + valueAttributeDegeri);

    /*
        Js executor ile attribute değerlerini yazdırabilmek için js ile locate ettiğimiz webelementin sonuna
        yukarıdaki örnekteki gibi hangi attributun değeri yazdırmak istersek sonuna attribute adını yazarız.
    */

        //Check-In Date kisminin degerini yaziniz
        String valueAttribute = (String) js.executeScript("return document.getElementById('checkin_date').value");
        System.out.println("valueAttribute = " + valueAttribute);

    }
}
