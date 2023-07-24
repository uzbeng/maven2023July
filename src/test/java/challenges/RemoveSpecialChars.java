package challenges;

import org.testng.Assert;

public class RemoveSpecialChars {

	public static void main(String[] args) {

		String bankBalanceStr = "$1000.23";
		String depositStr = "$345.22";
		String totalBalanceAfterDepositStr = "$1345.45";
		
		double bankBalance = removeDollarSign(bankBalanceStr);
		double deposit = removeDollarSign(depositStr);
		double totalBalance = removeDollarSign(totalBalanceAfterDepositStr);
		
		Assert.assertEquals(bankBalance + deposit, totalBalance);
		
		String age = "45";		
		int ageInt =  Integer.parseInt(age);
		System.out.println(ageInt + 15);
		
		System.out.println(Character.isLetter('#'));


	}
	
	public static double removeDollarSign(String s) {
		s = s.replace("$", "");
		return Double.parseDouble(s);
	}

}
