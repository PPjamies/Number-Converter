import java.awt.Color;

public class Conversion_Sheet{
////////////////////////////////////////////////FILLER METHODS///////////////////////////////////////////////////////////////////////

	public static String fill_32(String s) {
		while(s.length() < 32) {	
			s += "0";
		}
		return s;
	}	
	public static String fill_8(String s) {
		while(s.length() % 8 != 0) {
			s += "0";
		}
		return s;
	}
	public static String reverseString(String s) {
		StringBuilder sb = new StringBuilder(s);
		String result = sb.reverse().toString();
		return result;
	}
/////////////////////////////////////////////////CORE CONVERSIONS///////////////////////////////////////////////////////////////////	

	public static String binary_ToDecimal(String binary) {
		int decimal = 0;
		for(int i=0; i <= binary.length()-1; i++) {
			if(binary.charAt(i) == '1') {
				decimal += Math.pow(2, binary.length()-1 - i);
			}
		}
		String decimal_String = Integer.toString(decimal);
		return decimal_String;
	}

	public static String decimal_ToBinary(String decimal) {
		String remainder = "";
		int decimal_int = Integer.parseInt(decimal);
		String binary = decimal_ToBinary(decimal_int, remainder);
		String filled_binary = fill_8(binary);
		String binary_String = reverseString(filled_binary);
		return binary_String;
	}
	
		private static String decimal_ToBinary(int deci, String remainder) {
			if(deci <=0 ) {
				return remainder;
			}else {
				remainder += deci % 2;
				return decimal_ToBinary(deci/2, remainder);
			}
		}

	public static String decimal_ToOctal(String decimal) {
		String remainder = "";
		int decimal_int = Integer.parseInt(decimal);
		String octal = decimal_ToOctal(decimal_int, remainder);
		String octal_String = reverseString(octal);
		return octal_String;
	}
		private static String decimal_ToOctal(int deci, String remainder) {
			while(deci > 0) {
				remainder += deci%8;
				deci = deci/8;
			}
			return remainder;
		}


	public static String octal_ToDecimal(String octal) {
		int decimal_Sum = 0;
		for(int i=0; i<=octal.length()-1; i++) {
			int token = Integer.valueOf(String.valueOf(octal.charAt(i)));
			decimal_Sum += (int)(token * Math.pow(8, octal.length()-1-i));
		}
		String decimal_String = String.valueOf(decimal_Sum);
		return decimal_String;
	}
	
	public static String decimal_ToHexadecimal(String decimal) {	
		//TODO: fill 32bits
		String remainder = "";
		int decimal_int = Integer.parseInt(decimal);
		String hex = decimal_ToHexadecimal(decimal_int, remainder) + "x0";
		String hex_String = reverseString(hex);
		return hex_String;
	}
		private static String decimal_ToHexadecimal(int deci, String remainder) {
			while(deci > 0) {
				int token = deci%16;
				if(token == 10) {
					remainder += "A";
				}else if(token == 11) {
					remainder += "B";
				}else if(token == 12) {
					remainder += "C";
				}else if(token == 13) {
					remainder += "D";
				}else if(token == 14) {
					remainder += "E";
				}else if(token == 15) {
					remainder += "F";
				}else {
					remainder += token;
				}
				deci = deci/16;
			}
			return remainder;
		}

	public static String hexadecimal_ToDecimal(String h) {
		String hex = h.substring(2, h.length());	//ignore 0x of string
		String hex_String = reverseString(hex);
		int decimalValue = 0;
		
		for(int i=0; i<hex_String.length(); i++) {
			if(hex_String.charAt(i) != '0') {
				if(hex_String.charAt(i) == 'A') {
					decimalValue += (int) (10*Math.pow(16,i));
				}else if(hex_String.charAt(i) == 'B') {
					decimalValue += (int) (11*Math.pow(16,i));
				}else if(hex_String.charAt(i) == 'C') {
					decimalValue += (int) (12*Math.pow(16,i));	
				}else if(hex_String.charAt(i) == 'D') {
					decimalValue += (int) (13*Math.pow(16,i));
				}else if(hex_String.charAt(i) == 'E') {
					decimalValue += (int) (14*Math.pow(16,i));
				}else if(hex_String.charAt(i) == 'F') {
					decimalValue += (int) (15*Math.pow(16,i));
				}else {
					int v = Character.getNumericValue(hex_String.charAt(i));
					decimalValue += (int) (v*Math.pow(16, i));
				}
			}
		}
		String decimal_String = String.valueOf(decimalValue);
		return decimal_String;
	}
	
//////////////////////////COLOR, CHARACTERS, FLOATING POINT CONVERSIONS/////////////////////////////////////////////////////////////

//COLOR

