import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Number_Converter_GUI {
	protected JFrame frame = new JFrame("Number Converter");
	protected JPanel pnl = new JPanel(new GridBagLayout());
			
	protected JLabel deci_Lbl = new JLabel( "Decimal" );
	protected JLabel bin_Lbl = new JLabel( "Binary" );
	protected JLabel octal_Lbl = new JLabel( "Octal" );
	protected JLabel hex_Lbl = new JLabel( "Hexadecimal" );
	protected JLabel char_Lbl = new JLabel( "Character(s)" );
	protected JLabel color_Lbl = new JLabel( "Color" );
	protected JLabel float_Lbl = new JLabel( "Float Decimal" );
    
	protected JTextField deci_Txt = new JTextField(20);
	protected JTextField bin_Txt = new JTextField(20);
	protected JTextField octal_Txt = new JTextField(20);
	protected JTextField hex_Txt = new JTextField(20);
	protected JTextField char_Txt = new JTextField(20);
	protected JTextField color_Txt = new JTextField(20);
	protected JTextField float_Txt = new JTextField(20);
    
	protected JButton color_Buttn = new JButton("Choose Color");
	protected JButton convrt_Buttn = new JButton("Convert");
	protected JButton clear_Buttn = new JButton("Clear");
	
	public Number_Converter_GUI() {

        GridBagConstraints constraints = new GridBagConstraints();

//Decimal row
      //(spacing to the top, spacing to the left, spacing to bottom, spacing to the right)
      	constraints.insets = new Insets(80,5,0,5);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( deci_Lbl, constraints );
      	
      	constraints.insets = new Insets(80,5,0,150);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;	//works in conjunction with gridHeight + gridWidth
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( deci_Txt, constraints );

//Binary row
      	constraints.insets = new Insets(0,5,0,5);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( bin_Lbl, constraints );
      	
      	constraints.insets = new Insets(0,5,0,150);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;	//works in conjunction with gridHeight + gridWidth
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( bin_Txt, constraints );
      	
//Octal row
      	constraints.insets = new Insets(0,5,0,5);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( octal_Lbl, constraints );
      	
      	constraints.insets = new Insets(0,5,0,150);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;	//works in conjunction with gridHeight + gridWidth
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( octal_Txt, constraints );

//Hex row     	
      	constraints.insets = new Insets(0,5,0,5);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( hex_Lbl, constraints );
      	
      	constraints.insets = new Insets(0,5,0,150);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;	//works in conjunction with gridHeight + gridWidth
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( hex_Txt, constraints );
  
//Character(s) row     	
      	constraints.insets = new Insets(0,5,0,5);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( char_Lbl, constraints );
      	
      	constraints.insets = new Insets(0,5,0,150);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( char_Txt, constraints );
      	
//Color row
      	constraints.insets = new Insets(0,5,0,5);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( color_Lbl, constraints );
      	
      	constraints.insets = new Insets(0,5,0,150);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;	//works in conjunction with gridHeight + gridWidth
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( color_Txt, constraints );
      	
      	constraints.insets = new Insets(0,230,0,30);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        color_Buttn.setPreferredSize(new Dimension(4,20)); 
        constraints.gridx = 3;
        constraints.gridy = 5;
        constraints.gridheight = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;	
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( color_Buttn, constraints );
      	
//Float row
      	constraints.insets = new Insets(0,5,0,5);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( float_Lbl, constraints );
      	
      	constraints.insets = new Insets(0,5,0,150);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;	//works in conjunction with gridHeight + gridWidth
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( float_Txt, constraints );
      	
//Last row      	
      	constraints.insets = new Insets(0,5,0,150);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        convrt_Buttn.setPreferredSize(new Dimension(4,20)); 
        constraints.gridx = 2;
        constraints.gridy = 7;
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;	
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( convrt_Buttn, constraints );
      	
      	constraints.insets = new Insets(0,230,0,30);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        clear_Buttn.setPreferredSize(new Dimension(4,20)); 
        constraints.gridx = 3;
        constraints.gridy = 7;
        constraints.gridheight = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;	
        constraints.weighty = 1;
        constraints.weightx = 1;
      	pnl.add( clear_Buttn, constraints );
     
//Button Action Events************************************************************************************************
//Color Button
		color_Buttn.addActionListener(
				
				new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "", Color.black);
				color_Txt.setBackground(color);
				
			}
		});
//Convert Button
		convrt_Buttn.addActionListener(
				
				new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//retrieve strings from text field and send them into arraylist, except color
					//each index of the array list corresponds to the type of the data (decimal, binary, octal, etc...)
					//no conversion exists to decode color.toString(), so send color through converter manager as a separate
					//parameter. 
				//send array list into number converter
				//number converter outputs an array list of converted strings
				//output strings from array list into text fields
			
				//Get strings from text field 
				String decimal = deci_Txt.getText();
				String binary = bin_Txt.getText();
				String octal = octal_Txt.getText();
				String hexadecimal = hex_Txt.getText();
				String character = char_Txt.getText();
				Color color = color_Txt.getBackground();
				String floatingPoint = float_Txt.getText();
						
				//puts strings into array list
				ArrayList<String> list = new ArrayList<String>();
				list.add(decimal); list.add(binary); list.add(octal); list.add(hexadecimal);
				list.add(character); list.add(floatingPoint);
				
				//send array list into number converter, along with color
				Number_Converter_Manager converter = new Number_Converter_Manager(list, color);
				
				//retrieve array list of converted numbers and new color
				 list = converter.convert();
				 Color newColor = converter.getColor();
				
				//output strings from array list into text fields
				deci_Txt.setText(list.get(0)!=null?list.get(0):"");
				bin_Txt.setText(list.get(1)!=null?list.get(1):"");
				octal_Txt.setText(list.get(2)!=null?list.get(2):"");
				hex_Txt.setText(list.get(3)!=null?list.get(3):"");
				char_Txt.setText(list.get(4)!=null?list.get(4):"");
				color_Txt.setBackground(newColor != color?newColor:color);
				float_Txt.setText(list.get(5)!=null?list.get(5):"");
			}
		});
//Clear Button
		clear_Buttn.addActionListener(
				
				new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				deci_Txt.setText("");
				bin_Txt.setText("");
				octal_Txt.setText("");
				hex_Txt.setText("");
				char_Txt.setText("");
				color_Txt.setBackground(Color.WHITE);
				float_Txt.setText("");
			}
		});
//*************************************************************************************************************************     
      	
      	
		frame.add(pnl, BorderLayout.WEST);
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
