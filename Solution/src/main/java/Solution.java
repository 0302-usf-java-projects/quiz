
public class Solution {
	public static int sumArray(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		}
		return result;
	}
	
	
	public static boolean equalToPowers(int value) {
		String stringValue = Integer.toString(value);
		int length = stringValue.length();
		int sumOfPowers = 0;
		for (int i = 0; i < stringValue.length(); i++) {
			 int temp = Character.getNumericValue(stringValue.charAt(i));  
			sumOfPowers += Math.pow(temp, length);
		}
		
		
		
		return sumOfPowers == value;
	}
}
