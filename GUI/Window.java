package ro.tucn.tp.assig1.interfaca;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Window {
	private JFrame f;
	private JPanel mainPanel;
	private JPanel mainPanel1;
	private JPanel mainPanel2;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JTextField f1;
	private JTextField f2;
	private JTextField f3;
	private JButton plus;
	private JButton minus;
	private JButton mul;
	private JButton div;
	private JButton deriv;
	private JButton integ;
	//Constructor
	public Window() {
		f=new JFrame("Polinomi");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createPanels();
		createAndAddTextFields();
		addMainPanel1();
		createAndAddButtons();
		mainPanel.add(mainPanel2);
		f.setContentPane(mainPanel);
		f.pack();
		f.setVisible(true);
		f.setResizable(false);
	}
	//Methods for the constructor
	public void createPanels()
	{
		mainPanel=new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel1=new JPanel();
		mainPanel1.setLayout(new BoxLayout(mainPanel1, BoxLayout.Y_AXIS));
		mainPanel2=new JPanel();
		mainPanel2.setLayout(new BoxLayout(mainPanel2, BoxLayout.Y_AXIS));
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
	}
	public void createAndAddTextFields() {
		f1=new JTextField("a1*x^p1+a2*x^p2+...an*x^pn ");
		f1.setFont(new Font("TimesRoman", Font.PLAIN, 44));
		f2=new JTextField("c1*x^q1+c2*x^q2+...cn*x^qn ");
		f2.setFont(new Font("TimesRoman", Font.PLAIN, 44));
		f3=new JTextField("Polinomul rezultat aici             ");
		f3.setFont(new Font("TimesRoman", Font.PLAIN, 44));
		panel1.add(f1);
		panel2.add(f2);
		panel3.add(f3);
	}
	public void addMainPanel1()
	{
		mainPanel1.add(panel1);
		mainPanel1.add(panel2);
		mainPanel1.add(panel3);
		mainPanel.add(mainPanel1);
	}
	public void createAndAddButtons() {
		plus=new JButton("+ ");
		plus.setFont((new Font("TimesRoman", Font.PLAIN,20)));
		minus=new JButton("-  ");
		minus.setFont((new Font("TimesRoman", Font.PLAIN,20)));
		mul=new JButton("* ");
		mul.setFont((new Font("TimesRoman", Font.PLAIN,20)));
		div=new JButton("/  ");
		div.setFont((new Font("TimesRoman", Font.PLAIN,20)));
		deriv=new JButton("()'");//\u222b
		deriv.setFont((new Font("TimesRoman", Font.PLAIN,20)));
		integ=new JButton("\u222b ");//\u2202
		integ.setFont((new Font("TimesRoman", Font.PLAIN,20)));
		mainPanel2.add(plus);
		mainPanel2.add(minus);
		mainPanel2.add(mul);
		mainPanel2.add(div);
		mainPanel2.add(deriv);
		mainPanel2.add(integ);
	}
//Getters 
	public JTextField getF1() {
		return f1;
	}
	public JTextField getF2() {
		return f2;
	}
	public JTextField getF3() {
		return f3;
	}
	public JButton getPlus() {
		return plus;
	}
	public JButton getMinus() {
		return minus;
	}
	public JButton getMul() {
		return mul;
	}

	public JButton getDiv() {
		return div;
	}

	public JButton getDeriv() {
		return deriv;
	}

	public JButton getInteg() {
		return integ;
	}
	public void addButtonListener(JButton a,ActionListener b)
	{
		a.addActionListener(b);
	}
}
