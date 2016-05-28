package var;

public class C extends MathVar {

	double re, im;
	
	public C(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public C(C c) {
		this(c.re, c.im);
	}
	
	@Override
	public MathVar add(MathVar a) {
		if (a instanceof C) {
			C b = (C)a;
			return new C(this.re + b.re, this.im + b.im);
		}
		if (a instanceof R) {
			R b = (R)a;
			return new C(this.re + b.num, this.im);
		}
		if (a instanceof Z) {
			Z b = (Z)a;
			return new C(this.re + b.num, this.im);
		}
		return null;
	}

	@Override
	public MathVar sub(MathVar a) {
		if (a instanceof C) {
			C b = (C)a;
			return new C(this.re - b.re, this.im - b.im);
		}
		if (a instanceof R) {
			R b = (R)a;
			return new C(this.re - b.num, this.im);
		}
		if (a instanceof Z) {
			Z b = (Z)a;
			return new C(this.re - b.num, this.im);
		}
		return null;
	}

	@Override
	public MathVar mul(MathVar a) {
		if (a instanceof C) {
			C b = (C)a;
			return new C(this.re * b.re - this.im * b.im, this.re * b.im + this.im * b.re);
		}
		if (a instanceof R) {
			R b = (R)a;
			return new C(this.re * b.num, this.im * b.num);
		}
		if (a instanceof Z) {
			Z b = (Z)a;
			return new C(this.re * b.num, this.im * b.num);
		}
		return null;
	}

	@Override
	public MathVar div(MathVar a) {
		if (a instanceof C) {
			C b = (C)a;
			if(b.re * b.re + b.im * b.im != 0) {
				return this.mul(b.conjugate()).div(new R(b.re * b.re + b.im * b.im));
			} else {
				return NA();
			}
		}
		if (a instanceof R) {
			R b = (R)a;
			return new C(this.re / b.num, this.im / b.num);
		}
		if (a instanceof Z) {
			Z b = (Z)a;
			return new C(this.re / b.num, this.im / b.num);
		}
		return null;
	}

	public C conjugate() {
		return new C(this.re, -this.im);
	}
	
	@Override
	public MathVar NA() {
		return new C(0, 0);
	}

	@Override
	public void print() {
		if (this.im > 0) {
			System.out.printf("%f + %fi", this.re, this.im);
		} else {
			System.out.printf("%f - %fi", this.re, -this.im);
		}
	}

	@Override
	public double abs() {
		return Math.sqrt(this.re * this.re + this.im * this.im);
	}

	@Override
	public MathVar clone() {
		return new C(this);
	}

	@Override
	public boolean isMinus() {
		return false;
	}

}
