package builder;

import shapes.Rectangle;


public final class Room {
    private Rectangle m_rectangle;

    public double getRoomSize() {
        return m_rectangle.calculateSize();
    }

    private double roomSize;

    public Room(final Builder builder) {
        m_rectangle = builder.rectangle;
    }

    //
    public final static class Builder {
        private Rectangle rectangle;

        public final Room build() {
            return new Room(this);
        }

        public final Builder buildRectangle(Rectangle rectangle) {
            this.rectangle = rectangle;
            return this;
        }

    }


}
