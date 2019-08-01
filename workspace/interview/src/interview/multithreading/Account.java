package interview.multithreading;

public class Account {

	private int acctNumber;

	public Account(int acctNumber) { 
		this.acctNumber = acctNumber;
	}

	public int getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(int acctNumber) {
		this.acctNumber = acctNumber;
	}

	@Override
	public String toString() {
		return "Account [acctNumber=" + acctNumber + "]";
	}

}
