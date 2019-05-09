package lab1;

import java.text.ParseException;
import java.util.Date;

/**
 * This class is to define an entity class, which is JuniorAccount that can withdraw more than the balance
 * @author Link
 *
 */
public class JuniorAccount extends BankAccount{

	public JuniorAccount(int accNo, String accName, String address, Date birthDate) {
		super(accNo, accName, address, birthDate);
		// TODO Auto-generated constructor stub
	}
	public JuniorAccount(String[] data) throws ParseException{
		super(data);
	}

}
