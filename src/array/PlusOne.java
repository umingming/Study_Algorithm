package array;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {1, 2, 3, 4, 9};
        int[] ints = plusOne(digits);

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] plusOne(int[] digits) {

        int arraySize;
        int[] result;

        if (digits[digits.length-1] == 9) {
            result = new int[digits.length];

            for(int i=0; i< digits.length-2; ++i) {
                result[i] = digits[i];
            }

            result[result.length-2] = 1;
            result[result.length-1] = 0;

            return result;
        } else {
            result = new int[digits.length];

            for(int i=0; i< digits.length; ++i) {

                if (i==digits.length-1) {
                    result[i] = digits[i]+1;
                } else {
                    result[i] = digits[i];
                }
            }

        }

        return result;





    }

}
