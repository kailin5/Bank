package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.util.Date;


/**
 * This class is to define an entity class, which is SavingAccount that can not withdraw less than 7 days
 * @author Link
 *
 */
public class SavingAccount extends BankAccount{
	public final Date startDate;
	public Date currentDate;

	public SavingAccount(int accNo, String accName,String address, Date birthDate) {
		super(accNo, accName,address,birthDate);
		startDate=new Date();
	}
	public SavingAccount(String[] data) throws ParseException{
		super(data);
		startDate=new Date();
	}
	
	public void withdraw(double amount) {
		currentDate=new Date();
		if (BankControl.differentDays(startDate,currentDate)<7){
			System.out.println("You can't withdraw money within 7 days");
		}
		else
		{
			if(susp==false){
			double mid=balance -amount;
			if(mid>=0)
				balance = balance - amount;
			else
				System.out.println("You don't have enough money!");
		}
			else
				System.out.println("Your account has been suspended!");
		}
		}
	
	
		

}
