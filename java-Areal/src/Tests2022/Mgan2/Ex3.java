package Tests2022.Mgan2;

public class Ex3 {
}

interface I {
    String world();
}


abstract class Aclass implements I {
    public String hello() {
        return "Hello ";
    }

    abstract public String world();

}

class Dclass extends Aclass {

    public String hello() {
        return "World ";
    }

    public String world() {
        return super.hello() + hello();
    }
}

class Eclass extends Dclass {
    public String hello() {
        return "Java ";
    }

}

class Fclass extends Aclass {

    private String str = "Love ";

    public Fclass(String str) {
        this.str = str + "Java ";
    }

    public String world() {
        return str + "!!!";
    }
}

class Main {
    public static void main(String[] args) {
        I x = new Dclass();
        System.out.println(x.world());

        I y = new Eclass();
        System.out.println(y.world());

        I z = new Fclass("Hii ");
        System.out.println(z.world());

        ////I t = new Aclass(); // 'Aclass' is abstract; cannot be instantiated
    }
}
