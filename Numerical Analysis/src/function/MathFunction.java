package function;

import var.MathVar;

// 任意の数式で表現できる1変数関数の抽象クラス
// f : MathVar -> MathVar
abstract public class MathFunction {
	public abstract MathVar f(MathVar arg);
	public abstract Monomial D();
	public abstract void print();
	public abstract MathFunction clone();
	final String name;
	
	MathFunction(String name) {
		this.name = name;
	}
	public abstract MathVar getValue(MathVar value);
}
