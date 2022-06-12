public class Fruit {
    // Attributes
    int numOfFruits = 5;
    String name;


    // Methods
    void eat(int numToEat) {
        numOfFruits -= numToEat;
    }

    int getNumberOfFruit() {
        return numOfFruits;
    }

    public static void main(String[] args) {
        Fruit apple = new Fruit();

        System.out.println(apple.numOfFruits);
        apple.eat(1);
        System.out.println(apple.getNumberOfFruit());


    }
}


