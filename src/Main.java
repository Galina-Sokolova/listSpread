public class Main {
    public static void main(String[] args) {
        int[]keys = {0, 1, 2, 3, 4, 5};
        Node head = null;
        for (int key: keys){
            head = push(head, key);
        }
        printDoublyLinked("This list: ", head);
        head = reverseDoublyLinked(head);
        printDoublyLinked("Reversed list: ", head);

    }
    public static class Node{
        int value;
        Node next;
        Node previos;
        public Node(int value){
            this.value = value;
            this.next = null;
            this.previos = null;
        }
    }

    public static Node push(Node head, int key) {
        Node node = new Node(key);
        node.next = head;
        if (head != null){
            head.previos = node;
        }
        head = node;
        return head;
    }

    public static void printDoublyLinked (String message, Node head){
        System.out.print(message);
        while (head != null){
            System.out.printf("%d ->", head.value);
            head = head.next;
        }
        System.out.println("null");
    }
    public  static  void swap(Node node){
        Node previos = node.previos;
        node.previos = node.next;
        node.next = previos;
    }
    public  static Node reverse(Node head, Node current){
        if (current.next == null){
            swap(current);
            head = current;
            return  head;
        }
        swap(current);
        head = reverse(head, current.previos);
        return  head;
    }
    public static Node reverseDoublyLinked(Node head){
        if(head == null){
            return  head;
        }
        Node current = head;
        head = reverse(head, current);
        return  head;
    }
}