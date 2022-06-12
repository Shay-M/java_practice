//package Tests2022;
//
//class Node<T> {
//
//    T data;
//    Node<T> next;
//
//    // Parameterized constructor to assign value
//    public Node(T data, Node<T> next) {
//
//        this.data = data;
//        this.next = next;
//    }
//
//    public Node(T data) {
//
//        this.data = data;
//        this.next = null;
//    }
//
//    public Node() {
//    }
//
//    public T getValue() {
//        return this.data;
//    }
//
//    public Node<T> getNext() {
//        return this.next;
//    }
//
//    public void setValue(T data) {
//        this.data = data;
//    }
//
//    public boolean hasNext() {
//        return this.next != null;
//    }
//
//    public void setNext(Node<T> next) {
//        this.next = next;
//    }
//
//    @Override
//    public String toString() {
//        return " -> " + this.data + " ";
//    }
//}
//
//// Helper class ( Generic LinkedList class)
//class LinkedListInt<T> {
//
//    // Generic Node instance
//    Node<T> head;
//
//    // Default constructor
//    LinkedListInt() {
//        this.head = null;
//    }
//
//    public void append(T new_data) {
////
//		/* 1. Allocate the Node &
//		2. Put in the data
//		3. Set next as null */
//        Node<T> new_Node = new Node(new_data);
//
//		/* 4. If the Linked List is empty, then make the
//			new Node as head */
//        if (head == null) {
//            head = new Node(new_data);
//            return;
//        }
//
//		/* 4. This new Node is going to be the last Node, so
//			make next of it as null */
//        new_Node.next = null;
//
//        /* 5. Else traverse till the last Node */
//        Node<T> last = head;
//        while (last.next != null)
//            last = last.next;
//
//        /* 6. Change the next of last Node */
//        last.next = new_Node;
//        return;
//    }
//
//
//    @Override
//    public String toString() {
//
//        Node<T> tNode = head;
//        String temp = "";
//        while (tNode != null) {
//            if (!tNode.data.equals(-1))
//                temp += tNode.toString();
//            tNode = tNode.getNext();
//        }
//        return temp;
//    }
//}
////
////class LinkedListInt<T> {
////    Node<T> head; // head of list
////
////    /* Linked list Node*/
////    class Node<T> {
////        T data;
////        Node<T> next;
////
////        Node(T d) {
////            data = d;
////            next = null;
////        }
////    }
////
////    /* Inserts a new Node at front of the list. */
////    public void push(T new_data) {
////		/* 1 & 2: Allocate the Node &
////				Put in the data*/
////        Node<T> new_Node = new Node<>(new_data);
////
////        /* 3. Make next of new Node as head */
////        new_Node.next = head;
////
////        /* 4. Move the head to point to new Node */
////        head = new_Node;
////    }
////
////    /* Inserts a new Node after the given prev_Node. */
//////    public void insertAfter(Node prev_Node, T new_data) {
//////        /* 1. Check if the given Node is null */
//////        if (prev_Node == null) {
//////            System.out.println("The given previous Node cannot be null");
//////            return;
//////        }
//////
//////		/* 2 & 3: Allocate the Node &
//////				Put in the data*/
//////        Node<T> new_Node = new Node<>(new_data);
//////
//////        /* 4. Make next of new Node as next of prev_Node */
//////        new_Node.next = prev_Node.next;
//////
//////        /* 5. make next of prev_Node as new_Node */
//////        prev_Node.next = new_Node;
//////    }
////
////    /* Appends a new Node at the end. This method is
////    defined inside LinkedList class shown above */
////    public void append(double new_data) {
////		/* 1. Allocate the Node &
////		2. Put in the data
////		3. Set next as null */
////        Node<T> new_Node = new Node(new_data);
////
////		/* 4. If the Linked List is empty, then make the
////			new Node as head */
////        if (head == null) {
////            head = new Node(new_data);
////            return;
////        }
////
////		/* 4. This new Node is going to be the last Node, so
////			make next of it as null */
////        new_Node.next = null;
////
////        /* 5. Else traverse till the last Node */
////        Node<T> last = head;
////        while (last.next != null)
////            last = last.next;
////
////        /* 6. Change the next of last Node */
////        last.next = new_Node;
////        return;
////    }
////
////
////    @Override
////    public String toString() {
////
////
////        Node<T> tNode = head;
////        String temp = "";
////        while (tNode != null) {
////            temp += " --> " + tNode.data + " ";
////            tNode = tNode.next;
////        }
////        return temp;
////    }
////}
//
