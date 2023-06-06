package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C05_RadioButtonClassWork {

//Radio Button


//2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
//- https://www.facebook.com adresine gidin
//- Cookies’i kabul edin
//- “Create an Account” button’una basin
//- “radio buttons” elementlerini locate edin
//- Secili degilse cinsiyet butonundan size uygun olani secin

    static WebDriver driver;

    @BeforeClass
    public static void before() throws Exception {
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");
    }

    @Test
    public void facebook() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement sifreniMiUnuttun = driver.findElement(By.xpath("//*[text()='Şifreni mi Unuttun?']"));

        WebElement CreateAnAccount = driver.findElement(with(By.tagName("a")).below(sifreniMiUnuttun));
        CreateAnAccount.click();
        Thread.sleep(2000);


        WebElement kadin = driver.findElement(By.xpath("(//*[@name ='sex'])[1]"));
        WebElement erkek = driver.findElement(By.xpath("(//*[@name ='sex'])[2]"));
        WebElement ozel = driver.findElement(By.xpath("(//*[@name ='sex'])[3]"));


        if(!kadin.isSelected()){
            kadin.click();
        }

        Thread.sleep(2000);

        if(!erkek.isSelected()){
            erkek.click();
        }

        Thread.sleep(2000);

        if(!ozel.isSelected()){
        ozel.click();
        }


    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}