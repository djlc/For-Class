package function;

import var.*;

public class ConstFunction extends MathFunction {
	
	public MathVar num;
	
	public ConstFunction(MathVar value) {
		super("");
		this.num = value;
	}
	
	public ConstFunction(int value) {
		this(new Z(value));
	}

	public ConstFunction(double value) {
		this(new R(value));
	}
	
	@Override
	public MathVar f(MathVar arg) {
		return num;
	}

	@Override
	public Monomial D() {
		return new Monomial(0, new ConstFunction(0));
	}

	@Override
	public void print() {
	}

	@Override
	public MathFunction clone() {
		return null;
	}

	@Override
	public MathVar getValue(MathVar value) {
		return num;
	}

}
