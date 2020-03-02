import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

/*
 * 874. Walking Robot Simulation
 * 模拟行走机器人
 */
public class LeetCode_874_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] c = { 1,2,-2,5,-1,-2,-1,8,3,-1,9,4,-2,3,2,4,3,9,2,-1,-1,-2,1,3,-2,4,1,4,-1,1,9,-1,-2,5,-1,5,5,-2,6,6,7,7,2,8,9,-1,7,4,6,9,9,9,-1,5,1,3,3,-1,5,9,7,4,8,-1,-2,1,3,2,9,3,-1,-2,8,8,7,5,-2,6,8,4,6,2,7,2,-1,7,-2,3,3,2,-2,6,9,8,1,-2,-1,1,4,7 };
		int[][] o = { {-57,-58},{-72,91},{-55,35},{-20,29},{51,70},{-61,88},{-62,99},{52,17},{-75,-32},{91,-22},{54,33},{-45,-59},{47,-48},{53,-98},{-91,83},{81,12},{-34,-90},{-79,-82},{-15,-86},{-24,66},{-35,35},{3,31},{87,93},{2,-19},{87,-93},{24,-10},{84,-53},{86,87},{-88,-18},{-51,89},{96,66},{-77,-94},{-39,-1},{89,51},{-23,-72},{27,24},{53,-80},{52,-33},{32,4},{78,-55},{-25,18},{-23,47},{79,-5},{-23,-22},{14,-25},{-11,69},{63,36}};
		LeetCode_874_569 main = new LeetCode_874_569();
		int result = main.new Solution().robotSim(c, o);
		System.out.println( result );

	}



	class Solution {
		
	    class Position {
	    	int x;
	    	int y;
	    	
	    	Position( int x, int y ) {
	    		this.x = x;
	    		this.y = y;
	    	}
	    }
	    
	    void createXYMap( Map<Integer, List<Position>> xMap, Map<Integer, List<Position>> yMap, int[][] obstacles )	{
			for (int[] obstacle: obstacles) {
	        	Position p = new Position(obstacle[0], obstacle[1]);
	            if ( xMap.get(p.x) == null )
	            	xMap.put(p.x, new ArrayList<Position>(10));
	            xMap.get(p.x).add(p);
	            if( yMap.get(p.y) == null )
	            	yMap.put(p.y, new ArrayList<Position>(10));
	            yMap.get(p.y).add(p);
	        }
		}
		
		void sortXYMap(Map<Integer, List<Position>> xMap, Map<Integer, List<Position>> yMap) {
			for( List<Position> xList: xMap.values() ) {
	        	xList.sort( new Comparator<Position>() {
					public int compare(Position o1, Position o2) {
						if( o1.y < o2.y )
							return -1;
						else if( o1.y == o2.y )
							return 0;
						else					
							return 1;
					}	        		
	        	} );
	        }
	        for( List<Position> yList: yMap.values()) {
	        	yList.sort( new Comparator<Position>() {
					public int compare(Position o1, Position o2) {
						if( o1.x < o2.x )
							return -1;
						else if( o1.x == o2.x )
							return 0;
						else					
							return 1;
					}	        		
	        	} );
	        }
		}
		
		void getNextPosition(Position pos, int dx, int dy, int steps, Map<Integer, List<Position>> xMap, Map<Integer, List<Position>> yMap ) {
			if( dx != 0 )
				getObstacleXPosition( pos, dx, steps, yMap );
			if( dy != 0 )
				getObstacleYPosition( pos,dy, steps, xMap );
		}
		
		//查找可以优化，getObstacleXPosition/getObstacleYPosition方法可以简化，但是事多，不想动了
		void getObstacleXPosition(Position pos, int dx, int steps, Map<Integer, List<Position>> yMap ) {
			List<Position> xObs = yMap.get(pos.y);
			if( dx > 0 ) {//向右走
				if( xObs != null ) {
					for( Position ob: xObs ) {
						if( pos.x < ob.x && pos.x + steps >= ob.x) {
							pos.x = ob.x - 1;
							return;
						}						
					}
				}
				pos.x += steps;
			}else { //向左走
				if( xObs != null ) {
					for( int i = xObs.size() - 1; i >= 0; i-- ) {
						if( pos.x > xObs.get(i).x && pos.x - steps <= xObs.get(i).x ) {
							pos.x = xObs.get(i).x + 1;
							return;
						}						
					}
				}
				pos.x -= steps;
			}
		}
		
		void getObstacleYPosition(Position pos, int dy, int steps, Map<Integer, List<Position>> xMap ) {
			List<Position> yObs = xMap.get(pos.x);
			if( dy > 0 ) {//向上走
				if( yObs != null ) {
					for( Position ob: yObs ) {
						if( pos.y < ob.y && pos.y + steps >= ob.y) {
							pos.y = ob.y - 1;
							return;
						}						
					}
				}
				pos.y += steps;
			}else { //向下走
				if( yObs != null ) {
					for( int i = yObs.size() - 1; i >= 0; i-- ) {
						if( pos.y > yObs.get(i).y && pos.y - steps <= yObs.get(i).y ) {
							pos.y = yObs.get(i).y + 1;
							return;
						}						
					}
				}
				pos.y -= steps;
			}
		}
		
		
	    public int robotSim(int[] commands, int[][] obstacles) {
	        int[] dx = new int[]{0, 1, 0, -1};
	        int[] dy = new int[]{1, 0, -1, 0};
	        int di = 0;
        
	        Map<Integer, List<Position>> xMap = new HashMap<Integer, List<Position>>();
	        Map<Integer, List<Position>> yMap = new HashMap<Integer, List<Position>>();	        
	        createXYMap( xMap, yMap, obstacles);
	        sortXYMap( xMap, yMap );        

	        int ans = 0;
	        
	        Position currentPos = new Position(0,0);
	        for (int cmd: commands) {
	            if (cmd == -2)  //left
	                di = (di + 3) % 4;
	            else if (cmd == -1)  //right
	                di = (di + 1) % 4;
	            else {
	            	getNextPosition( currentPos,  dx[di],  dy[di],  cmd, xMap,  yMap ) ;
	            	ans = Math.max(ans, currentPos.x * currentPos.x + currentPos.y*currentPos.y);	            	
	            }
	        }
	        
	        return ans;
	    }
	}
}
