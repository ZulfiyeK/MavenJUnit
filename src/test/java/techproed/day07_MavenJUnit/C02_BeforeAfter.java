package techproed.day07_MavenJUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    /*
    Junit
    Java ile en temel framework JUnit ile olusturulabilir.
    framework: bir duzen, cerceve bir yapi demektir.

    Annotations
    Selenium'da kodlarimizi yazarken "@" isareti ile baslayan notasyonlar kullaniriz.


    ONEMLI
    @BeforeClass ve @AfterClass notasyonları test sürecinde bir kere çalışırken,
    @Before ve @After notasyonları her test method’unun başında ve sonunda çalışmaktadır. Genellikle class da birer tane before ve after olur.

    bir classta bit @Test methodu icin 3 method calisir==> @Befor, @After, @Test..



        Notasyonlara sahip methodlar olusturabilmek icin sag tik generate(alt+insert) yaparak after methodu icin teardown'u seceriz.
                                                                                              befor methodu icin setup'i seceriz.

        JUnit frameworkunde testlerimizi siralama yapabilmek icin ekstra bir notasyon yoktur.
        Eger belli bir siralamada calistirmak istersek method isimlerini alfabetik ve sayisal olarak belirtmemiz gerekir
     */


    @After
    public void tearDown() throws Exception {
        System.out.println("@After Her test methodundan sonra bir kez calisir.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("@Before Her test methodundan once bir kez calisir.");
    }

    @Test
    public void name1() {
        System.out.println("name1 methodu calisti");
    }

    @Test
    public void name2() {
        System.out.println("name2 methodu calisti");
    }

    @Test
    public void name3() {
        System.out.println("name3 methodu calisti");
    }



}

