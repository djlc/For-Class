package var;

public abstract class MathVar {
	public abstract MathVar clone();
	public abstract MathVar add(MathVar a);
	public abstract MathVar sub(MathVar a);
	public abstract MathVar mul(MathVar a);
	public abstract MathVar div(MathVar a);
	public abstract double abs();
	public abstract MathVar NA();
	public abstract void print();
	public abstract boolean isMinus();
}
