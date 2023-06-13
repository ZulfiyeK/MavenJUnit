package techproed.day11_Iframe_WindewHandle;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


public class C01_Iframe extends TestBase{


  /*
        IFrame: bir web sayfasi(html) icine yerlestirilmis baska bir web sayfasi(html)dir.
        ic ice yapilarda locate alinsa da nosuchelementexception aliriz.
                selenium iframe'i goremez. switchto() ile iframe gecmenin 3 yolu vardir.

              1. index ile
                 driver.switchto().frame(index of the iframe); index 0 dan baslar.

              2. id veya name value ile
                 driver.switchto().frame(id of the iframe);

              3. Webelement ile
                 driver.switchto().frame(webelement of the iframe);

         iframe'den cikmak icin iki komut vardir.

             driver.switchto().parentFrame();= bir ust seviyedeki frame
             driver.switchto().defaultContent();=en ustteki frame cikmak icin kullanilir.


    Bir HTML dokumaninin icine yerlestirilmis baska bir HTML dokumanina inline frame yani IFRAME denir
    Bir sayfada iframe varsa iframe icindeki webelementi handle edebilmek icin switchTo() methodu ile iframe'e gecis yapmamiz
    gerekir.Eger gecis yapmazsak nosuchelementexception aliriz.
    Alert'ten farki alert ciktiginda hicbir webelementi locate edemeyiz. iframe olsada locate ederiz fakat handler edemeyiz


   */


    //➢ https://testcenter.techproeducation.com/index.php?page=iframe
    //➢    Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
    //➢    Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
    //➢    Son olarak footer daki 'Povered By' yazisini varligini test edilip
    @Test
    public void iframe() {

        //==>  https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");


        //==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
        String metin = driver.findElement(By.xpath("(//p)[1]")).getText();
        System.out.println(metin);
        Assert.assertTrue(metin.contains("black border"));


        //==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
        driver.switchTo().frame(0);// index ile aldik. gecis yapmazsak Nosuchelementexception hatasi aliriz.
        String aplicationListYazisi = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(aplicationListYazisi);
        Assert.assertEquals("Applications lists",aplicationListYazisi);


        /*
        Applications lists yazısını dogru locate edip,
        dogru sekilde görünür oldugunu test etmemize ragmen Faild oldu
        bunun üzerine HTML kodlarını inceleyince Applications lists yazısının
        aslında bir iframe icerisinde oldugunu gördük bu durumda once iframe'i locate edip
        switchTo() ile iframe'e gecmeliyiz
         */


        //==>   Ana sayfadaki footer da 'Povered By' yazisinin "Povered" icerdigini test edin
        driver.switchTo().parentFrame();//iframe'den cikmazsam frame icindekini verir, ama ben anasayfadakini istedigim icin anasayfaya gecis yapmam lazim
        //driver.get(driver.getCurrentUrl()); sayfayi yeniler.
        //driver.navigate().refresh(); sayfayi yeniler
        String poveredBy =  driver.findElement(By.xpath("(//*[text()='Povered By'])[1]")).getText();
        System.out.println(poveredBy);
        Assert.assertTrue(poveredBy.contains("Povered By"));



        //Son olarak sayfa başınlığında iframe yazısının görünür olduğunu test ediniz
        driver.switchTo().defaultContent();
        //driver.get(driver.getCurrentUrl()); --> Sayfayı yeniledik
        //driver.navigate().refresh();
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        /*
            Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydik index'i 1 almam gerekicekti
        <body>
	            <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe")
		            <iframe id="innerIframe" src="https://www.google.com"></iframe> --> bu örnekte parentFrame ile bir üst frame geçiş yapabiliriz
	            </iframe>
            </body>

          İstersek WebElement frame = driver.findElement(By.xpath("//*[@id='outerIframe'")) bu şekilde locate ettiğimiz
        iframe'e driver.switchTo().frame(frame) geçiş yapabiliriz.
         */





    }


}
