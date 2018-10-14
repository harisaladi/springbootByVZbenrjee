
public class TestLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// single line
		Thread t = new Thread(
				() -> //{ 
					System.out.println("hii lamda")
					//}
				);
		t.start();
		
		
		// multi lines
		Thread t2 = new Thread ( () -> {
			
			for (int i=0;i<5;i++) {
				System.out.println(i);
			}
			
		});
		t2.start();
	}

}
