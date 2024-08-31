import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textfield;
	JTextField textfield1;
	JButton[] numberButton = new JButton[10];
	JButton[] functionButton = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButon, delButton, clrButton, gstButton;
	JPanel panel;

	Font font = new Font("Times New Roman", Font.BOLD, 30);
	double num1 = 0, num2 = 0, result = 0;
	char operator;

	Calculator() {
		
		frame = new JFrame("Gst_Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50,80,300,50);
		textfield.setFont(font);
		textfield.setEditable(false);
		
		textfield1 = new JTextField();
		textfield1.setBounds(50,25,300,50);
		textfield1.setFont(font);
		textfield1.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButon = new JButton("=");
		gstButton = new JButton("Gst");
		
		delButton = new JButton("<-");
		clrButton = new JButton("C");
		
		functionButton[0] = addButton;
		functionButton[1] = subButton;
		functionButton[2] = mulButton;
		functionButton[3] = divButton;
		functionButton[4] = decButton;
		functionButton[5] = equButon;
		functionButton[6] = delButton;
		functionButton[7] = clrButton;
		functionButton[8] = gstButton;
		
		for (int i=0;i<9;i++) {
			functionButton[i].addActionListener(this);
			functionButton[i].setFont(font);
			functionButton[i].setFocusable(false);
		}
		
		for (int i=0;i<10;i++) {
			numberButton[i] = new JButton(String.valueOf(i));
			numberButton[i].addActionListener(this);
			numberButton[i].setFont(font);
			numberButton[i].setFocusable(false);
		}
		
		delButton.setBounds(50,450,100,50);
		clrButton.setBounds(270,450,80,50);
		gstButton.setBounds(160,450,100,50);
		
		panel = new JPanel();
		panel.setBounds(50, 140, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.GRAY);
		
		panel.add(numberButton[1]);
		panel.add(numberButton[2]);
		panel.add(numberButton[3]);
		panel.add(addButton);
		
		panel.add(numberButton[4]);
		panel.add(numberButton[5]);
		panel.add(numberButton[6]);
		panel.add(subButton);
		
		panel.add(numberButton[7]);
		panel.add(numberButton[8]);
		panel.add(numberButton[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButton[0]);
		panel.add(equButon);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(gstButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield1);
		frame.add(textfield);
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0;i<10;i++) {
			if (e.getSource() == numberButton[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield1.setText(String.valueOf(num1));
			operator = '+';
			textfield.setText("");
		}
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield1.setText(String.valueOf(num1));
			operator = '-';
			textfield.setText("");
		}
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield1.setText(String.valueOf(num1));
			operator = '*';
			textfield.setText("");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield1.setText(String.valueOf(num1));
			operator = '/';
			textfield.setText("");
		}
		if (e.getSource() == equButon) {
			num2 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			switch(operator) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
			}
			textfield1.setText(String.valueOf(result));
			num1 = result;
		}
		if (e.getSource() == gstButton) {
			double gst = Double.parseDouble(String.valueOf(result));
			gst *= 19.0d;
			gst = (gst / 100.0);
			textfield.setText("");
			textfield1.setText(String.valueOf(gst));
		}
		if (e.getSource() == clrButton) {
			textfield.setText("");
			textfield1.setText("");
		}
		if (e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for (int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		
	}

}
