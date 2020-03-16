package G20200343030379;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  874. 模拟行走机器人
 *
 *  机器人在一个无限大小的网格上行走，从点?(0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *
 * -2：向左转?90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动?x?个单位长度
 * 在网格上有一些格子被视为障碍物。
 *
 * 第 i?个障碍物位于网格点 ?(obstacles[i][0], obstacles[i][1])
 *
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *
 * 返回从原点到机器人的最大欧式距离的平方。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 示例?2：
 *
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 * ?
 *
 * 提示：
 *
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于?2 ^ 31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  优秀题解：
 *  https://leetcode-cn.com/problems/walking-robot-simulation/solution/mo-ni-xing-zou-ji-qi-ren-by-gpe3dbjds1/
 *  https://leetcode.com/problems/walking-robot-simulation/discuss/152412/Concise-JavaScript-solution
 *
 *
 *  注意点“必须注意使用 集合 Set 作为对障碍物使用的数据结构，以便我们可以有效地检查下一步是否受阻。
 *  如果不这样做，我们检查 该点是障碍点吗 可能会慢大约 10000 倍。
 *
 */



public class LeetCode_874_379 {

    /**
     * 执行用时 : 18 ms , 在所有 Java 提交中击败了 92.95% 的用户
     * 内存消耗 : 51.2 MB , 在所有 Java 提交中击败了 96.15% 的用户
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        //每个方向的增量,以这个方向为准，北 东 南 西
        int dx[]={0,1,0,-1};
        int dy[]={1,0,-1,0};

        //机器人坐标
        int x=0,y=0;
        //坐标标识
        int di=0;
        int maxValue=0;

        //把障碍存到set集合，方便匹配
        //obstacles[i][] i表示第几个， obstacles[i][0] x轴 ,obstacles[i][1] y轴
        //由于x轴可能存在多个y轴的值，所以存储可以使用 Map<Integer,Set<Integer>> 结果存储，key:x轴，value：y轴列表
        Map<Integer,Set<Integer>> obstaceleMap=new HashMap<>();
        for (int i = 0; i < obstacles.length; i++) {
            //x坐标
            int ox=obstacles[i][0];
            //y坐标
            int oy=obstacles[i][1];
            if(!obstaceleMap.containsKey(ox)){
                HashSet<Integer> set = new HashSet<>();
                set.add(oy);
                obstaceleMap.put(ox,set);
            }else{
                obstaceleMap.get(ox).add(oy);
            }
        }


        //-2 向左 ， -1 向右 ， n 向前步行
        for (int command : commands) {
            if(command==-2){
                //获取坐标
                di=(di+3)%4;
            }else if(command==-1){
                //获取坐标
                di=(di+1)%4;
            }else{//前进方向
                //需要一步一步前进，方便判断是否存在障碍
                for (int n = 0; n < command; n++) {
                    //获取当前方向的增量,再原坐标进行累加，就是所谓的行动
                    x+=dx[di];
                    y+=dy[di];

                    //判断是否是障碍，是障碍不执行
                    //obstaceleMap.get(x) 的值是一个y轴的集合
                    if(obstaceleMap.containsKey(x) && obstaceleMap.get(x).contains(y)){
                        //退回原来的位置
                        x-=dx[di];
                        y-=dy[di];
                        //System.out.println("遇到障碍，停止前进，x y"+x+"__"+y);
                        break;
                    }

                    //System.out.println(x+"___"+y+"_____"+(x*x+y*y));

                    //返回从原点到机器人的最大欧式距离的平方。所以每一步都必须随时计算最大值
                    maxValue=Math.max(maxValue,x*x+y*y);
                }
            }
        }
        return maxValue;
    }


    /**
     * 自己重新练一遍
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim2(int[] commands, int[][] obstacles) {
        //北东南西
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};

        int x=0,y=0;
        int di=0;
        int maxvale=0;
        Map<Integer,Set<Integer>> obstaceleMap=new HashMap<>();
        for (int i = 0; i < obstacles.length; i++) {
            int ox=obstacles[i][0];
            int oy=obstacles[i][1];

            if(!obstaceleMap.containsKey(ox)){
                Set<Integer> set=new HashSet<>();
                set.add(oy);
                obstaceleMap.put(ox,set);

            }else{
                obstaceleMap.get(ox).add(oy);
            }

        }

        for (int command : commands) {
            if(command==-2){
                di=(di+3)%4;
            }else if(command==-1){
                di=(di+1)%4;
            }else{
                for (int i = 0; i < command; i++) {
                    x+=dx[di];
                    y+=dy[di];

                    if(obstaceleMap.containsKey(x)  && obstaceleMap.get(x).contains(y)){
                        x-=dx[di];
                        y-=dy[di];
                        break;
                    }
                    maxvale=Math.max(maxvale,x*x+y*y);
                }

            }
        }
        return maxvale;
    }

}
