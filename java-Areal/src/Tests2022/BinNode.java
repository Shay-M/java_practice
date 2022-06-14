//package Tests2022;
//
//
//public class BinNode<T> {
//
//    private BinNode<T> left;
//    private T value;
//    private BinNode<T> right;
//
//    public BinNode() {
//        this.value = null;
//        this.left = null;
//        this.right = null;
//    }
//
//    public BinNode(T x) {
//        this.value = x;
//        this.left = null;
//        this.right = null;
//    }
//
//    public BinNode(BinNode<T> left, T x, BinNode<T> right) {
//        this.value = x;
//        this.left = left;
//        this.right = right;
//    }
//
//    public T getValue() {
//        return this.value;
//    }
//
//    public BinNode<T> getLeft() {
//        return this.left;
//    }
//
//    public BinNode<T> getRight() {
//        return this.right;
//    }
//
//    public void setValue(T x) {
//        this.value = x;
//    }
//
//    public void setLeft(BinNode<T> left) {
//        this.left = left;
//    }
//
//    public void setRight(BinNode<T> right) {
//        this.right = right;
//    }
//
//    public boolean hasLeft() {
//        return this.left != null;
//    }
//
//    public boolean hasRight() {
//        return this.right != null;
//    }
//
//    public String toString() {
//        return this.value.toString();
//    }
//
//
//    public void printInorder(BinNode<T> root) {
//
//        printInorder(root.getLeft());
//        System.out.print(root.getValue() + " ");
//        printInorder(root.getRight());
//
//    }
//
//}