import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator {
	static String op ="";
	static String operand = "";
	static String operator = "";
	static String memory = "";
	static JTextField textfieldinput= new JTextField();
	static JTextField textfieldmemory= new JTextField();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Font textfieldmemoryfont = new Font("Myriad Pro Cond", Font.PLAIN, 12);
		Font textfieldinputfont = new Font("Myriad Pro Cond", Font.PLAIN, 70);
		Font buttonfont = new Font("Arial", Font.PLAIN, 25);
		
		JFrame frame = new JFrame("Calculator");
		frame.addWindowListener( new WindowAdapter() {
		    public void windowOpened( WindowEvent e ){
		        textfieldinput.requestFocus();
		    }
		}); 
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(200, 200, 200));
		
		frame.add(panel);
		
		
		textfieldmemory.setLayout(null);
		textfieldmemory.setHorizontalAlignment(SwingConstants.RIGHT);
		textfieldmemory.setBounds(5, 5, 376, 24); // (x-axis, y-axis, width, height)
		textfieldmemory.setFont(textfieldmemoryfont);
		textfieldmemory.setBackground(new Color(23, 24, 26)); // (r, g, b)
		textfieldmemory.setForeground(new Color(220, 220, 220));
		textfieldmemory.setCaretColor(new Color(220, 220, 220));
		textfieldmemory.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textfieldmemory.setEditable(false);
		panel.add(textfieldmemory);
		
		textfieldinput.setLayout(null);
		textfieldinput.setHorizontalAlignment(SwingConstants.RIGHT);
		textfieldinput.setBounds(5, 29, 376, 99);
		textfieldinput.setFont(textfieldinputfont);
		textfieldinput.setBackground(new Color(23, 24, 26));
		textfieldinput.setForeground(new Color(220, 220, 220));
		textfieldinput.setCaretColor(new Color(220, 220, 220));
		textfieldinput.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textfieldinput.setEditable(false);
		panel.add(textfieldinput);
		
		JButton buttonmc = new JButton("mc"); // mc button
		buttonmc.setBounds(5, 130, 75, 55);
		buttonmc.setFont(buttonfont);
		buttonmc.setBackground(new Color(50, 55, 51));
		buttonmc.setForeground(new Color(220, 220, 220));
		buttonmc.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent args0) {
				memory = "";
				textfieldmemory.setText("");
				textfieldinput.setText("");
				op = "blank";
			}		
		});
		panel.add(buttonmc);
		
		JButton buttonmr = new JButton("mr"); // mr button
		buttonmr.setBounds(80, 130, 75, 55);
		buttonmr.setFont(buttonfont);
		buttonmr.setBackground(new Color(50, 55, 51));
		buttonmr.setForeground(new Color(220, 220, 220));
		buttonmr.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textfieldinput.setText(memory);
				if(!memory.equals("")){
					textfieldmemory.setText("M");
					op = "blank";
				}
			}
		});
		panel.add(buttonmr);
		
		JButton buttonmplus = new JButton("m+"); // m+ button
		buttonmplus.setBounds(155, 130, 75, 55);
		buttonmplus.setFont(buttonfont);
		buttonmplus.setBackground(new Color(50, 55, 51));
		buttonmplus.setForeground(new Color(220, 220, 220));
		buttonmplus.addActionListener(new ActionListener(){ 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				memory = String.valueOf(Float.parseFloat(memory) + Float.parseFloat(textfieldinput.getText()));
				textfieldinput.setText(memory);
				if(!memory.equals("")){
					textfieldmemory.setText("M");
					op="blank";
				}
			}
		});
		panel.add(buttonmplus);
		
		JButton buttonmminus = new JButton("m-"); // m- button
		buttonmminus.setBounds(230, 130, 75, 55);
		buttonmminus.setFont(buttonfont);
		buttonmminus.setBackground(new Color(50, 55, 51));
		buttonmminus.setForeground(new Color(220, 220, 220));
		buttonmminus.addActionListener(new ActionListener(){ 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				memory = String.valueOf(Float.parseFloat(memory) - Float.parseFloat(textfieldinput.getText()));
				textfieldinput.setText(memory);
				if(!memory.equals("")){
					textfieldmemory.setText("M");
					op="blank";
				}
			}
		});
		panel.add(buttonmminus);
		
		JButton buttonms = new JButton("ms"); // ms button
		buttonms.setBounds(305, 130, 75, 55);
		buttonms.setFont(buttonfont);
		buttonms.setBackground(new Color(50, 55, 51));
		buttonms.setForeground(new Color(220, 220, 220));
		buttonms.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				memory = String.valueOf(Float.parseFloat(textfieldinput.getText()));
				if(!memory.equals("")){
					textfieldmemory.setText("M");
					op="blank";
				}
			}
		});
		panel.add(buttonms);
		
		JButton buttonpercent = new JButton("%"); // percent button
		buttonpercent.setBounds(5, 185, 75, 55);
		buttonpercent.setFont(buttonfont);
		buttonpercent.setBackground(new Color(50, 55, 51));
		buttonpercent.setForeground(new Color(220, 220, 220));
		buttonpercent.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent args0) {
				textfieldinput.setText(String.valueOf(Float.parseFloat(textfieldinput.getText())/100));
				op = "blank";
			}		
		});
		panel.add(buttonpercent);
		
		JButton buttonclear = new JButton("C"); // clear button
		buttonclear.setBounds(80, 185, 75, 55);
		buttonclear.setFont(buttonfont);
		buttonclear.setBackground(new Color(50, 55, 51));
		buttonclear.setForeground(new Color(220, 220, 220));
		buttonclear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent args0) {
				textfieldinput.setText("");	
				op = "blank";
			}		
		});
		panel.add(buttonclear);
		
		JButton buttondivide = new JButton("\u00F7"); // divide button
		buttondivide.setBounds(155, 185, 75, 55);
		buttondivide.setFont(buttonfont);
		buttondivide.setBackground(new Color(50, 55, 51));
		buttondivide.setForeground(new Color(220, 220, 220));
		buttondivide.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 op = "/";
			}
		});
		panel.add(buttondivide);
		
		JButton buttonmultiply = new JButton("x"); // multiply button
		buttonmultiply.setBounds(230, 185, 75, 55);
		buttonmultiply.setFont(buttonfont);
		buttonmultiply.setBackground(new Color(50, 55, 51));
		buttonmultiply.setForeground(new Color(220, 220, 220));
		buttonmultiply.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 op = "x";
			}
		});
		panel.add(buttonmultiply);
		
		JButton buttondelete = new JButton("\u2190"); // backspace/delete button
		buttondelete.setBounds(305, 185, 75, 55);
		buttondelete.setFont(buttonfont);
		buttondelete.setBackground(new Color(50, 55, 51));
		buttondelete.setForeground(new Color(220, 220, 220));
		buttondelete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent args0) {
				textfieldinput.setText(textfieldinput.getText().substring(0,textfieldinput.getText().length()-1));			
			}		
		});
		panel.add(buttondelete);
		
		JButton buttonsquareroot = new JButton("\u221A"); // squareroot button
		buttonsquareroot.setBounds(5, 240, 75, 55);
		buttonsquareroot.setFont(buttonfont);
		buttonsquareroot.setBackground(new Color(50, 55, 51));
		buttonsquareroot.setForeground(new Color(220, 220, 220));
		buttonsquareroot.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textfieldinput.setText(String.valueOf(Math.sqrt(Float.parseFloat(textfieldinput.getText()))));
				op = "blank";	
			}		
		});
		panel.add(buttonsquareroot);
		
		JButton button7 = new JButton("7"); // number 7 button
		button7.setBounds(80, 240, 75, 55);
		button7.setFont(buttonfont);
		button7.setBackground(new Color(50, 55, 51));
		button7.setForeground(new Color(220, 220, 220));
		button7.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonPressed("7");			
			}		
		});
		panel.add(button7);
		
		JButton button8 = new JButton("8"); // number 8 button
		button8.setBounds(155, 240, 75, 55);
		button8.setFont(buttonfont);
		button8.setBackground(new Color(50, 55, 51));
		button8.setForeground(new Color(220, 220, 220));
		button8.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonPressed("8");			
			}		
		});
		panel.add(button8);
		
		JButton button9 = new JButton("9"); // number 9 button
		button9.setBounds(230, 240, 75, 55);
		button9.setFont(buttonfont);
		button9.setBackground(new Color(50, 55, 51));
		button9.setForeground(new Color(220, 220, 220));
		button9.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonPressed("9");			
			}		
		});
		panel.add(button9);
		
		JButton buttonminus = new JButton("-"); // minus button
		buttonminus.setBounds(305, 240, 75, 55);
		buttonminus.setFont(buttonfont);
		buttonminus.setBackground(new Color(50, 55, 51));
		buttonminus.setForeground(new Color(220, 220, 220));
		buttonminus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 op = "-";
			}
		});
		panel.add(buttonminus);
		
		JButton buttonxsquared = new JButton("x\u00B2"); // x-squared button
		buttonxsquared.setBounds(5, 295, 75, 55);
		buttonxsquared.setFont(buttonfont);
		buttonxsquared.setBackground(new Color(50, 55, 51));
		buttonxsquared.setForeground(new Color(220, 220, 220));
		buttonxsquared.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textfieldinput.setText(String.valueOf(Math.pow(Float.parseFloat(textfieldinput.getText()), 2)));
				op = "blank";			
			}		
		});
		panel.add(buttonxsquared);
		
		JButton button4 = new JButton("4"); // number 4 button
		button4.setBounds(80, 295, 75, 55);
		button4.setFont(buttonfont);
		button4.setBackground(new Color(50, 55, 51));
		button4.setForeground(new Color(220, 220, 220));
		button4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonPressed("4");			
			}	
		});
		panel.add(button4);
		
		JButton button5 = new JButton("5"); // number 5 button
		button5.setBounds(155, 295, 75, 55);
		button5.setFont(buttonfont);
		button5.setBackground(new Color(50, 55, 51));
		button5.setForeground(new Color(220, 220, 220));
		button5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonPressed("5");			
			}		
		});
		panel.add(button5);
		
		JButton button6 = new JButton("6"); // number 6 button
		button6.setBounds(230, 295, 75, 55);
		button6.setFont(buttonfont);
		button6.setBackground(new Color(50, 55, 51));
		button6.setForeground(new Color(220, 220, 220));
		button6.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonPressed("6");			
			}	
		});
		panel.add(button6);
		
		JButton buttonplus = new JButton("+"); // plus button
		buttonplus.setBounds(305, 295, 75, 55);
		buttonplus.setFont(buttonfont);
		buttonplus.setBackground(new Color(50, 55, 51));
		buttonplus.setForeground(new Color(220, 220, 220));
		buttonplus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 op = "+";
			}
		});
		panel.add(buttonplus);
		
		JButton buttonxcubed = new JButton("x\u00B3"); // x-cubed button
		buttonxcubed.setBounds(5, 350, 75, 55);
		buttonxcubed.setFont(buttonfont);
		buttonxcubed.setBackground(new Color(50, 55, 51));
		buttonxcubed.setForeground(new Color(220, 220, 220));
		buttonxcubed.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textfieldinput.setText(String.valueOf(Math.pow(Float.parseFloat(textfieldinput.getText()), 3)));
				op = "blank";			
			}		
		});
		panel.add(buttonxcubed);
		
		JButton button1 = new JButton("1"); // number 1 button
		button1.setBounds(80, 350, 75, 55);
		button1.setFont(buttonfont);
		button1.setBackground(new Color(50, 55, 51));
		button1.setForeground(new Color(220, 220, 220));
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonPressed("1");			
			}		
		});
		panel.add(button1);
		
		JButton button2 = new JButton("2"); // number 2 button
		button2.setBounds(155, 350, 75, 55);
		button2.setFont(buttonfont);
		button2.setBackground(new Color(50, 55, 51));
		button2.setForeground(new Color(220, 220, 220));
		button2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonPressed("2");			
			}		
		});
		panel.add(button2);
		
		JButton button3 = new JButton("3"); // number 3 button
		button3.setBounds(230, 350, 75, 55);
		button3.setFont(buttonfont);
		button3.setBackground(new Color(50, 55, 51));
		button3.setForeground(new Color(220, 220, 220));
		button3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonPressed("3");			
			}		
		});
		panel.add(button3);
		
		JButton buttonequals = new JButton("="); // equal button
		buttonequals.setBounds(305, 350, 75, 110);
		buttonequals.setFont(buttonfont);
		buttonequals.setBackground(new Color(43, 145, 147));
		buttonequals.setForeground(new Color(220, 220, 220));
		buttonequals.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				float op1 =Float.parseFloat(operand);
				float op2 =Float.parseFloat(textfieldinput.getText());
				if(operator == "+"){
					float sum =(op1 + op2);
					textfieldinput.setText(String.valueOf(sum));
				}
				else if (operator == "-"){
					float difference = (op1 - op2);
					textfieldinput.setText(String.valueOf(difference));
				}
				else if (operator == "x"){
					float product = (op1 * op2);
					textfieldinput.setText(String.valueOf(product));
				}
				else if (operator == "/"){
					float quotient = (op1 / op2);
					textfieldinput.setText(String.valueOf(quotient));
				}
			}
		});
		panel.add(buttonequals);
		
		JButton button1overx = new JButton("1/x"); // 1 over x button
		button1overx.setBounds(5, 405, 75, 55);
		button1overx.setFont(buttonfont);
		button1overx.setBackground(new Color(50, 55, 51));
		button1overx.setForeground(new Color(220, 220, 220));
		button1overx.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent args0) {
				textfieldinput.setText(String.valueOf(1/Float.parseFloat(textfieldinput.getText())));
				op ="blank";
			}		
		});
		panel.add(button1overx);
		
		JButton buttonplusminus = new JButton("\u00B1"); // plus minus button
		buttonplusminus.setBounds(80, 405, 75, 55);
		buttonplusminus.setFont(buttonfont);
		buttonplusminus.setBackground(new Color(50, 55, 51));
		buttonplusminus.setForeground(new Color(220, 220, 220));
		buttonplusminus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent args0) {
				if(textfieldinput.getText().startsWith("-")){
					textfieldinput.setText(textfieldinput.getText().substring(1,textfieldinput.getText().length()-0));
				}
				else {
					textfieldinput.setText("-" + textfieldinput.getText());
				}
			}		
		});
		panel.add(buttonplusminus);
		
		JButton button0 = new JButton("0"); // number 0 button
		button0.setBounds(155, 405, 75, 55);
		button0.setFont(buttonfont);
		button0.setBackground(new Color(50, 55, 51));
		button0.setForeground(new Color(220, 220, 220));
		button0.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonPressed("0");			
			}
		});
		panel.add(button0);
		
		JButton buttonpoint = new JButton("."); // decimal point button
		buttonpoint.setBounds(230, 405, 75, 55);
		buttonpoint.setFont(buttonfont);
		buttonpoint.setBackground(new Color(50, 55, 51));
		buttonpoint.setForeground(new Color(220, 220, 220));
		buttonpoint.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent args0) {
				if(textfieldinput.getText().length()==0){
					textfieldinput.setText("0.");
				}
				else if (!textfieldinput.getText().contains(".")){
					textfieldinput.setText(textfieldinput.getText()+ ".");
				};		
			}		
		});
		panel.add(buttonpoint);
		
		frame.setSize(390, 493);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	private static void buttonPressed(String number){
		if(op.length()>0){
			operand = textfieldinput.getText();
			operator = op;
			op = "";
			textfieldinput.setText(number);
		}
		else {
			textfieldinput.setText(textfieldinput.getText() + number);
		}
	}

}