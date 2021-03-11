package csc131.junit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
//import org.junit.rules.ExpectedException;
import org.junit.jupiter.api.Test;

class GiftCardTest {

	@Test
	public void getIssuingStore()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		
		card = new GiftCard(issuingStore, balance);
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
	}
	@Test
	public void getBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		double tolerance = 0.001;
		
		issuingStore = 1337;
		balance = 100.00;
		
		card = new GiftCard(issuingStore, balance);
		assertEquals("getBalance()", balance, card.getBalance(), tolerance);
	}
	@Test
	public void deduct_RemainingBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		double deduction = 5.05;
		
		
		issuingStore = 1337;
		balance = 100.00;
		
		card = new GiftCard(issuingStore, balance);
		String leftOver = card.deduct(deduction);
		balance -= deduction;
		String expected = "Remaining Balance: " + String.format("%6.2f",
                Math.abs(balance));;
		assertEquals("deductRemainingBalance()", expected,leftOver);
		
		//when deducting negative num from balance
		deduction = -1.5;
		expected = "Invalid Transaction";
		leftOver = card.deduct(deduction);
		assertEquals("deductRemainingBalance()", expected,leftOver);
		
		//when deducting greater than balance
		deduction = 100.50;
		balance -= deduction;
		expected = "Amount Due: " + String.format("%6.2f",
                Math.abs(balance));
		leftOver = card.deduct(deduction);
		assertEquals("deductRemainingBalance()", expected,leftOver);
		
		
	}
	
	@Test
	public void constructor_IncorrectID_Low() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-5,100.00);});
	
	}
	@Test
	public void constructor_IncorrectID_High() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000,100.00);});
	
	}
	

}

