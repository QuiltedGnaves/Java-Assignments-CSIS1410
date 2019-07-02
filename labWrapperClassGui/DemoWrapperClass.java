package labWrapperClassGui;

public class DemoWrapperClass {
	
	public String minMax() {
		
		return "Method minMax:\n\n"
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
	}
	
	public String toBinary(int number) {
		
		return "Method toBinary:\n\n"
			 + "Binary: " + Integer.toBinaryString(number) + "\n"
			 + "Octal: " + Integer.toOctalString(number) + "\n"
			 + "Hex: " + Integer.toHexString(number) + "\n\n";

	}
	
	public String charProperties(char c) {
		
		return "Method charProperties:\n\n"
		     + "White Space: " + Character.isWhitespace(c) + "\n"
		     + "Digit: " + Character.isDigit(c) + "\n"
		     + "Letter: " + (Character.isLetter(c) ?  c + "|" + ((Character.isUpperCase(c)) ? Character.toLowerCase(c) : Character.toUpperCase(c)) : "false") + "\n";
		
	}

}
