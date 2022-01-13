package Graphs;
import java.util.*;

public class BreadthFirstSearch {
    static String[] color;
    static int[] distance;
    static int[] parent;

    public static void BFSInit(Map adjList, int numberOfNodes){

        color = new String[numberOfNodes];
        distance = new int[numberOfNodes];
        parent = new int[numberOfNodes];

        Arrays.fill(color, "White");
        Arrays.fill(distance, -1);
        Arrays.fill(parent, -1);

        doBreadthFirstSearch(adjList, 0);


    }

    public static void doBreadthFirstSearch(Map adjList, int source){
        Deque<Integer> que = new LinkedList<>();

        que.addLast(source);
        color[source] = "Gray";
        distance[source] = 0;

        while(!que.isEmpty()){
            int node = que.pollFirst();

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

    public static void BFSInitAdjMatrix(int[][] matrix, int numberOfNodes){
        color = new String[numberOfNodes];
        distance = new int[numberOfNodes];
        parent = new int[numberOfNodes];

        Arrays.fill(color, "White");
        Arrays.fill(distance, -1);
        Arrays.fill(parent, -1);

        BreadthFirstSearchUsingAdjacencyMatrix(matrix, 0);

    }

    public static void BreadthFirstSearchUsingAdjacencyMatrix(int[][] matrix, int source){
        Deque<Integer> que = new LinkedList<>();

        que.addLast(source);
        color[source] = "Gray";
        distance[source] = 0;

        while(!que.isEmpty()){
            int node = que.pollFirst();

            System.out.print(node + " ");

            for(int i = 0 ; i < matrix[node].length ; i++){
                if(matrix[node][i] != 0 && "White".equals(color[i])) {
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
        /**
         * Breadth First Search using Adjacency List
         */
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, Arrays.asList(1,4));
        adjList.put(1, Arrays.asList(0,4,2,3));
        adjList.put(2, Arrays.asList(1,3));
        adjList.put(3, Arrays.asList(1,4,2));
        adjList.put(4, Arrays.asList(3,0,1));

        BFSInit(adjList, numberOfNodes);

        System.out.println();
        /**
         * Breadth First Search using Adjacency matrix
         */
        int[][] adjMatrix = {{0,1,0,0,1},
                          {1,0,1,1,1},
                          {0,1,0,1,0},
                          {0,1,1,0,1},
                          {1,1,0,1,0}};


        BFSInitAdjMatrix(adjMatrix, numberOfNodes);

    }

}
