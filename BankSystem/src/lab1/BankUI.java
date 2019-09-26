package lab1;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;


/**
 * This class is the user interface(console) 
 * @author link
 *
 */
public class BankUI {
	private static Scanner in;
	public static void main(String args[]) throws IOException, ParseException
	{
		BankControl myBank=new BankControl();
		in = new Scanner(System.in);
		while(true)//总的循环，用户总能回到这个界面
		{
		//第一个界面，接收用户到底想干嘛
		
		System.out.println("Welcome to Link Bank! What business you want to do?");
		System.out.println("1 for creating a new account");
		System.out.println("2 for depositing money");
		System.out.println("3 for withdrawing money");
		System.out.println("4 for clearing your un-cleared value");
		System.out.println("5 for closing account");
		System.out.println("6 for suspend account");
		System.out.println("7 for exiting");
	
		int a=0;
		try{
			 a=Integer.parseInt(in.nextLine()) ;
			}
			catch(NumberFormatException e){
				System.err.println("Please type in a number");
				BankControl.pause();
			}
			switch (a)
			{
				
			    case 1: //开银行账号
					myBank.createAccount();
			    	break;
					
			    case 2://deposit
			    	myBank.deposit();
			    	break;
			    case 3://withdraw
			    	myBank.withdraw();
			    	break;
			    case 4://clear
			    	myBank.clearValue();
			    	break;
			    case 5://close
			    	myBank.closingAccount();
			    	break;
			    case 6://suspend	
			    	myBank.suspendAccount();
			    	break;
			    case 7://exit
					System.out.println("Thanks for using Link Bank!");
					System.exit(0);
					break;
				default:
					System.err.println("Error type! Please type in again!");
			    	
		
			}
		}//主界面循环
	}//main函数循环
	
	}//class结尾

