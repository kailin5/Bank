package lab1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class is generally a bankAccount, which fits basic needs.
 * @author link
 *
 */


public class BankAccount {
	/**
	 * instance variable
	 */
	protected int accNo;
	protected String accName;
	//新添加的个人信息
	protected String address;
	protected Date birthDate;
	protected double balance;
	protected double unclearBalance;
	protected int pin;
	protected boolean susp=false;
	
	/**
	 * Constructor used by the reading data
	 * @param accNo
	 * @param accName
	 * @param address
	 * @param birthDate
	 * @param balance
	 * @param pin
	 * @param susp
	 */
	public BankAccount(int accNo, String accName,String address, Date birthDate, Double balance, Double unclearBalance,int pin, boolean susp){
		this.accNo = accNo;
		this.accName = accName;
		this.address=address;
		this.birthDate=birthDate;
		this.balance = balance;
		this.unclearBalance=unclearBalance;
		this.pin=pin;
		this.susp=susp;
	}		
	public BankAccount(int accNo, String accName,String address, Date birthDate){
		this.accNo = accNo;
		this.accName = accName;
		this.address=address;
		this.birthDate=birthDate;
		this.balance = 0.0;
		}
	public BankAccount(String accName, int accNo){
		this.accNo = accNo;
		this.accName = accName;
		this.balance = 0.0;
		}
	public BankAccount(String[] data) throws ParseException {
		this.accNo = Integer.parseInt(data[0]);
		this.accName = data[1];
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		birthDate= bartDateFormat.parse(data[3]);
		this.address=data[2];
		this.birthDate=birthDate;
		this.balance = Double.parseDouble(data[4]);
		this.unclearBalance=Double.parseDouble(data[5]);
		this.pin=Integer.parseInt(data[6]);
		this.susp=Boolean.parseBoolean(data[7]);
	}

	
	/**
	 * set method
	 */
	public void setAccountName(String accName) {
		this.accName = accName;}
	public void setSusp(boolean susp){
		this.susp=susp;
	}
	public void setPin(int pin){
		this.pin=pin;
	}

	/**
	 * get method
	 * @return
	 */
	public int getPin(){
		return this.pin;
	}
	public Date getBirth(){
		return this.birthDate;
	}
	public Double getUnclearBalance(){
		return this.unclearBalance;
	}
	public String getAddress(){
		return this.address;
	}
	public boolean getSusp(){
		return susp;
	}
	public int getAccountNo() { return accNo; }
	public String getAccountName() { return accName; }
	public double getBalance() { return balance; }
	/**
	 * deposit cheque method
	 * @param newUnclear: newly deposit cheque
	 */
	public void addUnclearBalance(Double newUnclear){
		this.unclearBalance=this.unclearBalance+newUnclear;
	}
	
	/**
	 * deposit cash method
	 * @param amount
	 */
	public void deposit(double amount) {
		if(susp==false){
			if(amount>=0)
			balance = balance + amount;
			else
				System.out.println("Please type in the positive number!");
		}
		else
			System.out.println("Your account has been suspended!");
	}
		public void withdraw(double amount) {
			if(susp==false){
				if(amount>=0){
			double mid=balance -amount;
			if(mid>=0)
				balance = balance - amount;
			else
				System.out.println("You don't have enough money!");
				}
				else
					System.out.println("Please type in the positive number!");
			
		}
			else
				System.out.println("Your account has been suspended!");
		}
	
	/**
	* toString override
		 */
	public String toString() {
			return "Account number: " + accNo + "\n"
			+ "Your name: " + accName + "\n"
			+ "Your address: " + address + "\n"
			+ "Your birthDate: " + birthDate + "\n"
			+ "Balance: " + balance ;
			}
	
	/**
	 * clear un-cleared fund
	 */
	public void clearFund(){
		this.balance=this.balance+this.unclearBalance;
		this.unclearBalance=0;
	}
	
}
