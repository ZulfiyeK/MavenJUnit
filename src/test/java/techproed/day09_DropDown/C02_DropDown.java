package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    /*

    -getFirstSelectedOption()-->dropdown'daki en son sectigimiz option'i bize dondurur.
    -getOptions()--> dropdown'daki tum option'lari bize dondurur.

     */


    static  WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1() {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");


        // Select a State Dropdown'undan "Arizona" seciniz
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stetes = new Select(state);
        stetes.selectByVisibleText("Arizona");


        // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz
        WebElement sonSecilenOption = stetes.getFirstSelectedOption();
        String sonSecilenOptionStr = sonSecilenOption.getText();
        Assert.assertEquals("Arizona",sonSecilenOptionStr);



        // Select a State Dropdown'undaki tum optionları konsolda yazdırınız
        //1. yol
        //   List<WebElement> allOptions= stetes.getOptions();
        //   for (WebElement w :allOptions) {
        //        System.out.println(w.getText());
        //       }


        //2. yol
       // allOptions.stream().forEach(t-> System.out.println(t.getText()));//lambda ile yazilisi


        //3. yol
        List<WebElement> options = driver.findElements(By.xpath("//select[@id='state']//option"));//tum optionlarin locate'ini bu sekilde almis olduk
        options.stream().forEach(t-> System.out.println(t.getText()));                              //hepsini List'e atatdik ve foreach ile lambda ile yazdirdik.


    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
