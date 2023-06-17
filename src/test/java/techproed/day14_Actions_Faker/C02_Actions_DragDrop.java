package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {

    @Test
    public void test() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));//bir tane oldugu icin locate almadan indeks ile de yapilabilir.
        //driver.switchTo().frame(0); bir tane oldugu icin indeks 0, locate etmeye gerek yok.
        driver.switchTo().frame(iframe);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();// tasi ve birak

         /*
            Eğer bir hareketli webelementi tutup başka bir webelementin üzerene bırakmak istersek
            sürüklemek istediğimiz we'tin locatini alıp üzerine bırakacağımız we'tin locate'ini de alarak
            dragAndDrop(kaynak,hedef) methodu ile işlemi gerçekleştirebiliriz
         */
    }


    @Test
    public void test1() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        driver.switchTo().frame(0); //bir tane oldugu icin indeks 0, locate etmeye gerek yok.
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).moveToElement(drop).release().perform(); // clickandHoll(drag) sol tus basili sekilde bekliyor,
                                                                            // moveToElement(drop) ile tasiyor
                                                                            // release() ile de birakiyor.
    }


    @Test
    public void test2() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).moveByOffset(160,28).release().perform(); //moveByOffset(84,28) belirttigimiz kordinatlara tasir, koordinatlari kendimiz buluyoruz.
    }


}
