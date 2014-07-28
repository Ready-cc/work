package practiceone;

import org.testng.annotations.*;

public class Practice1OnTestng {

	@BeforeTest
    public void beforeTest(){
    	System.out.println("beforeTest");
    }
	
	@BeforeClass
    public void beforeClass(){
    	System.out.println("beforeClass");
    }
    
    @BeforeMethod
    public void beforeMethod(){
    	System.out.println("beforeMethod");
    }
    
    @Test
    public void aFastTest(){
    	System.out.println("practice1:aFastTest");
    }
    
    @Test
    public void bSlowTest(){
    	System.out.println("bSlowTest");
    }
    

    
    @AfterMethod
    public void afterMethod(){
    	System.out.println("afterMethod");
    }
    
    @AfterClass
    public void afterClass(){
    	System.out.println("afterClass");
    }
    
	@AfterTest
    public void afterTest(){
    	System.out.println("afterTests");
    }
    
}
