package Graphs;
import java.util.*;

public class BreadthFirstSearch {
    static String[] color;
    static int[] distance;
    static int[] parent;


    public static void BFSFull(Map adjList, int n){
        color = new String[n];
        distance = new int[n];
        parent = new int[n];
        Arrays.fill(color, "White");
        Arrays.fill(distance, -1);
        Arrays.fill(parent, -1);

        for(int i = 0 ; i < n ; i++) {
            if ("White".equals(color[i])) {
                callBfs(adjList, i);
            }
        }
    }

    public static void callBfs(Map adjList, int source){
        Deque<Integer> que = new LinkedList<>();

        que.push(source);

        distance[source] = 0;
        color[source] = "Gray"; // Visited

        while(!que.isEmpty()){
            int node = que.poll();

            System.out.print(node + " ");

            List<Integer> children = (List)adjList.get(node);

            for(Integer i : children){
                if("White".equals(color[i])){
                    color[i] = "Gray";
                    distance[i] = distance[node] + 1;
                    parent[i] = node;

                    que.addLast(i);
                }
            }

            color[node] = "Black";
        }

    }
    public static void main(String[] args) {
        int numberOfNodes = 5;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, Arrays.asList(1,4));
        adjList.put(1, Arrays.asList(0,4,2,3));
        adjList.put(2, Arrays.asList(1,3));
        adjList.put(3, Arrays.asList(1,4,2));
        adjList.put(4, Arrays.asList(3,0,1));

        BFSFull(adjList, numberOfNodes);

    }
}
