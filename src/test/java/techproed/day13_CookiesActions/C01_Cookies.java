package techproed.day13_CookiesActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test1() {

        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");


        //2-tum cookie’leri listeleyin
        /*
        Cookie'leri listelemek istersek
            driver.manage().getCookies() methodu ile bir Set ya da ArraList'e atarak listeyebiliriz
            kac tane cookie var, su su isimde cookie var mi diye sorulabilir. Bu sebeple bunlari bilmekte fayda var.
         */

        //1. yol lambda ile
          //Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);

        //2. yol
        Set<Cookie> cookieSet = driver.manage().getCookies();  // bu sayfadaki butun cookie' leri set'e assign ettik.
        int sayac = 1;
        for (Cookie w: cookieSet) {
            System.out.println(sayac + " . cookie : " +w );
            System.out.println(sayac + " . cookie name : " + w.getName()); //cookie'lerin isimlerini aliriz.
            System.out.println(sayac + " . cookie value : " + w.getValue());// //cookie'lerin valuelerini aliriz.

            sayac++;
        }




        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("Cookie Sayisi :"+cookieSet.size());
        Assert.assertTrue(cookieSet.size()>5);
        //Assert.assertTrue(sayac>5); //boyle de olur.


        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actuelCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue,actuelCookieValue);

        //getCookieNamed() methodu ile bize verilen cookie isminin getValue() methoduyla gercek degerini actualCookieValue degiskenine assign ettik



        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);



        //6-eklediginiz cookie’nin sayfaya eklendigini test
        cookieSet = driver.manage().getCookies();
        for (Cookie each:cookieSet) {
            System.out.println(each);
        }
        Assert.assertEquals("cikolatali", driver.manage().getCookieNamed("en sevdigim cookie").getValue());
        System.out.println("Cookie'lerin sayisi = "+cookieSet.size());
        //System.out.println("Cookie'lerin sayisi = "+Arrays.stream(driver.manage().getCookies().toArray()).count());




        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        int silinmedenOnce = cookieSet.size();
        System.out.println("Silinmeden Once Cookie Sayisi = "+silinmedenOnce);
        bekle(2);
        driver.manage().deleteCookieNamed("skin");//-->ismi skin olan cookie'yi sildik
        bekle(2);
        cookieSet = driver.manage().getCookies();//Silindikten sonra cookieSet'e yine atama yapiyoruz guncelliyoruz aksi taktirde fail aliriz
        int silindiktenSonra = cookieSet.size();
        System.out.println("Silindikten Sonra Cookie Sayisi = "+silindiktenSonra);
        Assert.assertEquals(1,(silinmedenOnce-silindiktenSonra));


        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//tum cookie'leri sildik
        cookieSet = driver.manage().getCookies();// guncelleme yaptik
        Assert.assertTrue(cookieSet.isEmpty());// icinin bos oldugunu teset ettik



























    }
}
