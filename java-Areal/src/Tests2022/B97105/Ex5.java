package Tests2022.B97105;

import java.lang.reflect.Array;

public class Ex5 {

    public static class Kid implements ICanSpeak {

        public void eat() {

        }

        @Override
        public void speak() {

        }
    }

    public static class Worker implements ICanSpeak, ICanRead {
        @Override
        public void speak() {

        }

        @Override
        public void read() {

        }
    }

    public static class Student extends Kid implements ICanWrite, ICanRead {
        public void sleep() {

        }

        @Override
        public void read() {

        }

        @Override
        public void write() {

        }
    }

    public static void main(String args[]) {

//        ICanRead : Worker , Student
//        ICanWrite : Student
//        ICanSpeak : Worker , Student , Kid

        ICanSpeak x = new Worker();
        Kid y = new Kid();
        ICanRead z = new Student();

        x = y;
        y = new Student();
        y.eat();
        z.read();

        ((Student) z).speak();
        ((Kid) z).eat();
        z = new Worker();

        ICanSpeak[] iCanSpeaksArray = {x, y};

        canSpeak(iCanSpeaksArray);

    }

    public static void canSpeak(ICanSpeak[] arraySpeaks) {
        for (ICanSpeak sw : arraySpeaks)
            if (sw instanceof ICanWrite)
                ((ICanWrite) sw).write();
            else sw.speak();

    }

//        for(int i = 0; i < animals.length; i++) {
//            if(animals[i] instanceof ICanFly)
//                counter++;
//            return counter;
//        }
}
