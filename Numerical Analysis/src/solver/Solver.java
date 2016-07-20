package solver;

public interface Solver {

	// 方程式
	double f(double x);
	double df(double x);

	// 反復式
	double iterFunc(double xk);
	double iterFunc(double xk, double xk1);

	// 終了条件
	boolean stop();

	// 計算
	void solve(double x0);
	void solve(double x0, double x1);
}
