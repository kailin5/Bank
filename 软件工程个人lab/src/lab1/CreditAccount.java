package lab1;

import java.util.Date;

/**
 * A entity class define credit account
 * @author link
 *
 */
public class CreditAccount {
	private String name;
	private Date birth;
	private String address;
	public CreditAccount(String name, Date birth, String address){
		this.name=name;
		this.birth=birth;
		this.address=address;
	}
	
	public String getName(){
		return this.name;
	}
	public Date getBirth(){
		return this.birth;
	}
	public String getAddress(){
		return this.address;
	}
	
}
