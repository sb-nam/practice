package utils;

// add get remove, change
public class MyIntArrayList {

    public int length = 0;
    private int[] array;
    private int nowPosition = 0;

    public MyIntArrayList(int defaultSize) {
        array = new int[defaultSize];
    }

    public void add(int value) {
        if(isSpaceAvailable()) {
            inputToArray(value);
        } else {
            copyBeforeArrayToNewArray();
            inputToArray(value);
        }
    }

    public int get(int index) {
        if(index < array.length) { // o
            return array[index]; // before
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public void remove(int index) {
        int arrayLength = array.length;
        for(int i=index; i<arrayLength; i++) {
            int nextIndex = i+1;
            if(nextIndex < arrayLength) {
                array[i] = array[nextIndex];
            } else {
                array[i] = 0;
            }
        }

        nowPosition--;
        refreshLength();
    }

    public void change(int index, int value) {
        try {
            array[index] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("invalid index");
        } catch (Exception e) {
            System.out.println("unknown error");
        }
    }

    private boolean isSpaceAvailable() {
        return nowPosition < array.length;
    }

    private void inputToArray(int value) {
        array[nowPosition] = value;
        nowPosition++;
        refreshLength();
    }

    private void copyBeforeArrayToNewArray() {
        int[] beforeArray = array;

        int lengthOfBeforeArray = beforeArray.length;
        int[] newArray = new int[lengthOfBeforeArray * 2];

        for(int i=0; i<beforeArray.length; i++) {
            newArray[i] = beforeArray[i];
        }

        array = newArray;
    }

    private void refreshLength() {
        length = nowPosition;
    }

}
