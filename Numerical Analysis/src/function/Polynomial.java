package function;

import java.util.ArrayList;

import var.*;

public class Polynomial {
	private ArrayList<Monomial> p;
	
	public Polynomial(ArrayList<Monomial> p) {
		this.p = new ArrayList<Monomial>(p.size());
		this.p.addAll(p);
	}
	
	public Polynomial(Monomial[] p) {
		this.p = new ArrayList<Monomial>(p.length);
		for (int i=0; i<p.length; i++) this.p.add(p[i]);
	}
	
	public void print() {
		for (int i=0; i<p.size(); i++) {
			if (i != p.size()) {
				if (!p.get(i).c.isMinus()) {
					if (i != 0) System.out.print(" + ");
				} else {
					System.out.print(" - ");
				}
			}
			p.get(i).print();
		}
		System.out.println();
	}
	
	public void add(Polynomial p) {
		
	}
	
	public Polynomial D(String var) {
		ArrayList<Monomial> temp = new ArrayList<Monomial>(p.size());
		for (int i=0; i<p.size(); i++) {
			temp.addAll(p.get(i).D(var));
		}
		return new Polynomial(temp);
	}
	
	public Polynomial set(String var, MathVar value) {
		ArrayList<Monomial> q = new ArrayList<Monomial>(p);
		for (int i=0; i<q.size(); i++) {
			for (int j=0; j<q.get(i).f.size(); j++) {
				if (q.get(i).f.get(j).name == var) {
					q.get(i).c = q.get(i).c.mul(q.get(i).f.get(j).getValue(value));
					q.get(i).f.remove(j);
				}
			}
		}
		return new Polynomial(q);
	}

	public R getValue() {
		R sum = new R(0);
		for (int i=0; i<p.size(); i++) {
			R temp = new R(0);
			for (int j=0; j<p.get(i).f.size(); j++) {
				if (p.get(i).f.get(j) instanceof ConstFunction) {
					if (j == 1) {
						temp.add(p.get(i).f.get(j).getValue(null));
					} else {
						temp.mul(p.get(i).f.get(j).getValue(null));
					}
				}
			}
			sum.add(temp);
		}
		return sum;
	}
}
