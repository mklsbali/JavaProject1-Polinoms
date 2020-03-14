package ro.tucn.tp.assig1.model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ro.tucn.tp.assig1.interfaca.Window;
import ro.tucn.tp.assig1.model.Operatii;
//import ro.tucn.tp.assig1.testing.AllTests;
public class Test {
	private Window w;
	public Test()
	{
		w=new Window();
		w.addButtonListener(w.getPlus(),new PlusListener());
		w.addButtonListener(w.getMinus(),new MinusListener());
		w.addButtonListener(w.getMul(),new MulListener());
		w.addButtonListener(w.getDiv(),new DivListener());
		w.addButtonListener(w.getDeriv(),new DerivListener());
		w.addButtonListener(w.getInteg(),new IntegListener());
	}
	private class PlusListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String pol1=w.getF1().getText();
			pol1=pol1.replaceAll(" ","");
			String pol2=w.getF2().getText();
			pol2=pol2.replaceAll(" ","");
			try {
				Polinom p1=Operatii.prelucrareString(pol1);
				Polinom p2=Operatii.prelucrareString(pol2);
				Polinom p3=Operatii.addP(p1, p2);
				String rez=Operatii.convPolToString(p3);
				w.getF3().setText(rez);
			}catch(Exception e1) {
				w.getF3().setText("Incorrect input");
			}
			
		}
		
	}
	private class MinusListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String pol1=w.getF1().getText();
			pol1=pol1.replaceAll(" ","");
			String pol2=w.getF2().getText();
			pol2=pol2.replaceAll(" ","");
			try {
				Polinom p1=Operatii.prelucrareString(pol1);
				Polinom p2=Operatii.prelucrareString(pol2);
				Polinom p3=Operatii.scadP(p1, p2);
				String rez=Operatii.convPolToString(p3);
				w.getF3().setText(rez);
			}catch (Exception e1) {
				w.getF3().setText("Incorrect input");
			}
			
			
		}
		
	}
	private class MulListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String pol1=w.getF1().getText();
			pol1=pol1.replaceAll(" ","");
			String pol2=w.getF2().getText();
			pol2=pol2.replaceAll(" ","");
			try {
				Polinom p1=Operatii.prelucrareString(pol1);
				Polinom p2=Operatii.prelucrareString(pol2);
				Polinom p3=Operatii.polMul(p1, p2);
				String rez=Operatii.convPolToString(p3);
				w.getF3().setText(rez);
			}catch(Exception e1) {
				w.getF3().setText("Incorrect input");
			}
		
			
		}
		
	}
	private class DivListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String pol1=w.getF1().getText();
			pol1=pol1.replaceAll(" ","");
			String pol2=w.getF2().getText();
			pol2=pol2.replaceAll(" ","");
			try {
				Polinom p1=Operatii.prelucrareString(pol1);
				Polinom p2=Operatii.prelucrareString(pol2);
				String p3=Operatii.polDiv(p1, p2);
				w.getF3().setText(p3);
			}catch(Exception e1) {
				w.getF3().setText("Incorrect input");
			}
			
			
		}
		
	}
	private class DerivListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String pol1=w.getF1().getText();
			pol1=pol1.replaceAll(" ","");
			try {
				Polinom p1=Operatii.prelucrareString(pol1);
				Polinom p3=Operatii.derivare(p1);
				String rez=Operatii.convPolToString(p3);
				if (rez.equals("0.0*x^0"))
				{
					w.getF3().setText("0");
					return;
				}
					
				if (rez.substring(rez.length()-7, rez.length()).equals("0.0*x^0"))
					rez=rez.substring(0, rez.length()-8);
				w.getF3().setText(rez);
			}catch (Exception e1) {
				w.getF3().setText("Incorrect input");
			}
			
			
		}
		
	}
	private class IntegListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String pol1=w.getF1().getText();
			pol1=pol1.replaceAll(" ","");
			try {
				Polinom p1=Operatii.prelucrareString(pol1);
				Polinom p3=Operatii.integrare(p1);
				String rez=Operatii.convPolToString(p3);
				System.out.println(rez);
				w.getF3().setText(rez);
			}catch(Exception e1) {
				w.getF3().setText("Incorrect input");
				e1.printStackTrace();
			}
		}
	}
	public static void main(String args[]) {
	@SuppressWarnings("unused")
	Test t=new Test();

	}
}