	public static Color hexadecimal_ToColor(String hex) {
		int r = extract_Red(hex);
		int g = extract_Green(hex);
		int b = extract_Blue(hex);
		
		Color c = new Color(r, g, b);
		return c;
	}
		private static int extract_Red(String hex) {
			String r_hex = hex.substring(4,6);
			int r =Integer.parseInt( hex_ToDeci(r_hex));
			return r;
		}
		private static int extract_Green(String hex) {
			String g_hex = hex.substring(6,8);
			int g =Integer.parseInt( hex_ToDeci(g_hex));
			return g;
		}
		private static int extract_Blue(String hex) {
			String b_hex = hex.substring(8,10);
			int b =Integer.parseInt( hex_ToDeci(b_hex));
			return b;
		}

	public static String color_ToHexadecimal(Color color) {
		
		String alpha = String.valueOf(color.getAlpha());
		String red = String.valueOf(color.getRed());	
		String green = String.valueOf(color.getGreen());
		String blue = String.valueOf(color.getBlue());	
	
		String aHex = deci_ToHex(alpha);	//convert decimal value of alpha to hex
		String rHex = deci_ToHex(red);		//convert decimal value of red to hex
		String gHex = deci_ToHex(green);	//convert decimal value of green to hex
		String bHex = deci_ToHex(blue);		//convert decimal value of blue to hex
	
		if(aHex.length() == 1) {			//hex color needs to be in format: 0xFF000000
			aHex += "0";					//fill with 00s
		}else if(aHex.length() == 0) {
			aHex += "00";
		}
		if(rHex.length() == 1) {		
			rHex += "0";					
		}else if(rHex.length() == 0) {
			rHex += "00";
		}
		if(gHex.length() == 1) {
			gHex += "0";
		}else if(gHex.length() == 0) {
			gHex += "00";
		}
		if(bHex.length() == 1) {
			bHex += "0";
		}else if(bHex.length() == 0) {
			bHex += "00";
		}
		String hex_String = "0x" /*+ aHex*/ + rHex + gHex + bHex;
		return hex_String;	
	}
	
//CHARACTERS	
	
	public static String binary_ToCharacter(String bin) {
		String character_String ="";
		String binary_reverse = reverseString(bin);
		String binary_fill = fill_8(binary_reverse);
		String binary_String = reverseString(binary_fill);
				
		for(int i=0; i<binary_String.length(); i+=8) {
			String sbstring = binary_String.substring(i, i+8);
			int characterValue = Integer.parseInt(binary_ToDecimal(sbstring));
			char character = (char) characterValue;
			character_String += character;
		}	
		return character_String;
	}
	
	public static String character_ToBinary(String character_String) {	
		String binary_String = "";
		for(int i=0; i<character_String.length(); i++) {
			char character = character_String.charAt(i);
			int charValue = (int) character;
			String deciValue  = "" + charValue;
			String binValue = decimal_ToBinary(deciValue);
			binary_String += binValue;
		}
		return binary_String;
	}
	
//FLOATING POINT
	
	public static String binary_ToFloat(String binary) {
		String binary_String = fill_32(binary);	
			
		//grab necessary components from binary string
		String sign = "" + binary_String.charAt(0);
		String E = binary_String.substring(1, 9);		
		int e = Integer.valueOf(binary_ToDecimal(E)) - 127;
		String mantissa = binary_String.substring(9,binary_String.length());
		
		//determine exponent and scientific notation
		String float_binValue = "1" + mantissa;
		int ex = e - 23; 								//exponent to turn mantissa into whole number + the actual exponent
		int bin = Integer.parseInt(float_binValue,2);	//turns binary string into int
		if(e > 0 || e < 0) {		
			double exponent = Math.pow(2, ex);			//move decimal place
			double num = bin * exponent;				//calculate final result
			float_binValue = String.valueOf(num);
		}else {	
			float_binValue = "1.";
			float_binValue += mantissa;
		}
		
		//append sign to float value
		String float_String = "";
		if(sign.equals("0")) {
			float_String += float_binValue;
		}else if(sign.equals("1")) {
			float_String += "-" + float_binValue; 
		}
		return float_String;
	}
	
