package Tests2022.A97105;

public class Ex5 {

    public static abstract class Animal {

    }

    public static class Mammal extends Animal {

    }

    public static class Bat extends Mammal implements ICanFly {

        @Override
        public void fly() {

        }
    }

    public static class Fish extends Animal implements IHasEggs {

        @Override
        public void layingEggs() {

        }
    }

    public static class Bird extends Animal implements IHasEggs, ICanFly {

        @Override
        public void layingEggs() {

        }

        @Override
        public void fly() {

        }
    }

    public static void main(String args[]) {

//      1.
        Animal a = new Bat();

//      2.
//        Fish f = new IHasEggs(); // 'IHasEggs' is abstract; cannot be instantiated

//      3.
        ICanFly cf = new Bird();
        cf = new Bat();

//      4.
        Mammal m = new Bat();
//        m.fly(); // Cannot resolve method 'fly' in 'Mammal'

//      5.
        Animal aa = new Bird();
        ((Bird) aa).fly();

//      6.
        IHasEggs he = new Bird();
//        he.fly(); // Cannot resolve method 'fly' in 'IHasEggs'

    }
}
