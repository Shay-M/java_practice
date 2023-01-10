package model;

import model.engines.Engine;
import model.wheels.Wheel;

public final class Car {

    private final String m_name;
    private final String m_color;
    private final int m_nmmOfDoors;

    private final Wheel m_wheel;
    private final Engine m_engine;


    public Car(final String name, final String color, final int numOfDoors, final Wheel wheel, final Engine engine) {
        this.m_name = name;
        this.m_color = color;
        this.m_nmmOfDoors = numOfDoors;
        this.m_wheel = wheel;
        this.m_engine = engine;
    }

   /* public String getName() {
        return m_name;
    }

    public void setName(final String m_name) {
        this.m_name = m_name;
    }

    public String getColor() {
        return m_color;
    }

    public void setColor(final String m_color) {
        this.m_color = m_color;
    }

    public int getNmmOfDoors() {
        return m_nmmOfDoors;
    }

    public void setNmmOfDoors(final int m_nmmOfDoors) {
        this.m_nmmOfDoors = m_nmmOfDoors;
    }

    public Wheel getWheel() {
        return m_wheel;
    }

    public void setWheel(final Wheel m_wheel) {
        this.m_wheel = m_wheel;
    }

    public Engine getEngine() {
        return m_engine;
    }

    public void setEngine(final Engine m_engine) {
        this.m_engine = m_engine;
    }*/

    @Override
    public String toString() {
        return "\n" +
                "Name: " + m_name + "\n" +
                "Color: " + m_color + "\n" +
                "Nmm Of Doors: " + m_nmmOfDoors + "\n" +
                "Wheel: " + m_wheel.getClass().getName() + "\n" +
                "Engine: " + m_engine.getClass().getName() + "\n" +
                "\n";
    }

}
