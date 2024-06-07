package it.edu.iisgubbio.geometria.oggetti;

public class Cerchio {
	double raggio;
	static final double PI_GRECO=3.14;
	public Cerchio(double raggio) {
		this.raggio=raggio;
	}
	public double calcolaArea() {
		double area = PI_GRECO * raggio * raggio;
		return area;
	}
}
