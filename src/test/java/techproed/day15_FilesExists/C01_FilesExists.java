package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {

    /*
     Selenium ile windows dosyalarini test edemiyoruz, ama java kullanarak test edebiliriz.
         System.getProperty("user.dir");--> icinde bulunan klasorun yolunu (Path) veriri.
         System.getProperty("user.home");-->bilgisayarimizda bulunan user klasorunu veriri.
         Files.exists(Paths.get(filePath));--> bilgisayarimizda dosyanin olup olmadigini kontrol eder.
     */

    @Test
    public void test01() {
        /*
        Bir web sitesini test ettigimizde download islemi yapildigi zaman dosyanin bilgisayarimiza inip inmedigini yani,
        dosyanin bilgisayarimiza varligini dogrulamak icin ya da bilgisayarimizda herhangi bir dosyanin varligini dogrulayabilmek icin;

        Files class'indan exists() methodunu kullanarak Paths.get(dosyayolu) methodunu kullanarak dosynin varligini test edebiliriz.
        Files.exists(Paths.get(filePath));--> bilgisayarimizda dosyanin olup olmadigini kontrol eder.
        Dolayisiyla bu isleme baslamadan once test edecegimiz dosyanin yolunu String bir degiskene assign edebiliriz.


         NOT:
          Windows10 sürümlerinden önceki sürümler için pratik olarak dosya yolu almak istersek
          yolunu almak istediğimiz dosyanun üzerine gelip shift+sag Klik tusuna basarak yol olarak kopyala
          seçeneği ile dosya yolunu kopyalayabiliriz.
         */

        String dosyaYolu = "C:/Users/zulfi/OneDrive/Masaüstü/deneme.docx";
        // String dosyaYolu2 = "\"C:\\Users\\zulfi\\OneDrive\\Masaüstü\\QA Road Map Şekilli Açılmlı.pdf\""; //bastaki ve sondaki tirnak ve slas silindiginde de kabul ediyor.
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//dosya varsa true ,yoksa false doner.
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));//bu sekilde de varligini dogrulamis olurum

    }

    @Test
    public void test02() {

           String dosyaYolu = "C:\\Users\\zulfi\\OneDrive\\Masaüstü\\deneme.docx";
            //--> "C" den once ve en sondaki çift tırnaktan önce /" olmayacak
            System.out.println(Files.exists(Paths.get(dosyaYolu)));//-->Dosya varsa True yoksa False döner
            Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }


    @Test
    public void test03() {
        /*
        Bir server de farkli isletim sistemleri ile ayni anda dosya varligini test etmek istedigimiz zaman,
        daha dinamik olmasi acisindan System.getProperty("os.name") -->seklinde isletim sistemi alir. 
        her isletim sisteminin kullanici yolu farkli olacagindan, System.getProperty("user.home"); bilgisayarimizdaki kullanici yolunu bu sekilde alip 
        Stringbir degiskene farkliYol ismi ile System.getProperty("user.home");atayarak her seferinde farkli yollari alamayla ugrasmamis oluruz.
        Diyelimki dosya masaustunde ve her isletim sisteminde bize ayni yolu verecegi icin bunun da ortak yol olarak bir String'e assign ederiz.
        
         */


        // Dosya yolum ==> String dosyaYolu = "C:/Users/zulfi/OneDrive/Masaüstü/deneme.docx";
        String farkliYol = " ";
        String isletimSistemiAdi = System.getProperty("os.name");//operation System-->os isletim sistemi adini verir.
        System.out.println(isletimSistemiAdi);//Windows 11
        System.out.println(System.getProperty("user.home"));//C:\Users\zulfi-- kullanidi adinin yolunu veriri.

        if(isletimSistemiAdi.contains("Win")){            //isletim sistemi adi "Win" iceriyorsa yol adi olarak
            farkliYol=System.getProperty("user.home");   //bunu ver..
        } else if (isletimSistemiAdi.contains("mac")) {  //isletim sistemi adi "mac" iceriyorsa alttakini ver..
            farkliYol="/Users/Ozcn";                  //farkli bir isletim sistemi yolu da olabilir.
        }
        String ortakYol = "/OneDrive/Masaüstü/deneme.docx";
        String dosyaYolu = farkliYol+ortakYol;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        try {
            Files.delete(Paths.get(dosyaYolu));//tamamen siler, geri getirilemez.
        } catch (IOException e) {
            System.out.println("Dosya bulunamadi");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));


        //C:/Users/zulfi/OneDrive/Masaüstü/QA Road Map Şekilli Açılmlı.pdf"; benim dosya yolum bu..
        //--> C:/Users/Ozcan bu kisim isletim sistemlerine gore degistigi icin farkliyol oluyor...kalan kisim ise ayni oldugu icin ortak yol oluyor..


        //Sildigimiz dosya isminde ayni yolu kullanarak yeni bir dosya olusturalim..
        try {
            Files.createFile(Paths.get(dosyaYolu));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
          Her seferinde test ettigimiz sayfada download islemi yapiliyorsa gereksiz dosya kalabaligini onlemek icin
          yukardaki delete islemini kullanabiliriz
        */




    }



    @Test
    public void test04() {

        String dosyaYolu = "C:/Users/zulfi/OneDrive/Masaüstü/deneme.docx";
        File file = new File(dosyaYolu);
        //System.out.println(new File(dosyaYolu).exists()); ustteko kodu kapatarak bu kodu kullanabiliriz.
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();

        /*
        Yukaridaki methodlarda bilgisayarimizdaki dosya yolunun varligini Files.exists() methodu ile test etmistik.
        Ayni islemi asagidaki ornekteki gibi File class'indan obje olusturarak da yapabiliriz
       */


    }


















}
