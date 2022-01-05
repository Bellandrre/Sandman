import java.util.HashMap;
public class BoomerangProblemRevisit {

    public static int numberOfBoomerangs(int[][] points){
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < points.length; i++){
            for(int j = 0 ; j < points.length; j++){
                if(i == j) continue;

                int distance = getDistance(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);

            }

            for(int value : map.values()){
                result += value * (value - 1);
            }
            map.clear();
        }

        return result;
    }


    public static int getDistance(int a[], int b[]){
        int dx = b[0] - a[0];
        int dy = b[1] - a[1];

        return dx*dx + dy*dy;
    }


    public static void main(String[] args) {
        int array[][] = {{0,0}, {1,0}, {2,0}};
        System.out.println(numberOfBoomerangs(array));
    }

}
