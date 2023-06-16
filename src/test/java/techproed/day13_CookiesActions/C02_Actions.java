package techproed.day13_CookiesActions;

import com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

/*
doubleClik()==> Webelement'e cift tik yapar
clikAndHold()==>Webelement'e click yapili olarak bizden komutbekler
dragAndDrop()==>Webelement'i bir noktadan digerine surukle ve birak
moveToElement()==>mouse'u istedimiz wWebelement'in uzerinde tutar
contexClick()==>istedigimiz Webelement'e sag tiklar

 */

public class C02_Actions extends TestBase {
    @Test
    public void test01() {

     //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");


     // Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        bekle(2);
        Actions actions = new Actions(driver);
        actions.contextClick(kutu).perform(); //contextClick(kutu) sag tik yaptik.
        bekle(2);                                        //perform() yaptigin islemi uygula.

     // Alert’te cikan yazinin“You selected a context menu”oldugunu test edin
        Assert.assertEquals("You selected a context menu",alertText());


     // Tamam diyerek alert’i kapatın
        alertAccept();












    }
}
