package ro.tucn.tp.assig1.model;

import java.util.ArrayList;



public class Polinom {
	private ArrayList <Monom> polinom; 
	public ArrayList<Monom> getPolinom() {
		return polinom;
	}

	public void setPolinom(ArrayList<Monom> polinom) {
		this.polinom = polinom;
	}

	public Polinom()
	{
		polinom=new ArrayList<Monom>();
	}
	
	public void afisarePolinom()
	{
		for (Monom m:polinom)
		{
			if (m.getGrad()==0)
				{
					System.out.println(m.getCoeficient());
					break;
				}
				if (m.getCoeficient()>0)
					System.out.print(m.getCoeficient()+"x^"+m.getGrad()+"+");
				else 
					System.out.print("("+m.getCoeficient()+")"+"x^"+m.getGrad()+"+");
		}
		
		System.out.println();
	}
	



}
