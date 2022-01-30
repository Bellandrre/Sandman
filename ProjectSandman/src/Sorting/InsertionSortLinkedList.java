package Sorting;

public class InsertionSortLinkedList {

    static class Node{
        Node next;
        int value;

        public Node(){
            next = null;
        }

        public Node(int value){
            this.next = null;
            this.value = value;
        }
    }

    public void addNode(Node curr, int value){

        if(curr != null){
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = new Node(value);
        }
    }

    public void printList(Node list){
        while(list.next != null){
            System.out.print(list.value + " ");
            list = list.next;
        }
    }

    public void insertionSort(){

    }

    public static void main(String[] args) {
        // 5, 2, 4, 6, 1, 3
        InsertionSortLinkedList obj = new InsertionSortLinkedList();
        Node curr = new Node(5);
        obj.addNode(curr, 2);
        obj.addNode(curr, 4);
        obj.addNode(curr, 6);
        obj.addNode(curr, 1);
        obj.addNode(curr, 3);
        obj.printList(curr);
    }
}
