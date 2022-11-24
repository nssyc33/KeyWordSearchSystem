package Spring.io.groundSystem.ZPractice.Java.Pattern.TempleteMethod;

public class TestMain {
	public static void main(String[] args) {
		Case1 c1 = new Case1();
		Case2 c2 = new Case2();
		c1.fn_call();
		c2.fn_call();
		
		CaseTemplete ct1 = new Case1Templete();
		CaseTemplete ct2 = new Case2Templete();
		ct1.fn_call();
		ct2.fn_call();
		
		CaseTemplete act1 = new CaseTemplete() {
			@Override
			public void excutes() {
				System.out.println("processing Case1");
			}
		};
		CaseTemplete act2 = new CaseTemplete() {
			@Override
			public void excutes() {
				System.out.println("processing Case2");
			}
		};
		act1.fn_call();
		act2.fn_call();
	}
}
