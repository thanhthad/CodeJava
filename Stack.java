public class Stack {
    // Stack using LinkedList  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private class Node {
        Student_Management student;
        Node next;

        public Node(Student_Management student) {
            this.student = student;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public Stack() {
        head = null;
        size = 0;
    }

    public Stack(Student_Management student) {
        head = new Node(student);
        size = 1;
    }

    public void push(Student_Management student) {
        Node include = new Node(student);
        include.next = head;
        head = include;
        size++;
    }

    public Student_Management pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! No students to remove.");
            return null;
        }
        Student_Management popStudent = head.student;
        head = head.next;
        size--;
        return popStudent;
    }

    public Student_Management peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return head.student;
    }

    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        return size;
    }
    public void displayStudents() {
        if (isEmpty()) {
            System.out.println("No students in the stack.");
            return;
        }
        System.out.println("Students in Stack:");
        Node current = head;
        while (current != null) {
            System.out.println("ID: " + current.student.getID_Student());
            System.out.println("Name: " + current.student.getName_Student());
            System.out.println("Mark: " + current.student.getMark_Student());
            current.student.Student_Ranking();
            System.out.println("----------------------");
            current = current.next;
        }
    }



    // Stack using Array !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


//    private Student_Management[] stackArray;
//    private int top;
//    private int capacity;
//
//    public Stack(int capacity) {
//        this.capacity = capacity;
//        stackArray = new Student_Management[capacity];
//        top = -1;
//    }
//
//    public void push(Student_Management student) {
//        if (top == capacity - 1) {
//            System.out.println("Stack Overflow! Can't add more students.");
//            return;
//        }
//        stackArray[++top] = student;
//    }
//
//    public Student_Management pop() {
//        if (isEmpty()) {
//            System.out.println("Stack Underflow! No students to remove.");
//            return null;
//        }
//        return stackArray[top--];
//    }
//
//    public Student_Management peek() {
//        if (isEmpty()) {
//            System.out.println("Stack is empty!");
//            return null;
//        }
//        return stackArray[top];
//    }
//
//    public boolean isEmpty() {
//        return top == -1;
//    }
//
//    public int size() {
//        return top + 1;
//    }
//
//    public void displayStudents() {
//        if (isEmpty()) {
//            System.out.println("No students in the stack.");
//            return;
//        }
//        System.out.println("Students in Stack:");
//        for (int i = top; i >= 0; i--) {
//            System.out.println("ID: " + stackArray[i].getID_Student());
//            System.out.println("Name: " + stackArray[i].getName_Student());
//            System.out.println("Mark: " + stackArray[i].getMark_Student());
//            stackArray[i].Student_Ranking();
//            System.out.println("----------------------");
//        }
//    }

}











