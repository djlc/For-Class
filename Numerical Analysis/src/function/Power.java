package function;

import var.*;

public class Power extends MathFunction {

	public MathVar n;
	
	public Power(String name, MathVar n) {
		super(name);
		this.n = n;
	}
	
	public Power(String name, int n) {
		super(name);
		this.n = new Z(n);
	}
	
	public Power(String name, double n) {
		super(name);
		this.n = new R(n);
	}
	
	public Power(Power p) {
		this(p.name, p.n);
	}
	
	// f(x) = a^x
	@Override
	public MathVar f(MathVar args) {
		if (args instanceof R) {
			R a = (R)args;
			R y = (R)n;
			return new R(Math.pow(a.num, y.num));
		}
		return null;
	}

	@Override
	public void print() {
		System.out.print(name);
		System.out.print("^");
		if (n.isMinus()) System.out.print("(");
		if (n instanceof R) { R y = (R)n; y.print(); }
		if (n instanceof Z) { Z y = (Z)n; y.print(); }
		if (n instanceof C) { C y = (C)n; y.print(); }
		if (n.isMinus()) System.out.print(")");
	}

	@Override
	public Monomial D() {
		// return f'(x) = n x^(n-1)
		if ((n instanceof Z && ((Z)n).num != 0) || (n instanceof R && ((R)n).num != 0)) {
			return new Monomial(this.n, new Power( this.name, n.sub(new Z(1))));
		} else {
			return new Monomial(1, new ConstFunction(0));
		}
	}

	@Override
	public MathFunction clone() {
		return new Power(this);
	}

	@Override
	public MathVar getValue(MathVar value) {
		if (n instanceof R) {
			if (value instanceof R) return new R(Math.pow(((R)value).num, ((R)n).num));
			if (value instanceof Z) return new R(Math.pow(((Z)value).num, ((R)n).num));
		}
		if (n instanceof Z) {
			if (value instanceof R) return new R(Math.pow(((R)value).num, ((Z)n).num));
			if (value instanceof Z) return new Z((int)Math.pow(((Z)value).num, ((Z)n).num));
		}
		return new R(0);
	}

}
