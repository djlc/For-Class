package var;

public class R extends MathVar {
	public double num;
	
	public R(double num) {
		this.num = num;
	}
	
	public R(R r) {
		this(r.num);
	}

	@Override
	public void print() {
		System.out.printf("%f",num);
	}

	@Override
	public MathVar add(MathVar a) {
		if (a instanceof R) {
			R b = (R)a;
			return new R(this.num + b.num);
		}
		if (a instanceof Z) {
			Z b = (Z)a;
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
		if (a instanceof R) {
			R b = (R)a;
			return new R(this.num - b.num);
		}
		if (a instanceof Z) {
			Z b = (Z)a;
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
		if (a instanceof R) {
			R b = (R)a;
			return new R(this.num * b.num);
		}
		if (a instanceof Z) {
			Z b = (Z)a;
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
			return (b.num != 0) ? new R(this.num / b.num) : NA();
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
	public MathVar NA() {
		return new R(0);
	}

	@Override
	public double abs() {
		return Math.abs(this.num);
	}

	@Override
	public MathVar clone() {
		return new R(this.num);
	}

	@Override
	public boolean isMinus() {
		return (num < 0);
	}
}
