package ro.tucn.tp.assig1.model;

import java.util.Collections;


public class Operatii {
	
	static int max(int a,int b)
	{
		return a>=b?a:b;
	}
	static Polinom polinomSort(Polinom p) {
		Collections.sort(p.getPolinom());
		return p;
	}
	static Polinom removeZeroes(Polinom p)
	{
		Polinom rez=new Polinom();
		for (Monom m:p.getPolinom())
		{
			if (m.getCoeficient()!=0)
				rez.getPolinom().add(m);
		}
		return rez;
	}
	static Polinom simplificare(Polinom p) {
		Polinom rez=new Polinom();
		polinomSort(p);
		for (int i=0;i<p.getPolinom().size();i++)
		{
			Monom m=p.getPolinom().get(i);
			int rezSize=rez.getPolinom().size();
			if (rezSize==0 || rez.getPolinom().get(rezSize-1).getGrad()!=m.getGrad())
				rez.getPolinom().add(p.getPolinom().get(i));
			else
				rez.getPolinom().get(rezSize-1).setCoeficient(rez.getPolinom().get(rezSize-1).getCoeficient()+m.getCoeficient());				
		}
		return rez;	
			
	}
	public static Polinom addP(Polinom p1,Polinom p2)
	{
		polinomSort(p1);
		polinomSort(p2);
		Polinom rez=new Polinom();
		int grad=max(p1.getPolinom().get(0).getGrad(),p2.getPolinom().get(0).getGrad());
		for (int i=grad;i>=0;i--)
		{
			rez.getPolinom().add(new Monom(0,i));
		}
		for (Monom m:rez.getPolinom())
		{
			for (Monom n:p1.getPolinom())
			{
				if (m.getGrad()==n.getGrad())
				{
					m.setCoeficient(m.getCoeficient()+n.getCoeficient());
				}
			}
			for (Monom n:p2.getPolinom())
			{
				if (m.getGrad()==n.getGrad())
				{
					m.setCoeficient(m.getCoeficient()+n.getCoeficient());
				}
			}
		}
		rez=removeZeroes(rez);
		return rez;
	}
	
	public static Polinom scadP(Polinom p1,Polinom p2)
	{
		Polinom rez=new Polinom();
		int grad=max(p1.getPolinom().get(0).getGrad(),p2.getPolinom().get(0).getGrad());
		for (int i=grad;i>=0;i--)
		{
			rez.getPolinom().add(new Monom(0,i));
		}
		for (Monom m:rez.getPolinom())
		{
			for (Monom n:p1.getPolinom())
			{
				if (m.getGrad()==n.getGrad())
				{
					m.setCoeficient(m.getCoeficient()+n.getCoeficient());
				}
			}
			for (Monom n:p2.getPolinom())
			{
				if (m.getGrad()==n.getGrad())
				{
					m.setCoeficient(m.getCoeficient()-n.getCoeficient());
				}
			}
		}
		rez=removeZeroes(rez);
		return rez;

	}
	public static Polinom polMul(Polinom p1,Polinom p2)
	{
		Polinom rez=new Polinom();
		polinomSort(p1);
		polinomSort(p2);
		for (Monom m:p1.getPolinom()) {
			for (Monom n:p2.getPolinom())
			{
				rez.getPolinom().add(new Monom(m.getCoeficient()*n.getCoeficient(),m.getGrad()+n.getGrad()));
			}
		}
		rez=simplificare(rez);
		return rez;
	}
	public static String polDiv(Polinom p1,Polinom p2){
		if (p1.getPolinom().get(0).getGrad()>=p2.getPolinom().get(0).getGrad())
		{
			Polinom rez=new Polinom();
			Polinom rest=new Polinom();
			Monom first=p1.getPolinom().get(0);
			Monom second=p2.getPolinom().get(0);
			Monom m=new Monom(first.getCoeficient()/second.getCoeficient(),first.getGrad()-second.getGrad());//elso hanyados
			Polinom aux=new Polinom();
			aux.getPolinom().add(m);
			rest=scadP(p1,polMul(aux, p2));
			
			rez.getPolinom().add(m);
			if (rest.getPolinom().size()==0)
				return ("Cat:"+convPolToString(rez));
			while (rest.getPolinom().get(0).getGrad()>=p2.getPolinom().get(0).getGrad())
			{
				first=rest.getPolinom().get(0);
				m=new Monom(first.getCoeficient()/second.getCoeficient(),first.getGrad()-second.getGrad());
				aux.getPolinom().remove(0);
				aux.getPolinom().add(m);
				rest=scadP(rest, polMul(aux, p2));
				rez.getPolinom().add(m);
			}
			if (rest.getPolinom().get(0).getCoeficient()==0)
				rest=null;
			return ("Cat:"+convPolToString(rez)+" Rest:"+convPolToString(rest));
		}
		else
			return null;
	}
	public static Polinom derivare(Polinom p){
		Polinom rez=new Polinom();
		for (Monom m:p.getPolinom())
		{
			if( m.getGrad()==0)
			{
				rez.getPolinom().add(new Monom(0,0));
				break;
			}
			rez.getPolinom().add(new Monom(m.getCoeficient()*m.getGrad(),m.getGrad()-1));
			simplificare(rez);
		}
		return rez;
	}
	public static Polinom integrare(Polinom p){
		Polinom rez=new Polinom();
		for (Monom m:p.getPolinom())
		{
			rez.getPolinom().add(new Monom(m.getCoeficient()/(m.getGrad()+1),m.getGrad()+1));
			simplificare(rez);
		}
		return rez;
	}
	static Polinom prelucrareString(String s)
	{
		Polinom p=new Polinom();
		int i=0;
		String coef="";
		String grad="";
		while (i<s.length())
		{
			
			if (s.substring(i, i+3).equals("*x^"))
			{
				i+=3;
				if (s.charAt(i)=='-')
				{
					grad="-";
					i++;
				}	
				while (s.charAt(i)!='+'&&s.charAt(i)!='-')
				{
					grad=grad+s.charAt(i);
					i++;
					if (i==s.length())
						break;
				}
				p.getPolinom().add(new Monom(Float.parseFloat(coef),Integer.parseInt(grad)));
				if(i<s.length())
				{
					if (s.charAt(i)=='-')
						coef=""+'-';
					else
						coef="";
				}
				grad="";			
				i++;	
			}
			else
			{
				coef=coef+s.charAt(i);
				i++;
			}
		}
		return p;
	}
	public static String convPolToString(Polinom p) {
		String s="";
		for (Monom m:p.getPolinom())
		{
			if (m.getCoeficient()<0)
				s+="("+m.getCoeficient()+")";
			else
				s+=m.getCoeficient();
			s+="*x^";
			if (m.getGrad()<0)
			{
				s+="("+m.getGrad()+")";
			}
			else
			{
				s+=m.getGrad();
			}
			s+="+";
		}
		s=s.substring(0, s.length()-1);
		return s;
	}
/*	static boolean isequal(Polinom p1,Polinom p2) {
		polinomSort(p1);
		polinomSort(p2);
	}*/
}
