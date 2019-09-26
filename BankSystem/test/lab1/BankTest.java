package lab1;

import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * This class is to test something in BankControl.java
 */
@SuppressWarnings("deprecation")
public class BankTest extends TestCase{

	protected void setUp() throws Exception{
		super.setUp();
	}
	
	public void testdifferentDays()
	{
		Date date1=new Date(118,1,1);
		Date date2=new Date(118,1,15);
		int dif=BankControl.differentDays(date1, date2);
		
		Assert.assertEquals(14, dif);
		
		/*  一个assert.fail()的例子
		 * 
		 * public void testDivide()
    {
        int result = 0;
        try
        {
            result = calculator.divide(12, 3);   //变为（12，0）
        }
        catch (Exception e)
        {
            e.printStackTrace();

            // 如果抛出异常，证明测试失败,没有通过，没通过的测试计数在Failures中
            Assert.fail();
            // 如果不加这一行，如果程序进入到catch，无法判断其失败
        }
        // 判断方法的返回结果
        Assert.assertEquals(4, result);// 第一个参数是期望值，第二个参数是要验证的值

    }*/
	}
	
	public void teststh(){
		System.out.println("Only a test");
	}
	
	protected void tearDown() throws Exception{
		super.tearDown();
	}
}
