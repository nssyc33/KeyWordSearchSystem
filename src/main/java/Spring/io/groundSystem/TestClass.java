package Spring.io.groundSystem;

public class TestClass {
	public static void main(String[] args) {
		
		String asStr = "...t.";
		for(int i=0; i< asStr.length(); i++) {
			System.out.println("aaaaa");
		}
	
		System.out.println(asStr.contains("a"));
		System.out.println(asStr.indexOf("t")+1);
		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int N = Integer.parseInt(br.readLine());
//
//		// 난이도의 문제 받기
//		int[] questions = new int[N];
//		String str = br.readLine();
//		String[] split = str.split(" ");
//		for(int i = 0; i < N; ++i){
//			questions[i] = Integer.parseInt(split[i]);
//		}
//		
//		Integer.parseInt(str)
//		int count = 1;
//		int before = questions[0];
//		for(int i : questions){
//			if(before != i)
//				count++;
//			else if (count == 3)
//				break;
//			before = i;
//		}
//		if(count < 3)
//			System.out.print("NO");
//		else
//			System.out.print("YES");
//		
//		br.close();
	}
}
