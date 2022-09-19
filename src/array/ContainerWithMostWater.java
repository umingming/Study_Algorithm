package array;

/*
    [문제: ContainerWithMostWater]

    You are given an integer array height of length n.
    There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    Notice that you may not slant the container.

*/

/*
    [설계]
    1. 이중 for문을 생성한다.
    2. 이중 for문을 통해 x좌표를 1~배열의 수로 잡아주어 값을 판별한 후 돌아준다.
    3. y값은 반드시 최소값으로 돌아준다.
    4. 해당 수들을 ContainerSize 변수에 할당해주고 가장 큰 값을 판별한다.
*/
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length-1;

        while(start < end){
            max = Math.max((end-start)*Math.min(height[start], height[end]), max);
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
        }

        return max;
    }

}
