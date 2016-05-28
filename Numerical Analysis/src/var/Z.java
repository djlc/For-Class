package var;

public class Z extends MathVar {
	
	public int num;
	
	public Z(int num) {
		this.num = num;
	}
	
	public Z(Z z) {
		this(z.num);
	}

	@Override
	public MathVar add(MathVar a) {
		if (a instanceof Z) {
			Z b = (Z)a;
			return new Z(this.num + b.num);
		}
		if (a instanceof R) {
			R b = (R)a;
			return new R(this.num + b.num);
		}
		if (a instanceof C) {
			C b = (C)a;
			return new C(this.num + b.re, b.im);
		}
		return null;
	}

	@Override
	public MathVar sub(MathVar a) {
		if (a instanceof Z) {
			Z b = (Z)a;
			return new Z(this.num - b.num);
		}
		if (a instanceof R) {
			R b = (R)a;
			return new R(this.num - b.num);
		}
		if (a instanceof C) {
			C b = (C)a;
			return new C(this.num - b.re, -b.im);
		}
		return null;
	}

	@Override
	public MathVar mul(MathVar a) {
		if (a instanceof Z) {
			Z b = (Z)a;
			return new Z(this.num * b.num);
		}
		if (a instanceof R) {
			R b = (R)a;
			return new R(this.num * b.num);
		}
		if (a instanceof C) {
			C b = (C)a;
			return new C(this.num * b.re, this.num * b.im);
		}
		return null;
	}

	@Override
	public MathVar div(MathVar a) {
		if (a instanceof Z) {
			Z b = (Z)a;
			return (b.num != 0) ? new Z(this.num / b.num) : NA();
		}
		if (a instanceof R) {
			R b = (R)a;
			return (b.num != 0) ? new R(this.num / b.num) : NA();
		}
		if (a instanceof C) {
			C b = (C)a;
			return (b.re * b.re + b.im * b.im != 0)
					? new C((this.num * b.re) / (b.re * b.re + b.im * b.im),
							(-this.num * b.im) / (b.re * b.re + b.im * b.im))
					: NA();
		}
		return null;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print(num);
	}

	@Override
	public MathVar NA() {
		return new Z(0);
	}

	@Override
	public double abs() {
		return Math.abs(this.num);
	}

	@Override
	public MathVar clone() {
		return new Z(this.num);
	}

	@Override
	public boolean isMinus() {
		return (num < 0);
	}

}
