package lab1;

import java.text.ParseException;
import java.util.Date;

/**
 * This class is to define an entity class, which is currentAccount that can withdraw more than the balance
 * @author Link
 *
 */
public class CurrentAccount extends BankAccount{

	public CurrentAccount(int accNo, String accName,String address, Date birthDate) {
		super(accNo, accName,address,birthDate);
		// TODO Auto-generated constructor stub
	}
	public CurrentAccount(String[] data) throws ParseException{
		super(data);
	}
	public void withdraw(double amount) {
		double mid=balance -amount;
		if(mid>=-500)
			balance = balance - amount;
		else
			System.out.println("You don't have enough money!");
	}
	
	

}
