package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


    /*
        DropDown : Alt basliklarin oldugu acilir menu listesidir.
        Dropdawn uc asamada handle edilir
        1. DropDown locate edilir.
        2. Select objeci olusturulmalidir
           Select select = new Select(ddm);
        3. Opsiyonlardan bir tanesi secilir
           - Dropdow'daki bir opsiyonu
            a. selectByIndeks()-->secmek istedigimiz opsiyonun indeksini yazarak kullanilir. indeks sifirdan "0" baslar.
            b. selectByValue()-->her opsiyonun bir value'si vardir. Opsiyona value ile ulasmak icin kyullanilir.
            c. selectByVisibleTeks()-->en cok bu tercih edilir. opsiyona ulasmak icin, parantezinin icerisinie istedigimiz opsiyonu metnini gorundugu sekilde yazilir.

Dropdown icindeki tum webelementlerini bir liste assign edebiliriz.Bu islem getOptions() methodu ile saglanir.

 */

public class C01_DropDown {
    static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void tes1() throws InterruptedException {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Yıl Drodown'undan "2020" seciniz
        WebElement ddmYil = driver.findElement(By.xpath("//select[@id='year']"));
        Thread.sleep(1500);
        Select options = new Select(ddmYil);
        Thread.sleep(1500);
        options.selectByVisibleText("2020");
        //options.selectByIndex(3);--yeni yil eklendiginde indeks degisebilir bu yuzden hata alinabilir.
        //options.selectByValue("2020");--> select'in yanindaki ok tusuna basinca acilan liteden istedigim secenegin valuesini aldim.

        // Ay Dropdown'undan "August" seciniz
        WebElement ddmAy = driver.findElement(By.xpath("//select[@id='month']"));
        Thread.sleep(1500);
        Select options1 = new Select(ddmAy);
        Thread.sleep(1500);
        options1.selectByVisibleText("August");

        // Gün Dropdown'undan "5" seciniz
        WebElement ddmGun = driver.findElement(By.xpath("//select[@id='day']"));
        Thread.sleep(1500);
        Select options2 = new Select(ddmGun);
        Thread.sleep(1500);
        options2.selectByVisibleText("5");

    }

    @After
    public void tearDown() throws Exception {
       //driver.close();
    }
}
