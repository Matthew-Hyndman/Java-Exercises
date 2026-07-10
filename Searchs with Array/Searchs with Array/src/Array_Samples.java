

public class Array_Samples {
    
    private int[] array_str;

    public Array_Samples(int size) {
        array_str = new int[size];

        for (int i = 0; i < size; i++) {
            array_str[i] = i + 1;
        }
        
    }

    public int[] getArray() {
        return array_str;
    }

}
