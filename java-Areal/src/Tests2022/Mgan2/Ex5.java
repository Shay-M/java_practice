package Tests2022.Mgan2;

public class Ex5 {

    public interface ICanCall {
        void outgoing_call();

        void incoming_call();
    }

    public interface TakeAPic {
        void photo_taking();
    }

    public static abstract class Phone implements ICanCall {

        @Override
        public void outgoing_call() {

        }

        @Override
        public void incoming_call() {

        }


        public static class Lines extends Phone {

        }

        public static class Cellular extends Phone {
            public void sms() {

            }

        }

        public static class Kosher extends Cellular {

        }

        public static class Smart extends Cellular implements TakeAPic {
            public boolean web() {
                return false;
            }

            @Override
            public void photo_taking() {

            }
        }


        public static void main(String[] args) {

//            Cellular cm = new Smart();
//
//            Phone p = new Phone(); //X
//
//            TakeAPic tp = new Lines(); //X
//
//            Phone k = new Kosher();
//            k.incoming_call();
//
//            Smart s = new Cellular(); // X
//
//
            Phone p = new Kosher(); //X
            ((Smart) p).photo_taking();
//
//            ICanCall ic = new Lines();
//            ic.outgoing_call();




        }

    }


}