	public static String float_ToBinary(String floatP) {
		float myFloat = Float.valueOf(floatP);
		boolean positive = myFloat<0?false:true;	//determines sign
		myFloat = positive?myFloat:-myFloat;		//changes float depending on sign

		/*
		 * Determines where final decimal point will be located
		 * Since scientific notation is in the form: 1.manitssa * 2^e
		 * stop moving decimal point when float is between 1 and 2
		 */
		int exp = 0;
		while(myFloat<1) {	
			myFloat*=2;
			exp--;
		}
		while(myFloat>=2) {
			myFloat/=2;
			exp++;
		}
				
		myFloat*=Math.pow(2, 23);									//turns float into whole number
		String mantissa = String.valueOf(((int)myFloat)&0x7FFFFF);	//grabs the entire decimal value of float [1.mantissa..]
		String exponent = String.valueOf(exp + 127);
		String sign = positive?"0":"1";
		
		String binary_String = sign + decimal_ToBinary(exponent) + decimal_ToBinary(mantissa).substring(1, 24)/*grabs last 23 bits*/;
		return binary_String;
	}
	
////////////////////////////////////////////////SPECIAL METHODS FOR COLOR CONVERSION///////////////////////////////////////////////////


	public static String deci_ToHex(String decimal) {
			String remainder = "";
			int deci = Integer.parseInt(decimal);
			String r = deci_ToHex(deci, remainder);
			String s = reverseString(r);
			return s;
		}
		private static String deci_ToHex(int deci, String remainder) {
			while(deci > 0) {
				int token = deci%16;
				if(token == 10) {
					remainder += "A";
				}else if(token == 11) {
					remainder += "B";
				}else if(token == 12) {
					remainder += "C";
				}else if(token == 13) {
					remainder += "D";
				}else if(token == 14) {
					remainder += "E";
				}else if(token == 15) {
					remainder += "F";
				}else {
					remainder += token;
				}
				deci = deci/16;
			}
			return remainder;
		}
	public static String hex_ToDeci(String hex) {
		String rHex = reverseString(hex);
		int value = 0;
		
		for(int i=0; i<rHex.length(); i++) {
			if(rHex.charAt(i) != '0') {
				if(rHex.charAt(i) == 'A') {
					value += (int) (10*Math.pow(16,i));
				}else if(rHex.charAt(i) == 'B') {
					value += (int) (11*Math.pow(16,i));
				}else if(rHex.charAt(i) == 'C') {
					value += (int) (12*Math.pow(16,i));	
				}else if(rHex.charAt(i) == 'D') {
					value += (int) (13*Math.pow(16,i));
				}else if(rHex.charAt(i) == 'E') {
					value += (int) (14*Math.pow(16,i));
				}else if(rHex.charAt(i) == 'F') {
					value += (int) (15*Math.pow(16,i));
				}else {
					int v = Character.getNumericValue(rHex.charAt(i));
					value += (int) (v*Math.pow(16, i));
				}
			}
		}
		String deci = String.valueOf(value);
		return deci;
	}
	
///////////////////////////////////////////REMAINDER OF CONVERSIONS///////////////////////////////////////////////////////////////////		
//EACH CONVERSION REUSES PREVIOUS CONVERSIONS ABOVE: NO NEW METHODS

		public static String binary_ToOctal(String binary) {
			String deci = binary_ToDecimal(binary);
			String octal = decimal_ToOctal(deci);
			return octal;
		}	

		public static String binary_ToHexadecimal(String binary) {
			String deci = binary_ToDecimal(binary);
			String hex = decimal_ToHexadecimal(deci);
			return hex;
		}

		public static String octal_ToBinary(String octal) {
			String deci = octal_ToDecimal(octal);
			String bin = decimal_ToBinary(deci);
			return bin;
		}

