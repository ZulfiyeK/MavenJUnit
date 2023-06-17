package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test() {

        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak "selenium" yazdıralım ve shift tuşunu serbest bırakarak "java" yazdıralım
        WebElement aramaKutusu =driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).sendKeys("selenium ").keyUp(Keys.SHIFT).sendKeys("java", Keys.ENTER).perform();

    }

    @Test
    public void test1() {

        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak "selenium" yazdıralım ve shift tuşunu serbest bırakarak "java" yazdıralım
        WebElement aramaKutusu =driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT, "selenium ",Keys.SHIFT,"java", Keys.ENTER);// burada actions kullanmadan yazdirdik.
        /*
         mouse islemlerini kullanmak icin (pageup-down, double click, sag click, mouse'u götür) actions kullaniriz.
         klavye islemlerinde actions a gerek yoktur.
        */
   /*
    Mause işlemleri için actions class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri için
    actions class'ına kullanmadan sendKeys() methodu ile de istediğimiz bir metni büyük yazdırabilir,
    hatta bir den fazla klavye tuşlana bastırabiliriz. Yukardaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
    sonrasında yazdırmak istediğimiz metni küçük harfle yazmamıza rağmen büyük harflerle yazdırdı, tekrar Keys.SHIFT
    kullanarak shift tuşunu serbest bırakmış olduk
     */

    }

    @Test
    public void test2() {

      //google sayfasına gidelim
        driver.get("https://google.com");


      // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu =driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium",Keys.ENTER);

      // Sayfayı bekleyin
        bekle(3);


        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys(Keys.CONTROL,"a");
        //-->sayfa yenilendiği için tekrar locate aldık ve Metni kesebilmemiz için önce ctrl+a ile seçmemiz gerekir
        bekle(2);

        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys(Keys.CONTROL,"x");//-->Seçilen metni ctrl+x ile kestik
        bekle(2);


        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().back();
        bekle(2);
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys(Keys.CONTROL,"v",Keys.ENTER);
        //-->Kestiğimiz metni ctrl+v tusu ile tekrar arama kutusuna yapıştırdık ve arattık






    }
}
