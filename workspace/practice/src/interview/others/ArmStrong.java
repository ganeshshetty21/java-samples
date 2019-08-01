package interview.others;

public class ArmStrong {

	public static void main(String[] args) {
		ArmStrongTest armStrongTest = new ArmStrongTest();
		System.out.println(armStrongTest.test(153));
		System.out.println(armStrongTest.test(151));
	}

}

class ArmStrongTest {
	public boolean test(int number) {
		System.out.println(" number = "+number);
		int temp = number;
		int result = 0;

		while (temp > 0) {
			int rem = temp % 10;
			System.out.println(" rem = "+rem);
			result = result + (rem * rem * rem);
			System.out.println(" result = "+result);
			temp = temp / 10;
			System.out.println(" temp = "+temp);
		}

		if (result == number) {
			return true;
		}
		return false;
	}
}