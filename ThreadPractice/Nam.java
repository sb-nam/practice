/**
 * 1 ~ 100까지 더하는 Thread 를 만들고,
 * 2 더하는 작업이 끝나면, interface 를 통해 callback 을 받고.
 * 3 그 결과를 print 한다.
 */

public class Nam {

    public static void main(String[] args) {
        PrintUtil.println("start");

        // Thread 를 상속 받아 구현된 NamThread 인스턴스 생성
        NamThread namThread = new NamThread();

        // Thread 의 1~100 합산 결과를 전달 받기 위한 callback 객체
//        NamThreadCallback callback = new NamThreadCallback() {
//            @Override
//            public void onSumResult(int sumResult) { // 결과
//                PrintUtil.println(sumResult);
//            }
//        };

//      namThread.namThreadCallback = callback;  // <- private 을 설정 안햇을때

        // 매개변수에 바로 callback 객채를 생성
        namThread.setNamThreadCallback(new NamThreadCallback() {
            @Override
            public void onSumResult(int sumResult) { // 결과
                PrintUtil.println(sumResult);
            }
        });

        // run() 호출하면 안되고, start() 호출해야 함
        namThread.start();

        PrintUtil.println("end");
    }
}
