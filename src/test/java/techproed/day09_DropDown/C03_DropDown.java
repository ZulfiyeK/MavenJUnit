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

public class C03_DropDown {

    static WebDriver driver;

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


        // Programlama Dili Dropdown'undan "Java" seciniz
        WebElement Languages = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select language = new Select(Languages);
        language.selectByVisibleText("Java");// selectByVisibleText --> gorundugu gibi yaz demek.



        // Programlama Dili Dropdown'undan son secilen option'un "Java" oldugunu test ediniz
        WebElement sonSecilen = language.getFirstSelectedOption();
        String sonSecilenOptionStr = sonSecilen.getText();//stringe donusturuyoruz.
        Assert.assertEquals("Java",sonSecilenOptionStr);


        // Programlama Dili Dropdown'undaki tum optionları konsolda yazdırınız
        List<WebElement> allLanguages = driver.findElements(By.xpath("//select[@name='Languages']//option"));
        allLanguages.stream().forEach(t-> System.out.println(t.getText()));

        
        //Sayfadaki tum dropdownlardaki tum optionlari yazdiralim
        //1. yol lambda
        List<WebElement> options = driver.findElements(By.tagName("option"));
        options.stream().forEach(t-> System.out.println(t.getText()));

        //2. yol
        for (WebElement w :options) {
            System.out.println(w.getText());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
