package jc.demo.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_874_559 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x=0,y=0;
        //0=north 1=east 2=south 3=west
        int di=0;
        int maxRoute=0;
        //将障碍的坐标位置组成字符串存到set中
        Set<String> set = new HashSet();
        for(int[] i :obstacles){
            set.add(i[0]+","+i[1]);
        }
        for(int i =0;i<commands.length;i++){
            if(commands[i]==-1){
                di=(di+1)%4;
            }
            else if(commands[i]==-2){
                di=(di+3)%4;
            }else if(commands[i]>0){
                switch (di){
                    case 0:
                        for(int j=0;j<commands[i];j++){
                            y+=1;
                            if(set.contains(x+","+y)){
                                y-=1;
                                break;
                            }
                            maxRoute=Math.max(maxRoute,x*x+y*y);
                        }
                        break;
                    case 1:
                        for(int j=0;j<commands[i];j++){
                            x+=1;
                            if(set.contains(x+","+y)){
                                x-=1;
                                break;
                            }
                            maxRoute=Math.max(maxRoute,x*x+y*y);

                        }
                        break;
                    case 2:
                        for(int j=0;j<commands[i];j++){
                            y-=1;
                            if(set.contains(x+","+y)){
                                y+=1;
                                break;
                            }
                            maxRoute=Math.max(maxRoute,x*x+y*y);

                        }
                        break;
                    case 3:
                        for(int j=0;j<commands[i];j++){
                            x-=1;
                            if(set.contains(x+","+y)){
                                x+=1;
                                break;
                            }
                            maxRoute=Math.max(maxRoute,x*x+y*y);

                        }
                        break;
                    default:break;
                }


            }
        }

        return maxRoute;
    }
}
