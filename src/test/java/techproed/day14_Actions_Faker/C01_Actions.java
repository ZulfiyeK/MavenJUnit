package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void test() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        bekle(2);

        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();// her iki turlu yazilabilir.
        bekle(2);


        //sayfanin ustune dogru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();

    }


    @Test
    public void test1() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        bekle(2);

        //sayfanin en altina gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();// her iki turlu yazilabilir.
        bekle(2);


        //sayfanin en ustune gidelim
        actions.sendKeys(Keys.HOME).perform();
        //build() methodu ile birden fazla olusturdugumuz actionlari birbirine baglariz,
        // boylece hepsinin sonuna perform eklemeye gerek kalmaz. en sonuncu actiona performdan once eklenerek kullanilir.
        // ancak bu sekilde tum actionlar baglandigi icin islemler cok hizli gereklesir.

        //release()--> masue'u birakir. ornegin bir cizgi cizmek istedigimizde birakmak istedigimizide bu methodu yazariz.
    }

    @Test
    public void test3() {

        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        bekle(2);

        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,1500).perform();// + deger girdigimizde sayfayi asagi kaydirir.
        bekle(2);


        //sayfanin ustune dogru gidelim
        actions.scrollByAmount(0,-1500).perform();// - deger girdigimizde sayfayi yukari kaydirir.



    }
}
