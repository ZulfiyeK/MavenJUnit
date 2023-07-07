package techproed.day23_Log4j;

import org.junit.Test;
import utilities.TestBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class C01_Log4j extends TestBase {
    @Test
    public void log4j() {

        /*

        Log4j system.out.println gibi her test adiminda bilgilendirme yapmamiza yarayan bir api'dir.
        Log4j ile bu bilgilendirmeleri hem konsolda tarih-saat olarak hem de src>main>resources icine koydugumuz
        log4j.xml file'da belirttigimiz .log uzantili dosyada yine tarih-saat olarak kayit altina almis olacagiz.
        Log4j kullanabilmek icin oncelikle log4j-api ve log4j-care dependency'lerini mvnrepostory.com adresinden
        (ayni versiyon numaralarina sahip) alip pom.xml dosyamiza koymaliyiz.
        src>main>reusources icine koydugumuz log4j.xml dosyasindaki kodlara pdf deki adresten ulasabilirsiniz.

        */

        //log4j icinde "<Root level="ERROR">" kismindaki Eror yerine debug yazarsak  dahil hepsini verir.
                                                                    //info yazinca debug haric hepsini verir.
                                                                    //eror yazinca eror ve fatal verir.


        Logger logger = LogManager.getLogger(C01_Log4j.class);
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("EROR");
        logger.fatal("FATAL");
        logger.warn("WARNING");









    }
}
