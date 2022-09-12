package Array;


public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] temp = {1, 3, 4, 6, 2};
        int ContainerSize = 0;

        for (int i=0; i<temp.length; ++i) {
            for (int j=0; j<temp.length; ++j) {

                if (i>j && i!=j) {

                    if (ContainerSize < temp[j] * j && temp[i] > temp[j]) {
                        ContainerSize = temp[j] * j;
                    } else if (ContainerSize < temp[i] * j) {
                        ContainerSize = temp[i] * j;
                    }

                }
            }
        }

        System.out.println(ContainerSize);
    }
}
