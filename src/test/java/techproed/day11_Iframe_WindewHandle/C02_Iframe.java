package techproed.day11_Iframe_WindewHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {
    @Test
    public void name() {


       //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");


        //sayfadaki toplam iframe sayısını bulunuz.
        int iframesayisi= driver.findElements(By.tagName("iframe")).size();
        System.out.println("iframesayisi = " + iframesayisi);


       //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String editor = driver.findElement(By.xpath(" //h3")).getText();
        Assert.assertTrue(editor.contains("Editor"));


       //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");//id ile aldim.
        WebElement textBox = driver.findElement(By.xpath("//p"));
        bekle(1);
        textBox.clear();


       //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        bekle(1);


       //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().parentFrame();
        WebElement elementalSelenium = driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
    }
}
