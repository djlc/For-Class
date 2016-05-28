package function;

import java.util.ArrayList;

import var.*;

public class Monomial {
	// coefficient
	public MathVar c;
	
	// type of function
	public ArrayList<MathFunction> f;

	public Monomial(MathVar c, MathFunction f) {
		this.c = c;
		this.f = new ArrayList<MathFunction>();
		this.f.add(f);
	}

	public Monomial(int c, MathFunction f) {
		this(new Z(c), f);
	}
	
	public Monomial(double c, MathFunction f) {
		this(new R(c), f);
	}
	
	public Monomial(MathVar c, ArrayList<MathFunction> f) {
		this.c = c;
		this.f = f;
	}
	
	public Monomial(int c, ArrayList<MathFunction> f) {
		this(new Z(c), f);
	}

	public Monomial(double c, ArrayList<MathFunction> f) {
		this(new R(c), f);
	}
	
	public Monomial(MathVar c, MathFunction[] f) {
		this.c = c;
		this.f = new ArrayList<MathFunction>(f.length);
		for (int i=0; i<f.length; i++) this.f.add(f[i]);
	}
	
	public Monomial(int c, MathFunction[] f) {
		this(new Z(c), f);
	}
	
	public Monomial(double c, MathFunction[] f) {
		this(new R(c), f);
	}
	
	public Monomial(Monomial m) {
		this(m.c.clone(), new ArrayList<MathFunction>(m.f));
	}

	public void print() {
		if (c instanceof Z) {
			if (((Z)c).num != 1 && ((Z)c).num != -1) System.out.print((int)(c.abs()));
		}
		if (c instanceof R) {
			if (((R)c).num != 1 && ((R)c).num != -1) System.out.print(c.abs());
		}
		for (int i=0; i<f.size(); i++) f.get(i).print();
	}
	
	void add(MathVar c) {
		this.c.add(c);
	}
	
	boolean isTypeEquals(Monomial m) {
		return false;
	}
	
	public Monomial clone() {
		return new Monomial(this);
	}
	
	// f(x)g(x) = f'(x)g(x) + f(x)g'(x)
	ArrayList<Monomial> D(String var) {
		ArrayList<Monomial> p = new ArrayList<Monomial>();
		for (int i=0; i<this.f.size(); i++) {
			if (f.get(i).name == var) {
				Monomial temp = this.clone();
				Monomial prime = temp.f.get(i).D();
				temp.f.set(i, prime.f.get(0));
				temp.c = temp.c.mul(prime.c);
				p.add(temp);
			}
		}
		return p;
	}
}
