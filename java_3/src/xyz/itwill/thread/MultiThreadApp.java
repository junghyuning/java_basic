package xyz.itwill.thread;


public class MultiThreadApp {
	//JVM에 의해 main 스레드 생성 -> main() 호출 -> main()내 명령 수행
	
//	프로그램 개발자가 스레드를 생성 - 명령실행하는 방법
//	1. Thread 클래스를 상속받는 자식 class 작성.
//	2. 자식클래스에서 run()메서드 오버라이드 선언
//	3. Thread클래스를 상속받은 자식클래스로 객체 생성 - Thread(부모클래스) 객체 생성
//	4. Thread 객체로 start() 메서드 호출 - Thread 객체 이용하여 새로운 스레드 생성. -> 생성된 스레드는 자동으로 Thread 객체의 run() 메서드 호출 및 실행
	public static void main(String[] args) throws InterruptedException {  // main스레드 (Thread1)
		
//		MultiThreadOne one = new MultiThreadOne(); // 스레드 객체 생성 (스레드생성x)
//		
//		one.start();
//		=> 아래와같이 나타내는것이 변수를 사용하지 않아 효율적.
//		=>if one.start()를 두번 작성하면 어떨까? => one은 참조변수이며, 스레드객체 자체는 1번만 생성하였으므로 error발생함.
//		new MultiThreadOne().start();//Thread2
//		new MultiThreadOne().start();//Thread3
//		
//		
//		//if 자식클래스가 아닌 Thread 클래스의 객체 thread 이용하여 thread.start() 수행한다면?
//		// 컴파일에러x but run() 메서드가 비어있는 추상메서드이므로 실행할 내용이 없음.
//		// 따라서 run()메서드를 오버라이드한 자손 메서드를 통해 start() 호출해야함.
		for(char i='A';i<='Z';i++) {
			System.out.print(i);
			Thread.sleep(500);
		}
		
//		CASE 1 : 
		Runnable runnable = new MultiThreadTwo();
		Thread thread = new Thread(runnable);
		thread.start();
		
//		OR CASE 2 :
		Thread thread2 = new Thread(new MultiThreadTwo());
		thread2.start();
		
//		OR CASE 3:
		new Thread(new MultiThreadTwo()).start();
		
		
	}
}
