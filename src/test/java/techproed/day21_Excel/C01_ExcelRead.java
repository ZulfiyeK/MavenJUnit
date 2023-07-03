package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead extends TestBase {

    @Test
    public void readExcelTest1() throws IOException {

        //3.satir 1.stun degerini yazdiriniz ve degerin "France" oldugunu test edelim.

        //Excel dosyasindan veri okuyabilmemiz icin
        //1- Dosya yolunu almamiz gerkir.
        String dosyaYolu = "src/test/java/resources/Capitals (1).xlsx";


        //2. Dosyayi bizim sistemimize getirmeliyiz.
        FileInputStream  fis = new FileInputStream(dosyaYolu);// doyayi ikuyabilmek icin akisa almamiz gerekir.


        //3. Dosyayi workbook'a atamaliyiz. Java ortaminda bir excel dosyayi olusturmaliyiz.
        Workbook workbook = WorkbookFactory.create(fis);
       String satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();//excel de index 0 dan baslar, bu yuzden 3 satir--> 2.indeks
                                                                                                                                        //1. stun -->0.indeks
        System.out.println("Satir3 Sutun1 = " + satir3Sutun1);

        Assert.assertEquals("France",satir3Sutun1);

        //Son satir satisini bulunuz.
        int sonsatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("Son Satir Sayisi = " + (sonsatirSayisi+1));//indeks 0 dan baslayacagi icin bir eksik olacak, ben de tam rakama ulasmak icin +1 ekledim.

        //Kullanilan satir sayisini bulunuz.
        int kullanilanSatirSayisi = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();//kullanilan satir sayisini verecek bu yuzden int assign etmeliyiz.
        System.out.println("Kullanilan Satir Sayisi = " + kullanilanSatirSayisi);//indeks olarak vermez.


    }

    @Test
    public void readExcelTest2() throws IOException {

        //Capitals dosyasindaki tum verileri yazdiriniz.
        Map<String,String> capitalsMap = new HashMap<>();// capitals dosyasindaki tum verileri koyabilecegimiz en uygun java objesi map'tir.
                                                        //Cunku bizim excel dosyamiz key value yapisina benzedigi icin en uygunu map'tir.

        String dosyaYolu = "src/test/java/resources/Capitals (1).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();
        for (int i = 0; i <= sonSatirSayisi; i++) {
           String key= workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();//1.stunu yazdiriyorum indeksi 0.
           String value= workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();//2.stunu yazdiriyorum,indeksi 1.
           capitalsMap.put(key,value);//map'a put ile key-valu'lari ekledim.
            System.out.println(key+"/"+value);
        }

       // System.out.println("capitalsMap = " + capitalsMap);


    }
}
