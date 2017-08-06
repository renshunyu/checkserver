package check.checkserver.test;

public class Func {
	@Timer
	public static void test(){
		try {

			Thread.sleep(234);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Timer
	public static void test1(int i){
		try {

			Thread.sleep(i);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Timer
	public static void test2(){
		try {

			Thread.sleep(568);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void yunxing(){
		Timetest tt =new Timetest();
		tt.getTime1();
	}
	

}
