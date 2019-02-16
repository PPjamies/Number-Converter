import java.awt.Color;
import java.util.ArrayList;

public class Number_Converter_Manager {
	protected ArrayList<String> list = new ArrayList<>();
	protected String number;
	protected Color color;
	protected String type;
	
	/*
	 * indexes of array list corresponds to type of data:
	 * index 0 -> decimal
	 * index 1 -> binary
	 * index 2 -> octal
	 * index 3 -> hexadecimal
	 * index 4 -> character
	 * index 5 -> floatingPoint 
	 */
	public Number_Converter_Manager(ArrayList<String> _list, Color _color) {
		//Assume: that user inputs only one value into the text fields
		
		//color is not null by default, store as type by default
		color = _color;
		type = "color";	
		
		//traverse array to find user input, store value and type
		for(int i=0; i<_list.size(); i++) {
			if(!_list.get(i).equals("")) {	//found
				number = _list.get(i);
				if(i == 0) {
					type = "decimal";
				}else if(i == 1) {
					type = "binary";
				}else if(i == 2) {
					type = "octal";
				}else if(i == 3) {
					type = "hexadecimal";
				}else if(i == 4) {
					type = "character";
				}else if(i == 5) {
					type = "float";
				}
			}
		}
		list.clear();	//makes sure array list is clear first
	}
	
	//perform conversions depending on data type
	public ArrayList<String> convert(){
		if(type.equalsIgnoreCase("decimal")) {
			convrt_Deci();
		}else if(type.equalsIgnoreCase("binary")) {
			convrt_Bin();
		}else if(type.equalsIgnoreCase("octal")) {
			convrt_Octal();
		}else if(type.equalsIgnoreCase("hexadecimal")) {
			convrt_Hex();
		}else if(type.equalsIgnoreCase("character")) {
			convrt_Char();
		}else if(type.equalsIgnoreCase("color")) {
			convrt_Color();
		}else if(type.equalsIgnoreCase("float")) {
			convrt_Float();
		}
		return list;
	}

	//return number
		private String number() {
			return number;
		}
	//return color
		public Color getColor() {
			return color;
		}
	
/*************************************************************************************************************************************************************/	
	//saves conversions into array list
	private void convrt_Deci() {
		list.add(number());
		list.add(Conversion_Sheet.decimal_ToBinary(number));	
		list.add(Conversion_Sheet.decimal_ToOctal(number));
		list.add(Conversion_Sheet.decimal_ToHexadecimal(number));
		list.add(Conversion_Sheet.decimal_ToCharacter(number));
		this.color = Conversion_Sheet.decimal_ToColor(number);
		list.add(Conversion_Sheet.decimal_ToFloat(number));		
	}
	private void convrt_Bin() {
		list.add(Conversion_Sheet.binary_ToDecimal(number));
		list.add(number());
		list.add(Conversion_Sheet.binary_ToOctal(number));
		list.add(Conversion_Sheet.binary_ToHexadecimal(number));
		list.add(Conversion_Sheet.binary_ToCharacter(number));
		this.color = Conversion_Sheet.binary_ToColor(number);
		list.add(Conversion_Sheet.binary_ToFloat(number));		
	}
	private void convrt_Octal() {
		list.add(Conversion_Sheet.octal_ToDecimal(number));
		list.add(Conversion_Sheet.octal_ToBinary(number));
		list.add(number());
		list.add(Conversion_Sheet.octal_ToHexadecimal(number));
		list.add(Conversion_Sheet.octal_ToCharacter(number));
		this.color = Conversion_Sheet.octal_ToColor(number);
		list.add(Conversion_Sheet.octal_ToFloat(number));		
	}
	private void convrt_Hex() {
		list.add(Conversion_Sheet.hexadecimal_ToDecimal(number));
		list.add(Conversion_Sheet.hexadecimal_ToBinary(number));
		list.add(Conversion_Sheet.hexadecimal_ToOctal(number));
		list.add(number());
		list.add(Conversion_Sheet.hexadecimal_ToCharacter(number));
		this.color = Conversion_Sheet.hexadecimal_ToColor(number);
		list.add(Conversion_Sheet.hexadecimal_ToFloat(number));		
	}
	private void convrt_Char() {
		list.add(Conversion_Sheet.character_ToDecimal(number));
		list.add(Conversion_Sheet.character_ToBinary(number));
		list.add(Conversion_Sheet.character_ToOctal(number));
		list.add(Conversion_Sheet.character_ToHexadecimal(number));
		list.add(number());
		this.color = Conversion_Sheet.character_ToColor(number);
		list.add(Conversion_Sheet.character_ToFloat(number));		
	}
	private void convrt_Color() {
		list.add(Conversion_Sheet.color_ToDecimal(color));
		list.add(Conversion_Sheet.color_ToBinary(color));
		list.add(Conversion_Sheet.color_ToOctal(color));
		list.add(Conversion_Sheet.color_ToHexadecimal(color));
		list.add(Conversion_Sheet.color_ToCharacter(color));
		list.add(Conversion_Sheet.color_ToFloat(color));		
	}
	private void convrt_Float() {
		list.add(Conversion_Sheet.float_ToDecimal(number));
		list.add(Conversion_Sheet.float_ToBinary(number));
		list.add(Conversion_Sheet.float_ToOctal(number));
		list.add(Conversion_Sheet.float_ToHexadecimal(number));
		list.add(Conversion_Sheet.float_ToCharacter(number));
		this.color = Conversion_Sheet.float_ToColor(number);
		list.add(number());		
	}
		
/************************************************************************************************************************************************************/	
}
