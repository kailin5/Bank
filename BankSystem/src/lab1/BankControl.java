package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


/**
 * This class is the control class of the bank
 * @author Linkai
 *
 */
public class BankControl {
	private static final String Bankaccount = null;
	
		public CreditAgency myAgency;
	//三个临时的变量，用来存储中间的输入信息，名字，地址，生日
		private static int accountNo;
		private static String accountName;
		private static String address;
		private static Date birthDate;
		private static String tempBirth;
	
		
		static ArrayList<BankAccount> exist=new ArrayList<BankAccount>();
		static ArrayList<CurrentAccount> CAexist=new ArrayList<CurrentAccount>();
		static ArrayList<SavingAccount> SAexist=new ArrayList<SavingAccount>();
		static ArrayList<JuniorAccount> JAexist=new ArrayList<JuniorAccount>();
	
	/**
	 * Bank Control constructor, create an admin account to run test, account number,1 pin,1
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public BankControl() throws IOException, ParseException{
		        /**
		         * 将三个文件中的bankaccount全部读入，并全部加入exist中
		         * 文件操作
		         */
		
				myAgency=new CreditAgency();
		        String filepath = "Database/juniorAccount.txt";
		        File file = new File(filepath);
		        BufferedReader reader = new BufferedReader(new FileReader(file));
		        String temp = reader.readLine();
		        while (temp != null) {
		            // 解析字符串
		            String[] data = temp.split(",");
		            if(data.length == 8){
		            	JAexist.add(new JuniorAccount(data));
		                exist.add(new BankAccount(data));
		            }
		            temp = reader.readLine();
		        }
		        reader.close();
		        
