package array;

/*
    int[] nums = [...]; // Input array
    int val = ...; // Value to remove
    int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

    int k = removeElement(nums, val); // Calls your implementation

    assert k == expectedNums.length;
    sort(nums, 0, k); // Sort the first k elements of nums
    for (int i = 0; i < actualLength; i++) {
        assert nums[i] == expectedNums[i];
    }
*
* */

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3,1,2,3};
        int val = 3;

        int i = removeElement(nums, val);
        System.out.println(i);


    }

    public static int removeElement(int[] nums, int val) {

        int count = 0;

        /*
            val = 3;
            nums[0] == 3 ? X
            nums[0] = 1 (nums[0])
            {1,2,3,1,2,3,1,2,3};

            count = 1
            nums[1] = 3 ? X
            nums[1] = 2 (nums[1])
            {1,2,3,1,2,3,1,2,3};

            count = 2
            nums[2] = 3 ? O


            nums[2] = 3? X
            nums[2] = 1 (nums[3])
            {1,2,1,1,2,3,1,2,3};


            count = 3
            nums[3] = 3? X
            nums[3] = 2 (nums[4])
            {1,2,1,2,2,3,1,2,3};


            count = 4
            nums[4] = 3? X
            nums[4] = 3 (nums[5])
            {1,2,1,2,3,3,1,2,3};

        */

        for (int i=0; i<nums.length; ++i) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }



        return count;

    }
}
