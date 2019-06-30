package labWrapperClassGui;

public class DemoWrapperClass {
	
	public String minMax() {
		
		String returnVal = "Method minMax:\n\n"
						 + "Byte:\n"
						 + "Min: " + Byte.MIN_VALUE + "\n"
						 + "Max: " + Byte.MAX_VALUE + "\n\n"
						 + "Short:\n"
						 + "Min: " + Short.MIN_VALUE + "\n"
						 + "Max: " + Short.MAX_VALUE + "\n\n"
						 + "Integer:\n"
						 + "Min: " + Integer.MIN_VALUE + "\n"
						 + "Max: " + Integer.MAX_VALUE + "\n\n"
						 + "Long:\n"
						 + "Min: " + Long.MIN_VALUE + "\n"
						 + "Max: " + Long.MAX_VALUE + "\n\n";
		
		return returnVal;
	}
	
	public String toBinary(int number) {
		
		String returnVal = "Method toBinary:\n\n"
						 + "Binary: " + Integer.toBinaryString(number) + "\n"
						 + "Octal: " + Integer.toOctalString(number) + "\n"
						 + "Hex: " + Integer.toHexString(number) + "\n\n";
		
		return returnVal;
	}
	
	public String charProperties(char c) {
		
		String isLetter, isWhiteSpace, isDigit, returnVal;
		if (Character.isWhitespace(c)) {
			isWhiteSpace = "true";
			isDigit = "false";
			isLetter = "false";
		} else if(Character.isDigit(c)) {
			isWhiteSpace = "false";
			isDigit = "true";
			isLetter = "false";
		} else if (Character.isLetter(c)) {
			isWhiteSpace = "false";
			isDigit = "false";
			if (Character.isUpperCase(c)) {
				isLetter = c + "|" + Character.toLowerCase(c);
			} else {
				isLetter = c + "|" + Character.toUpperCase(c);
			}
		} else {
			isWhiteSpace = "false";
			isDigit = "false";
			isLetter = "false";
		}
		
		returnVal = "Method charProperties:\n\n"
				  + "White space: " + isWhiteSpace + "\n"
				  + "Digit: " + isDigit + "\n"
				  + "Letter: " + isLetter + "\n";
		
		return returnVal;
	}

}