		        String filepath2 = "Database/currentAccount.txt";
		        File file2 = new File(filepath2);
		        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
		        String temp2 = reader2.readLine();
		        while (temp2 != null) {
		            // 解析字符串
		            String[] data = temp2.split(",");
		            if(data.length == 8){
		            	CAexist.add(new CurrentAccount(data));
		                exist.add(new CurrentAccount(data));
		            }
		            temp2 = reader2.readLine();
		        }
		        reader2.close();
		        
		        
		        String filepath3 = "Database/savingAccount.txt";
		        File file3 = new File(filepath3);
		        BufferedReader reader3 = new BufferedReader(new FileReader(file3));
		        String temp3 = reader3.readLine();
		        while (temp3 != null) {
		            // 解析字符串
		            String[] data = temp3.split(",");
		            if(data.length == 8){
		            	SAexist.add(new SavingAccount(data));
		                exist.add(new SavingAccount(data));
		            }
		            temp3 = reader3.readLine();
		        }
		        reader3.close();
		}
		
			
	/**
	 * This method is to create a new bank account		
	 */
	/**This method is to create a new account		
	 * @throws IOException */
	public void createAccount() throws IOException{
		Scanner in =new Scanner(System.in);
		int pinMid=1;
		outer:
		while(true)
    	{
    	System.out.println("What type of account you want to create?");
		System.out.println("1 for creating a new Junior bank account");
		System.out.println("2 for creating a new Current account");
		System.out.println("3 for creating a new Saving account");
		System.out.println("4 for backing to main menu");
		int b=5;
		try{
		 b=Integer.parseInt(in.nextLine()) ;
		}
		catch(NumberFormatException e){
			System.err.println("Please type in a number");
		}
						switch (b)// 三种账号的分类，第一种junior， 第二种current， 第三种current
						{
						case 1:
							System.out.println("Please type in your birthDate!(In form yyyy-mm-dd. Eg: 1997-05-06)");
							SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
							try {
								birthDate= bartDateFormat.parse(in.nextLine());
							} catch (ParseException e) {
								System.err.println("Please type the Date as format!");
								pause();
								break;
							}
							
							Date currentDate=new Date();
							
							//判断年龄是否满足junior的条件
								if(differentDays(birthDate,currentDate)>5840)
									{System.out.println("Junior account are only for age under 16, please change to another account!");
									System.out.println("");
									
									pause();
									
									
									break;
									}
								System.out.println("Please type in your name!");
							accountName= in.nextLine();
							
							System.out.println("Please type in your address!");
							address= in.nextLine();
							
							
							int judgeExist=1;
							
							while(judgeExist==1)
							{
								judgeExist=0;
								int accno=(int) (10000000+Math.random()*10000000);
							
							for(BankAccount tmp: exist)
							{
								if(accno==tmp.getAccountNo())
								{
									judgeExist=1;
								}
									
							}
								
							accountNo=accno;
							}
							
							boolean checkResult=myAgency.check(accountName, birthDate, address);
							if(checkResult==false){
								System.out.println("You don't have credit to open up a new account!");
								break outer;
							}
							exist.add(new JuniorAccount(accountNo,accountName,address,birthDate));
							JAexist.add(new JuniorAccount(accountNo,accountName,address,birthDate));
							System.out.println("Please type in your PIN!(Must be 8 number Eg:12345678)");
							try{
								pinMid=Integer.parseInt(in.nextLine());
							}
							catch(NumberFormatException e){
								System.err.println("Please type the number as format!");
								pause();
								break;
							}
							exist.get(exist.size()-1).setPin(pinMid);
							JAexist.get(JAexist.size()-1).setPin(pinMid);
							System.out.println("Your account has been created!");
							System.out.println(exist.get(exist.size()-1));
							pause();
							break outer;
						case 2://
					    	System.out.println("Please type in your birthDate!(In form yyyy-mm-dd. Eg: 1997-05-06)");
					    	SimpleDateFormat bartDateFormat2 = new SimpleDateFormat("yyyy-MM-dd"); 
							try {
								birthDate= bartDateFormat2.parse(in.nextLine());
							} catch (ParseException e) {
								System.err.println("Please type the Date as format!");
								pause();
								break;
							}
					    	System.out.println("Please type in your name!");
							accountName= in.nextLine();
							
							System.out.println("Please type in your address!");
							address= in.nextLine();
							
							
							int judgeExist2=1;
							
							while(judgeExist2==1)
							{
								judgeExist2=0;
								int accno=(int) (10000000+Math.random()*10000000);
							
							for(BankAccount tmp: exist)
							{
								if(accno==tmp.getAccountNo())
								{
									judgeExist2=1;
								}
									
							}
									//System.out.println("Please type in your account number!");	
							accountNo=accno;
							}
							
							boolean checkResult2=myAgency.check(accountName, birthDate, address);
							if(checkResult2==false){
								System.out.println("You don't have credit to open up a new account!");
								break outer;
							}
							exist.add(new CurrentAccount(accountNo,accountName,address,birthDate));
							CAexist.add(new CurrentAccount(accountNo,accountName,address,birthDate));
							System.out.println("Please type in your PIN!(Must be 8 number Eg:12345678)");
							try{
								pinMid=Integer.parseInt(in.nextLine());
							}
							catch(NumberFormatException e){
								System.err.println("Please type the number as format!");
								pause();
								break;
							}
							
							exist.get(exist.size()-1).setPin(pinMid);
							CAexist.get(CAexist.size()-1).setPin(pinMid);
							
							System.out.println("Your Current account has been created!");
							System.out.println(exist.get(exist.size()-1));
							pause();
							break outer;
					    	
					    case 3:
					    	System.out.println("Please type in your birthDate!(In form yyyy-mm-dd. Eg: 1997-05-06)");
					    	SimpleDateFormat bartDateFormat3 = new SimpleDateFormat("yyyy-MM-dd"); 
							try {
								birthDate= bartDateFormat3.parse(in.nextLine());
							} catch (ParseException e) {
								System.err.println("Please type the Date as format!");
								pause();
								break;
							}
							System.out.println("Please type in your name!");
							accountName= in.nextLine();
							
							System.out.println("Please type in your address!");
							address= in.nextLine();
							
							
							int judgeExist3=1;
							
							while(judgeExist3==1)
							{
								judgeExist3=0;
								int accno=(int) (10000000+Math.random()*10000000);
							
							for(BankAccount tmp: exist)
							{
								if(accno==tmp.getAccountNo())
								{
									judgeExist3=1;
								}
									
							}
									//System.out.println("Please type in your account number!");	
							accountNo=accno;
							}
							
							boolean checkResult3=myAgency.check(accountName, birthDate, address);
							if(checkResult3==false){
								System.out.println("You don't have credit to open up a new account!");
								break outer;
							}
							
							exist.add(new SavingAccount(accountNo,accountName,address,birthDate));
							SAexist.add(new SavingAccount(accountNo,accountName,address,birthDate));
							System.out.println("Please type in your PIN!(Must be 8 number Eg:12345678)");
							try{
								pinMid=Integer.parseInt(in.nextLine());
							}
							catch(NumberFormatException e){
								System.err.println("Please type the number as format!");
								pause();
								break;
							}
							exist.get(exist.size()-1).setPin(pinMid);
							SAexist.get(SAexist.size()-1).setPin(pinMid);
							System.out.println("Your Saving account has been created!");
							System.out.println(exist.get(exist.size()-1));
							
							
							pause();
							break outer;
		
					    case 4:
					    	break outer;
							
							default:
								System.out.println("Error type!, please check your input!");
								pause();
						}
    	}
		
							
						save();
			    	}
			    
	/**This method is to deposit */
	
	/**
	 * This method is to deposit.
	 * @throws IOException 
	 */
	public void deposit() throws IOException{
					Scanner in =new Scanner(System.in);
			    	int accno=0;
			    	int accPin=0;
					boolean jud=false;
					outer:
					while(true){
			    	while(!jud)
					{
			    	System.out.println("Pease type in your account number!(-1 to back to the main menu)");
			    	try{
						 accno=Integer.parseInt(in.nextLine()) ;
						}
						catch(NumberFormatException e){
							System.err.println("Please type in a number");
						}
					if (accno==-1)
						break outer;
					System.out.println("Please type in your PIN");
					try{
					accPin=Integer.parseInt(in.nextLine());
					}
					catch(NumberFormatException e){
						System.err.println("Please type in a number");
					}
					jud=judgePin(accno,accPin);
					}
			    	BankAccount curBA=getAccount(accno);
			    	System.out.println(curBA);
			    	pause();
			    	System.out.println("What type of funds you want to deposite? 1 for cash, 2 for cheque");
			    	
			    	
			    	int a=0;
			    	try{
			    		
				    	a=Integer.parseInt(in.nextLine());
				    	}
				    	catch(Exception e){
				    		System.err.println("Please type in the number!");
				    	}
			    	
			    	switch(a){
			    		case 1:
			    	System.out.println("Please type in the amount you want to deposit!");
			    	try{
			    	curBA.deposit(Double.parseDouble(in.nextLine()));
			    	}
			    	catch(Exception e){
			    		System.err.println("Please type in the number!");
			    	}
			    	System.out.println(" Your current balance is "+curBA.getBalance());
			    	pause();
			    	break outer;
					
			    		case 2:
			    			System.out.println("Please type in the amount you want to deposit!");
					    	try{
					    	curBA.addUnclearBalance(Double.parseDouble(in.nextLine()));
					    	}
					    	catch(Exception e){
					    		System.err.println("Please type in the number!");
					    	}
					    	System.out.println(" Your current balance is "+curBA.getBalance());
					    	pause();
					    	break outer;
							
			    			
			    	
					}
					}
				save();
	}

	/**This method is to withdraw money */
	
	
	//尚未解决问题，saving account 无法提钱
	/**
	 * This method is to withdraw money.
	 * @throws IOException 
	 */
	public void withdraw() throws IOException{
		Scanner in =new Scanner(System.in);
					int accno=0;
					boolean jud=false;
					outer:
					while(true){
			    	while(!jud)
					{
			    	System.out.println("Pease type in your account number!(-1 to back to the main menu)");
			    	try{
					accno=Integer.parseInt(in.nextLine());
			    	}
			    	catch(Exception e){
			    		System.err.println("Please type in the number!");
			    	}
					if (accno==-1)
						break outer;
					System.out.println("Please type in your PIN");
					int accPin=0;
					try{
					accPin=Integer.parseInt(in.nextLine());
					}
					catch(Exception e){
						System.err.println("Please type in number!");
					}
					jud=judgePin(accno,accPin);
					}
			    	BankAccount curBA=getAccount(accno);
			    	System.out.println(curBA);
			    	pause();
			    	System.out.println("Please type in the amount you want to withdraw!");
			    	try{
			    	curBA.withdraw(Double.parseDouble(in.nextLine()));
			    	}
			    	catch(Exception e){
						System.err.println("Please type in number!");
					}
			    	System.out.println("Your current balance is "+curBA.getBalance());
			    	pause();
			    	break outer;
					}
					
					save();
	}
	
	/**This method is to clear un-cleared value   */
	
	/**
	 * This method is to clear un-cleared value
	 * @throws IOException 
	 */
	public void clearValue() throws IOException{
		Scanner in =new Scanner(System.in);	
					int accno=0;
					int accPin=0;
					boolean jud=false;
					outer:
						while(true){
			    	while(!jud)
					{
			    	System.out.println("Pease type in your account number!(-1 to back to the main menu)");
					try{
			    	accno=Integer.parseInt(in.nextLine());
					}
					catch(Exception e){
						System.err.println("Please type in number!");
					}
					
			    	if (accno==-1)
						break outer;
					System.out.println("Please type in your PIN");
					try{
					accPin=Integer.parseInt(in.nextLine());
					}
					catch(Exception e){
						System.err.println("Please type in number!");
					}
					jud=judgePin(accno,accPin);
					}
			    	BankAccount curBA=getAccount(accno);
			    	curBA.clearFund();
			    	System.out.println("Your un-cleared value has been cleared");
			    	pause();
			    	System.out.println(curBA);
			    	pause();	
			    		break outer;
						}
					save();
	}
	
	/**This method is to close an account    */
	
	/** 
	 * This method is to close an account 
	 * @throws IOException 
	 */
	public void closingAccount() throws IOException{
		Scanner in =new Scanner(System.in);
					int accno=0;
					int accPin=0;
					boolean jud=false;
					outer:
						while(true){
			    	while(!jud)
					{
			    	System.out.println("Pease type in your account number!(-1 to back to the main menu)");
			    	try{
					accno=Integer.parseInt(in.nextLine());
			    	}
			    	catch(Exception e){
			    		System.err.println("Please type in the number as indicate!");
			    	}
					if (accno==-1)
						break outer;
					System.out.println("Please type in your PIN");
					try{
					accPin=Integer.parseInt(in.nextLine());
					}
					catch(Exception e){
						System.err.println("Please type in number!");
					}
					
					jud=judgePin(accno,accPin);
					}
			    	BankAccount curBA=getAccount(accno);
			    	System.out.println(curBA);
			    	System.out.println("Are you sure you want to close your account?(Type Y to continue)");
			    	String verify=in.nextLine();
			    	if(verify.compareTo("Y")==0){
			    		System.out.println("Your account has been closed.");
			    		CAexist.remove(curBA);
			    		JAexist.remove(curBA);
			    		SAexist.remove(curBA);
			    		}
			    	else
			    	System.out.println("Your account is not been closed!");
			    	pause();
			    	break outer;
						}
					save();
			    	
	}
	
	/**This method is to suspend an account	*/
	
	/**
	 * This method is to suspend an account
	 * @throws IOException 
	 */
	public void suspendAccount() throws IOException{
		Scanner in =new Scanner(System.in);
					int accno=0;
					int accPin=0;
					boolean jud=false;
					outer:
						while(true){
			    	while(!jud)
					{
			    	System.out.println("Pease type in your account number!(-1 to back to the main menu)");
					try{
			    	accno=Integer.parseInt(in.nextLine());
					}
					catch(Exception e){
						System.err.println("Please type in number!");
					}
			    	if (accno==-1)
						break outer;
					System.out.println("Please type in your PIN");
					try{
					accPin=Integer.parseInt(in.nextLine());
					}
					catch(Exception e){
						System.err.println("Please type in number!");
					}
					jud=judgePin(accno,accPin);
					}
			    	BankAccount curBA=getAccount(accno);
			    	System.out.println(curBA);
			    	System.out.println("Are you sure you want to suspend your account?(Type Y to continue)");
			    	String verify=in.nextLine();
			    	if(verify.compareTo("Y")==0){
			    		System.out.println("Your account has been suspended.");
			    		curBA.setSusp(true);
			    		
			    	}
			    	else
			    	System.out.println("Your account is not been suspended!");
			    	pause();
			    	break outer;
						}
					save();
			    		}
						
	
	/**
	* This method is generally used by judging the right or wrong whether the account number
		 * is corresponding to the pin 
		*/
	public static boolean judgePin(int accNo, int pin){
			
			for(BankAccount tmp: exist)
			{
				if(accNo==tmp.getAccountNo()&&pin==tmp.getPin())
				{
					
					return true;
				}
					
			}
			System.out.println("Your account information is not correct");
			return false;
			
		}
		

	/** 
	 * This method is to get the specific bank account.
		 * @param accNo	Get bank account by account number
		 * @return
		 */
	public static BankAccount getAccount(int accNo){
		BankAccount falseAccount=new BankAccount(00000000,"false","false",new Date());	
		/*
		for(BankAccount tmp: exist){
				if (accNo==tmp.getAccountNo())
				{
					return tmp;
				}
			}
		*/
			
			
				for(JuniorAccount tmp: JAexist){
					if (accNo==tmp.getAccountNo())
					{
						return tmp;
					}
				}
				for(CurrentAccount tmp: CAexist){
					if (accNo==tmp.getAccountNo())
					{
						return tmp;
					}
				}
				for(SavingAccount tmp: SAexist){
					if (accNo==tmp.getAccountNo())
					{
						return tmp;
					}
				}
				
					return falseAccount;
		}
		
	/**This method is to clear the console window	*/
	
	/**
	 * This method is to clear the console window
	 */
	public static void clearWindow(){
			for(int i=0;i<2;i++){
		        System.out.println("");//输出400行空行
		     }
		}

	
	/**	
	 * This method is to calculate the different days to judge the 
		 * @param date1		first date
		 * @param date2		second date
		 * @return
		 */
	public static int differentDays(Date date1,Date date2)
	    {
	        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
	        return days;
	    }
		

	/** 
	* this method is to pause 1.5 s to let user see what happened*/
	public static void pause(){
			//给用户阅读时间
			try{
				System.out.println("");
			    Thread thread = Thread.currentThread();
			    thread.sleep(1500);//暂停1.5秒后程序继续执行
			}catch (InterruptedException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}
		}


	/**
	 * This method is to save the change into the file
	 */
	public void save() throws IOException{
		String tmp="";
		String filepath = "Database/account.txt";
        File userDateFile = new File(filepath);
        FileWriter fileWriter = new FileWriter(userDateFile,false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        try {
            for (BankAccount a : exist){
        		tempBirth= bartDateFormat.format(a.getBirth());
            	tmp=a.getAccountNo() +","+a.getAccountName()+","+a.getAddress()+","+tempBirth+","+a.getBalance()+","+a.getUnclearBalance()+","+a.getPin()+","+a.getSusp();
            	bufferedWriter.write(tmp);
                bufferedWriter.newLine();
                
            }
            bufferedWriter.close();
            fileWriter.close();
            
        } catch (Exception e) {
            System.out.println("Write error");  
            e.printStackTrace();
        }
        
        
        String filepath2="Database/juniorAccount.txt";
        File userDateFile2 = new File(filepath2);
        FileWriter fileWriter2 = new FileWriter(userDateFile2,false);
        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
        
        
        try {
            for (JuniorAccount a : JAexist){
        		tempBirth= bartDateFormat.format(a.getBirth());
            	tmp=a.getAccountNo() +","+a.getAccountName()+","+a.getAddress()+","+tempBirth+","+a.getBalance()+","+a.getUnclearBalance()+","+a.getPin()+","+a.getSusp();
            	bufferedWriter2.write(tmp);
                bufferedWriter2.newLine();
            }
            bufferedWriter2.close();
            fileWriter2.close();
            
        } catch (Exception e) {
            System.out.println("Write error");  
            e.printStackTrace();
        }
        
        String filepath3="Database/currentAccount.txt";
        File userDateFile3 = new File(filepath3);
        FileWriter fileWriter3 = new FileWriter(userDateFile3,false);
        BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);
        
        
        try {
            for (CurrentAccount a : CAexist){
        		tempBirth= bartDateFormat.format(a.getBirth());
            	tmp=a.getAccountNo() +","+a.getAccountName()+","+a.getAddress()+","+tempBirth+","+a.getBalance()+","+a.getUnclearBalance()+","+a.getPin()+","+a.getSusp();
            	bufferedWriter3.write(tmp);
                bufferedWriter3.newLine();
            }
            bufferedWriter3.close();
            fileWriter3.close();
            
        } catch (Exception e) {
            System.out.println("Write error");  
            e.printStackTrace();
        }
        
        String filepath4="Database/savingAccount.txt";
        File userDateFile4 = new File(filepath4);
        FileWriter fileWriter4 = new FileWriter(userDateFile4,false);
        BufferedWriter bufferedWriter4 = new BufferedWriter(fileWriter4);
        
        
        try {
            for (SavingAccount a : SAexist){
        		tempBirth= bartDateFormat.format(a.getBirth());
            	tmp=a.getAccountNo() +","+a.getAccountName()+","+a.getAddress()+","+tempBirth+","+a.getBalance()+","+a.getUnclearBalance()+","+a.getPin()+","+a.getSusp();
            	bufferedWriter4.write(tmp);
                bufferedWriter4.newLine();
            }
            bufferedWriter4.close();
            fileWriter4.close();
            
        } catch (Exception e) {
            System.out.println("Write error");  
            e.printStackTrace();
        }
        
    }
}
