import org.junit.*;

public class MainTest {
//    @BeforeClass
//    public static void beforeClassMethod(){
//
//    }
//
//    @Before
//    public void setUp(){
//
//    }

    @Test
    public void test1(){
        Assert.assertTrue("Значение не равны",1 + 1 == 2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(10, 5 + 5);
    }

    @Test
    public void test3(){
        Assert.assertFalse("Значение не равны", 1 + 1 == 2);
    }

    @Test
    public void test4(){
        Assert.assertNotEquals(10, 5 + 5);
    }

//    @After
//    public void tearDown(){
//
//    }
//
//    @AfterClass
//    public static void afterClassMethod(){
//
//    }
}
