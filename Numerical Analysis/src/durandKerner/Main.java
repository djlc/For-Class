package durandKerner;

import function.*;
import var.*;

public class Main {

	public static void main(String[] args) {
		Polynomial p = new Polynomial(
			new Monomial[] {
				new Monomial(2, new Power[] { new Power("x", 2), new Power("y", 2), new Power("z", 2) }),
				new Monomial(7, new Power[] { new Power("x", 3), new Power("y", 3), new Power("z", 3) }),
				new Monomial(3, new Power[] { new Power("x", 4), new Power("y", 4), new Power("z", 4) })
			}
		);
		System.out.print("f(x,y,z) = "); p.print();
		
		p.set("x", new Z(2));
		p.set("y", new Z(3));
		p.set("z", new Z(1));
		p.print();
	}

}
