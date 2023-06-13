package techproed.day11_Iframe_WindewHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    /*
    icinde oldugumuz sayfanin handle degerini
    driver.getWindowHandle():

    pencereler arasinda gecis yapmak icin
    driver.switchTo().window(sayfa1handle degeri);

     /*
        Eger sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle baska sayfaya gittikten sonra
        tekrar ilk actiginiz sayfaya dnmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir degisken handle degerini assign ederseniz tekrar ilk acilan sayfaya donmek istediginizde
        driver.switchTo().window(ilksayfaHandleDegeri) ile gecis yapabilirsiniz
     */




    @Test
    public void test() {

     //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproedWindowHandle = driver.getWindowHandle();


     //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actuelTitle= driver.getTitle();
        String expectedTitle= "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(actuelTitle,expectedTitle);


     //Window 2'de(yeni pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);//yeni pencerede acar.
        //driver.switchTo().newWindow(WindowType.TAB);//yeni sekmede acar.

        driver.get("https://www.youtube.com");
        String yourubeWindowHandle = driver.getWindowHandle();


     //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);//yeni bir pencere acar.
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        bekle(2);


     //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproedWindowHandle);
        bekle(2);


     //youtube sayfasına geçiniz:
        driver.switchTo().window(yourubeWindowHandle);
        bekle(2);


     //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        bekle(2);











    }
}
