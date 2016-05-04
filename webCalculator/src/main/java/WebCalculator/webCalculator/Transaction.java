package WebCalculator.webCalculator;

public class Transaction {
	private int firstNumber;
	private int  secondNumber;
	private String operation;
	private int result;
	
	
	public Transaction(int a, int b, String o, int r){
		firstNumber = a;
		secondNumber = b;
		operation = o;
		result = r;
		
	}
	
	public String toString(){
		
		return firstNumber + operation + secondNumber + " = " + result;
	}
}
