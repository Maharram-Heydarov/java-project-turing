package az.edu.turing.lesson02;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        myList.addHead(1);
        myList.addTail(2);
        myList.insert(1, 5);
        myList.insert(2, 4);
        System.out.println(myList.toString());


    }
}
