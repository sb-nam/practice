package utils;

public class MyArrayList<V> {

    public int length = 0;
    private V[] array;
    private int nowPosition = 0;

    public MyArrayList(int defaultSize) {
        array = (V[]) new Object[defaultSize];
    }

    public void add(V value) {
        if(isSpaceAvailable()) {
            inputToArray(value);
        } else {
            copyBeforeArrayToNewArray();
            inputToArray(value);
        }
    }

    public V get(int index) {
        if(index < array.length) {
            return array[index];
        } else {
            return null;
        }
    }

    public void remove(int index) {
        int arrayLength = array.length;
        for(int i=index; i<arrayLength; i++) {
            int nextIndex = i+1;
            if(nextIndex < arrayLength) {
                array[i] = array[nextIndex];
            } else {
                array[i] = null;
            }
        }

        nowPosition--;
        refreshLength();
    }

    public void change(int index, V value) {
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

    private void inputToArray(V value) {
        array[nowPosition] = value;
        nowPosition++;
        refreshLength();
    }

    private void copyBeforeArrayToNewArray() {
        V[] beforeArray = array;

        int lengthOfBeforeArray = beforeArray.length;
        V[] newArray = (V[]) new Object[lengthOfBeforeArray * 2];

        for(int i=0; i<beforeArray.length; i++) {
            newArray[i] = beforeArray[i];
        }

        array = newArray;
    }

    private void refreshLength() {
        length = nowPosition;
    }

}
