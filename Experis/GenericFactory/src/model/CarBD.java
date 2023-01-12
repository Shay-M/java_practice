package model;

import model.engines.Engine;
import model.wheels.Wheel;

public final class CarBD {
    private final String m_name;
    private final String m_color;
    private final int m_nmmOfDoors;

    private final Wheel m_wheel;
    private final Engine m_engine;

    public CarBD(final Builder builder) {
        this.m_name = name;
        this.m_color = color;
        this.m_nmmOfDoors = numOfDoors;
        this.m_wheel = wheel;
        this.m_engine = engine;
    }
    public static class Builder {
        private String m_name;
        private String m_color;
        private int m_nmmOfDoors;

        private Wheel m_wheel;
        private Engine m_engine;

        public CarBD build() {
            return new CarBD(this);
        }

        public final Builder nameSet(final String name) {
            m_name = protocol.;
            return this;
        }
    }



//    @Override
//    public String toString() {
//        return "\n" +
//                "Name: " + m_name + "\n" +
//                "Color: " + m_color + "\n" +
//                "Nmm Of Doors: " + m_nmmOfDoors + "\n" +
//                "Wheel: " + m_wheel.getClass().getName() + "\n" +
//                "Engine: " + m_engine.getClass().getName() + "\n" +
//                "\n";
//    }

}
