package lab1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * This class is credit agency, which have lists of credit account, if there are some bad credit incident, he or she will be added
 * into the existing credit list
 * @author link
 *
 */
public class CreditAgency {
	
	private ArrayList<CreditAccount> creditDB=new ArrayList<CreditAccount>();
	
	public CreditAgency(){
		Date birthDate=null;
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			birthDate= bartDateFormat.parse("1997-01-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		creditDB.add(new CreditAccount("sb",birthDate,"eclipse"));
		creditDB.add(new CreditAccount("sb2",birthDate,"haha"));
	}
	
	public boolean check(String name,Date birth, String address){
		for(CreditAccount tmp: creditDB){
			if (name.equals(tmp.getName())&&birth.equals(tmp.getBirth())&&address.equals(tmp.getAddress()))
			{
				return false;
			}
		}
		return true;
		
	}

}
