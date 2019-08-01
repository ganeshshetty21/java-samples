package interview.others;

public class FinallyBlockReturnTest {

	public static void main(String[] args) {
		TrySuccess trySuccess = new TrySuccess();
		System.out.println("trySuccess.testFinally() = "+trySuccess.testFinally());
		
		CatchSuccess catchSuccess = new CatchSuccess();
		System.out.println("catchSuccess.testFinally() = "+catchSuccess.testFinally());
		
		FinallySuccess finallySuccess = new FinallySuccess();
		System.out.println("finallySuccess.testFinally() = "+finallySuccess.testFinally());

	}

}
 

class TrySuccess {
	public int testFinally() {
		try {
			System.out.println(" TrySuccess try ");
			return 1;
		} catch (Exception e) {
			System.out.println(" TrySuccess Exception ");
			return 2;
		} finally {
			System.out.println(" TrySuccess finally ");
			return 3;
		}
	}
}

class CatchSuccess {
	public int testFinally() {
		try {
			System.out.println(" CatchSuccess try ");
			String s = null;
			s.length();
			return 1;
		} catch (Exception e) {
			System.out.println(" CatchSuccess Exception ");
			return 2;
		} finally {
			System.out.println(" CatchSuccess finally ");
			return 3;
		}
	}
}

class FinallySuccess {
	public int testFinally() {
		try {
		} catch (Exception e) {
		} finally {
			System.out.println(" FinallySuccess finally ");
			return 3;
		}
	}
}