package techproed.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Scanner;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01 {

   //CheckBox

//Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    WebDriver driver;


//a. Verilen web sayfasına gidin.

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

           }


//https://the-internet.herokuapp.com/checkboxes
//b. Checkbox1 ve checkbox2 elementlerini locate edin.
//c. Checkbox1 seçili değilse onay kutusunu tıklayın
//d. Checkbox2 seçili değilse onay kutusunu tıklayın

    @Test
    public void herokuapp() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        Thread.sleep(2000);
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }


        WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        if(!checkbox2.isSelected()){
            checkbox2.click();
        }
        Thread.sleep(2000);
    }
/*
    @After
    public void tearDown() throws Exception {
        driver.close();
    }
*/

//Radio Button


//2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
//- https://www.facebook.com adresine gidin
//- Cookies’i kabul edin
//- “Create an Account” button’una basin
//- “radio buttons” elementlerini locate edin
//- Secili degilse cinsiyet butonundan size uygun olani secin


    @Test
    public void facebook() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement sifreniMiUnuttun = driver.findElement(By.xpath("//*[text()='Şifreni mi Unuttun?']"));

        WebElement CreateAnAccount = driver.findElement(with(By.tagName("a")).below(sifreniMiUnuttun));
        CreateAnAccount.click();
        Thread.sleep(2000);



        WebElement radioButtonK = driver.findElement(By.xpath("(//*[@name ='sex'])[1]"));
        WebElement radioButtonE = driver.findElement(By.xpath("(//*[@name ='sex'])[2]"));
        WebElement radioButtonO = driver.findElement(By.xpath("(//*[@name ='sex'])[3]"));

        radioButtonK.click();
        Thread.sleep(2000);
        radioButtonE.click();
        Thread.sleep(2000);
        radioButtonO.click();

        //cozum devam ediyor.



    }
}
