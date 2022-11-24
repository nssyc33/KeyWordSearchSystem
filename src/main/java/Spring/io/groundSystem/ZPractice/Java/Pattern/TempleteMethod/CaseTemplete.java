package Spring.io.groundSystem.ZPractice.Java.Pattern.TempleteMethod;

public abstract class CaseTemplete {
	public void fn_call() {
		System.out.println("start=============================");
		excutes();
		System.out.println("end=============================");
	}
	
	public abstract void excutes();
}
