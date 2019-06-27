/**
 * 1 ~ 100까지 더하고, 그 결과를 call back interface 로 전달한다.

 */

public class NamThread extends Thread {

    private NamThreadCallback namThreadCallback; // 최초 null

    // 이 함수를 통해 namThreadCallback 연결
    public void setNamThreadCallback(NamThreadCallback callback) {
        namThreadCallback = callback ;

    }

    // start() 함수 호출시 run() 함수가 호출됨
    // 만약, start 가 아닌 run() 을 호출하면
    // Work Thread 가 아닌 Main Thread 에서 동작됨
    @Override
    public void run() {
        int sumResult = 0;

        for (int i = 1; i <= 100; i++) { // 1~100 까지 더하는 반복문
            sumResult += i;
        }

        // 만약 이 조건문을 확인하지 않는다면
        // setNamThreadCallback 함수 호출되지 않았을 때
        // NullPointerException 발생함
        if (namThreadCallback != null) {
            namThreadCallback.onSumResult(sumResult); // 호출
        }
    }
}
