package builder_not_use;

import shapes.Rectangle;


public final class Room2 {
    private Rectangle m_rectangle;


    private Room2(Rectangle m_rectangle) {
        this.m_rectangle = m_rectangle;
    }

    public Rectangle getM_rectangle() {
        return m_rectangle;
    }

    public void setM_rectangle(Rectangle m_rectangle) {
        this.m_rectangle = m_rectangle;
    }

    public static final class Room2Builder {
        private Rectangle m_rectangle;

        private Room2Builder(Rectangle m_rectangle) {
            this.m_rectangle = m_rectangle;
        }

        public static Room2Builder aRoom2(Rectangle m_rectangle) {
            return new Room2Builder(m_rectangle);
        }

        public Room2 build() {
            Room2 room2 = new Room2(m_rectangle);
            return room2;
        }
    }
}
