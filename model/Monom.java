package ro.tucn.tp.assig1.model;

public class Monom implements Comparable<Monom>{
	private float coeficient;
	private int grad;
	
	public Monom(float coeficient, int grad) {
		super();
		this.coeficient = coeficient;
		this.grad = grad;
	}
	
	public float getCoeficient() {
		return coeficient;
	}
	public void setCoeficient(float coeficient) {
		this.coeficient = coeficient;
	}
	public int getGrad() {
		return grad;
	}
	public void setGrad(int grad) {
		this.grad = grad;
	}

	public int compareTo(Monom o) {
		if (getGrad()>o.getGrad())
			return -1;
		else if (getGrad()==o.getGrad())
			return 0;
		else return 1;
		
	}

}