		public static String octal_ToHexadecimal(String octal) {
			String deci = octal_ToDecimal(octal);
			String hex = decimal_ToHexadecimal(deci);
			return hex;
		}
		public static Color binary_ToColor(String binary) {
			String hex = binary_ToHexadecimal(binary);
			Color color = hexadecimal_ToColor(hex);
			return color;
		}
		public static String decimal_ToCharacter(String decimal) {
			String bin = decimal_ToBinary(decimal);
			String character = binary_ToCharacter(bin);
			return character;
		}
		public static Color decimal_ToColor(String decimal) {
			String hex = decimal_ToHexadecimal(decimal);
			Color color = hexadecimal_ToColor(hex);
			return color;
		}
		public static String decimal_ToFloat(String decimal) {
			String bin = decimal_ToBinary(decimal);
			String floatP = binary_ToFloat(bin);
			return floatP;
		}
		public static String octal_ToCharacter(String octal) {
			String bin = octal_ToBinary(octal);
			String characters = binary_ToCharacter(bin);
			return characters;
		}
		public static Color octal_ToColor(String octal) {
			String bin = octal_ToBinary(octal);
			String hex = binary_ToHexadecimal(bin);
			Color color = hexadecimal_ToColor(hex);
			return color;
		}
		public static String octal_ToFloat(String octal) {
			String bin = octal_ToBinary(octal);
			String floatP = binary_ToFloat(bin);
			return floatP;
		}
		public static String hexadecimal_ToBinary(String hex) {
			String decimal = hexadecimal_ToDecimal(hex);
			String bin = decimal_ToBinary(decimal);
			return bin;
		}
		public static String hexadecimal_ToOctal(String hex) {
			String decimal = hexadecimal_ToDecimal(hex);
			String octal = decimal_ToOctal(decimal);
			return octal;
		}
		public static String hexadecimal_ToCharacter(String hex) {
			String bin = hexadecimal_ToBinary(hex);
			String character = binary_ToCharacter(bin);
			return character;
		}
		public static String hexadecimal_ToFloat(String hex) {
			String bin = hexadecimal_ToBinary(hex);
			String floatP = binary_ToFloat(bin);
			return floatP;
		}
		public static String character_ToDecimal(String character) {
			String bin = character_ToBinary(character);
			String decimal = binary_ToDecimal(bin);
			return decimal;
		}
		public static String character_ToOctal(String character) {
			String bin = character_ToBinary(character);
			String octal = binary_ToOctal(bin);
			return octal;
		}
		public static String character_ToHexadecimal(String character) {
			String bin = character_ToBinary(character);
			String hex = binary_ToHexadecimal(bin);
			return hex;
		}
		public static Color character_ToColor(String character) {
			String bin = character_ToBinary(character);
			Color color = binary_ToColor(bin);
			return color;
		}
		public static String character_ToFloat(String character) {
			String bin = character_ToBinary(character);
			String floatP = binary_ToFloat(bin);
			return floatP;
		}
		public static String color_ToBinary(Color color) {
			String hex = color_ToHexadecimal(color); //0xFFFFFFFF
			String bin = hexadecimal_ToBinary(hex);
			return bin;
		}
		public static String color_ToDecimal(Color color) {
			String hex = color_ToHexadecimal(color);
			String decimal = hexadecimal_ToDecimal(hex);
			return decimal;
		}
		public static String color_ToOctal(Color color) {
			String hex = color_ToHexadecimal(color);
			String octal = hexadecimal_ToOctal(hex);
			return octal;
		}
		public static String color_ToCharacter(Color color) {
			String hex = color_ToHexadecimal(color);
			String character = hexadecimal_ToCharacter(hex);
			return character;
		}
		public static String color_ToFloat(Color color) {
			String bin = color_ToBinary(color);
			String floatP = binary_ToFloat(bin);
			return floatP;
		}
		public static String float_ToDecimal(String floatP) {
			String bin = float_ToBinary(floatP);
			String decimal = binary_ToDecimal(bin);
			return decimal;
		}
		public static String float_ToOctal(String floatP) {
			String bin = float_ToBinary(floatP);
			String octal = binary_ToOctal(bin);
			return octal;
		}
		public static String float_ToHexadecimal(String floatP) {
			String bin = float_ToBinary(floatP);
			String hexadecimal = binary_ToHexadecimal(bin);
			return hexadecimal;
		}
		public static String float_ToCharacter(String floatP) {
			String bin = float_ToBinary(floatP);
			String character = binary_ToCharacter(bin);
			return character;
		}
		public static Color float_ToColor(String floatP) {
			String bin = float_ToBinary(floatP);
			Color color = binary_ToColor(bin);
			return color;
		}
}
