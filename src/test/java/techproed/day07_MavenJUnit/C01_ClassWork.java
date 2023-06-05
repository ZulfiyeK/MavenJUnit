package techproed.day07_MavenJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();//chrome driverı projeye yükledik
        WebDriver driver = new ChromeDriver();//obje oluşturduk
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");


//        2.Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        //driver.findElement(By.id("signin_button")).click();


//        3.Login alanine “username” yazdirin,Password alanine “password” yazdirin,Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));//
        login.sendKeys("username", Keys.TAB, "password",Keys.ENTER);
        // WebElement login = driver.findElement(By.cssSelector("input#user_login"));
        // login.sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        // Thread.sleep(2000);
        // driver.navigate().back();


//        4.online banking altında Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("(//*[text()=.])[11]")).click();//input[@id='online-banking'] id ile de bu sekilde.
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
//      (//*[text()=.])[11]") sonuna 11 yazmazsak eger, textin icerigi degistiginde kod hata verir.
//      11 yazarsak text'in icerigi degisse bile(online bank olsa) hata vermez, kod calisir.
        Thread.sleep(2000);


//        5.amount kismina yatirmak istediginiz herhangi bir miktari yazin ve tarih kismina “2020-09-10” yazdirin
         WebElement amount =  driver.findElement(By.xpath("//input[@id='sp_amount']"));
         amount.sendKeys("1000",Keys.TAB,"2020-09-10");// 6.adimi atlamak icin burda iki tab yapip enter diyebiliriz.
        Thread.sleep(2000);


//        6.Pay buttonuna tiklayin
         driver.findElement(By.xpath("//*[@id='pay_saved_payees']")).click();
        Thread.sleep(2000);



//       7.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement sonucYazisi= driver.findElement(By.xpath("(//span)[1]"));
        if(sonucYazisi.getText().equals("The payment was successfully submitted.")){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }


        /* 2. yol
         WebElement sonucYazisi= driver.findElement(By.xpath("//*[@title='$ 1000 payed to payee sprint']"));
         if(sonucYazisi.isDisplayed()){
            System.out.println("Gorunuyor");
         }else{
            System.out.println("Gorunmuyor");
         }

         */


        driver.close();
    }
}
