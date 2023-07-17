package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

/**
 * 메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다.
 * 지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다.
 * 지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며,
 * 격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다.
 *
 * 지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다. 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다. 지도의 각 칸에 적힌 숫자는 식량을 나타내는데, 상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냅니다. 어떤 섬으로 놀러 갈지 못 정한 메리는 우선 각 섬에서 최대 며칠씩 머물 수 있는지 알아본 후 놀러갈 섬을 결정하려 합니다.
 *
 * 지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때, 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요. 만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.
 *
 * [예시]
 * ["X591X","X1X5X","X231X", "1XXX1"]
 *
 * [
 *  [X, 5, 9, 1, X]
 *  [X, 1, X, 5, X]
 *  [X, 2, 3, 1, X]
 *  [1, X, X, X, 1]
 *  ]
 *
 * [풀이]
 * [][] 이렇게 있을 때 y와 x축 모두 순서대로 돈다고 치면 위와 좌측만 확인하면 될 듯.
 *
 * 1. 주어진 값을 이차원 배열로 만든다.
 * 2. 이차원 배열을 순회하면서 이어진 것 끼리는 무조건 하나의 map에 묶어준다.
 *  - 어차피 모든 값을 순회하기 때문에 왼쪽과 위쪽만 확인하면 된다.
 *      - 값이 x일 시 재끼고 아니면 좌표값을 map의 value에 추가해줄 것.
 *          - key값을 점진적으로 늘려주기 위해 포인터를 선언해준다
 *      - 값이 x가 아닐 시
 *          - x, y값 모두 0일 시
 *             - 그냥 map에 넣고 key는 하나 플러스
 *          - 만약 x값만 0일 시
 *              - x-1 값은 확인하지 않는다.
 *          - 만약 y값만 0일 시
 *              - y-1값은 확인하지 않는다
 *          - x, y 모두 값이 0이 아닐 시
 *              - x-1에만 값이 있을 시
 *                  - value중 x-1 위치를 value를 넣는다.
 *              - y-1에만 값이 있을 시
 *                  - value중 y-1 위치를 value를 넣는다.
 *              - x-1, y-1모두 값이 있을 시
 *                  - value중 x-1 위치와 y-1값을 찾아 그 둘의 키값이 같은지 확인한다.
 *                      - 같다면 그 키값에 해당 위치의 index까지 넣는다.
 *                      - 다르다면 하나의 키값에 모두 합친 후 해당 위치의 index까지 넣는다.
 *
 *
 * 3. 최종적으로 만들어진 map의 value를 해당 위치에 있는 값으로 다 더한 값을 만들어 array로 만들어준다.
 *
 */
public class 무인도여행 {

    public static void main(String[] args) {

    }

    public static int[] solution(String[] maps) {

        // 1.
        String[][] mapsList = new String[100][100];
        for(int i=0; i<maps.length; ++i) {
            mapsList[i] = maps[i].split("");
        }

        // 2.
        int mapsPointer = 0;
        Map<Integer, String> mapsMap = new HashMap<>();
        //y축
        for(int y=0; y<mapsList.length; ++y) {
            //x축
            for(int x=0; x< mapsList[y].length; ++x) {
                String s = mapsList[y][x];
                if (!s.equals("X")) {

                    //x, y값 모두 0일 시
                    if (x == 0 && y == 0) {
                    mapsMap.put(mapsPointer, x+","+y);
                    ++mapsPointer;

                    //x값만 0일 시
                    } else if (x == 0) {

                        //y-1에 값이 있으면 y-1의 key값에 값을 넣는다.
                        if (!mapsList[y-1][x].equals("X")) {

                            for(Map.Entry<Integer, String> entry: mapsMap.entrySet()) {
                                if (entry.getValue().equals(x+","+(y-1))) {
                                    mapsMap.put(entry.getKey(), x+","+y);
                                }
                            }

                        //y-1에 값이 없으면
                        } else {
                            mapsMap.put(mapsPointer, x+","+y);
                            ++mapsPointer;
                        }

                    //y값만 0일 시
                    } else if (y == 0) {

                        //x-1에 값이 있으면 x-1의 key값에 값을 넣는다.
                        if (!mapsList[y][x-1].equals("X")) {

                            for(Map.Entry<Integer, String> entry: mapsMap.entrySet()) {
                                if (entry.getValue().equals(x-1+","+y)) {
                                    mapsMap.put(entry.getKey(), x+","+y);
                                }
                            }
                            //x-1에 값이 없으면
                        } else {
                            mapsMap.put(mapsPointer, x+","+y);
                            ++mapsPointer;
                        }

                    //x, y 모두 값이 0이 아닐 시
                    } else {
                        //x, y-1과 x-1, y에 값이 있을 시
                        if (!mapsList[y-1][x].equals("X")&&!mapsList[y][x-1].equals("X")) {

                            int left;
                            int top;
                            for(Map.Entry<Integer, String> entry: mapsMap.entrySet()) {

                                if (entry.getValue().equals(x+","+(y-1))) {
                                    left = entry.getKey();
                                }

                                if (entry.getValue().equals(x-1+","+y))) {
                                    top = entry.getKey();
                                }

                            }

                            if (left == top) {
                                mapsMap.put(top, x+","+y);
                            } else {
                                mapsMap.get(left);
                            }
                        } else if (!mapsList[y-1][x].equals("X")) {

                        }


                        /*
                        * - x-1에만 값이 있을 시
                         *                  - value중 x-1 위치를 value를 넣는다.
                         *              - y-1에만 값이 있을 시
                         *                  - value중 y-1 위치를 value를 넣는다.
                         *              - x-1, y-1모두 값이 있을 시
                         *                  - value중 x-1 위치와 y-1값을 찾아 그 둘의 키값이 같은지 확인한다.
                         *                      - 같다면 그 키값에 해당 위치의 index까지 넣는다.
                         *                      - 다르다면 하나의 키값에 모두 합친 후 해당 위치의 index까지 넣는다.
                        * */

                    }

                }
            }

        }




        return null;
    }

}
