public class StringNode<temp> {

    private String value;
    private StringNode next;

    public StringNode() {
        this.value = null;
        this.next = null;
    }

    public StringNode(String value) {
        this.value = value;
    }

    public StringNode(String value, StringNode next) {
        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return this.value;
    }

    public StringNode getNext() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public void setValue(String x) {
        this.value = x;
    }

    public void setNext(StringNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        String temp = "";
        StringNode tnode = this;
        while (tnode != null) {
            temp += " -> " + tnode.value;
            tnode = tnode.next;
        }
        return temp;
    }

    public static int LongerThan2(StringNode first) {
        int count = 0;

        while (first != null) {
            if (first.value.length() > 2)
                count++;
            first = first.next;
        }

        return count;
    }

    public static void main(String[] args) {

        StringNode listString1 = new StringNode();


        listString1.setValue("shay");

        StringNode listString2 = new StringNode("mu");
        listString1.setNext(listString2);

        System.out.println(listString1);

        System.out.println(">> " + LongerThan2(listString1));


    }

}


