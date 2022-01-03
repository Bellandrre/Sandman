import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public class BoomerangProblem {
    // Optimized
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<points.length; i++) {
            for(int j=0; j<points.length; j++) {
                if(i == j)
                    continue;

                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }

            for(int val : map.values()) {
                res += val * (val-1);
            }
            map.clear();
        }

        return res;
    }
    // Root can be avoided as squaring both sides.
    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }

    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int numberOfBoomerangsBruteForce(int[][] points) {
        ArrayList<Point> pointList = new ArrayList<>();
        int result = 0;
        // Build the point objects
        for(int i = 0 ; i < points.length ; i++){
            Point pnt = new Point(points[i][0], points[i][1]);
            pointList.add(pnt);
        }

        for(int i = 0 ; i < pointList.size() ; i++){
            Point point_1 = pointList.get(i);
            for(int j = 0; j < pointList.size(); j++){
                Point point_2 = pointList.get(j);
                if(i != j){
                    double dist_1 = Math.sqrt( ((point_2.x - point_1.x) * (point_2.x - point_1.x)) +  ((point_2.y - point_1.y) * (point_2.y - point_1.y)) );

                    for(int k = 0; k < pointList.size(); k++){
                        if(k != j && k != i ){
                            Point point_3 = pointList.get(k);
                            double dist_2 = Math.sqrt( ((point_3.x - point_1.x) * (point_3.x - point_1.x)) +  ((point_3.y - point_1.y) * (point_3.y - point_1.y)) );
                            if(dist_2 == dist_1) result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
