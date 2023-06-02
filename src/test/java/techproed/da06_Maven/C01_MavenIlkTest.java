package techproed.da06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {

 /*
    Maven bir java derleme aracidir(build tool)
    Maven proje veotomasyon ve yonetim aracidir(automation and management tool)
    Maven , konfigurasyon icin pom.xml dosyasini kullanir.
    Bu dosya projenin insasi, reporlamasi ve dokumantasyonu icin gerkli butun builgileri icerir(dependencies, plugins)


    pom.xml --> Maven projesindeki en onemli dosyadir.
     */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //https://www.amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");


        //arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));



        //“Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);


        //Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String[] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi : "+sonucSayisi[2]);//Sonuc Sayisi : 19


        //Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//div[@class ='aok-relative'])[1]")).click();//By.xpath("(//h2//a)[1]" ) bununla da alinabilir.


        //Sayfadaki tum basliklari yazdiralim

        List<WebElement> sayfaBasliklari = driver.findElements(By.xpath("//h1 | //h2"));
        sayfaBasliklari.forEach(t-> System.out.println(t.getText()));


        driver.close();

    }
}
