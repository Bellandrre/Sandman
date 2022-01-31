package Sorting;

public class InsertionSortLinkedList {

    static class Node{
        Node next;
        Node prev;
        int value;

        public Node(){
            this.next = null;
            this.prev = null;
        }

        public Node(int value){
            this.next = null;
            this.prev = null;
            this.value = value;
        }
    }

    Node sortedList;

    public void addNode(Node curr, int value){

        if(curr != null){
            while(curr.next != null){
                curr = curr.next;
            }
            Node newNode = new Node(value);
            curr.next = newNode;
            newNode.prev = curr;
            newNode.next = null;
        }
    }

    public void printList(Node list){
        while(list != null){
            System.out.print(list.value + " ");
            list = list.next;
        }
    }

    public void printListInReverse(Node list){
        while(list.next != null){
            list = list.next;
        }

        while(list != null){
            System.out.print( list.value + " ");
            list = list.prev;
        }
    }


    public Node insertionSort(Node head){
        sortedList = null;
        Node current = head;

        while(current!= null){
            Node next = current.next;
            sortedInsert(current);
            current = next;
        }
        head = sortedList;
        return head;
    }

    public void sortedInsert(Node newNode){
        if(sortedList == null || sortedList.value >= newNode.value){
            newNode.next = sortedList;
            sortedList = newNode;
        }else{
            Node current = sortedList;
            while(current.next != null && current.next.value < newNode.value){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
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
        Node newSortedHead =  obj.insertionSort(curr);

        obj.printList(newSortedHead);


    }
}
