package by.trjava.task03.entity;

import by.trjava.task03.entity.type.CutMethod;
import java.util.Objects;

public class Appearance {

    private String color;
    private int transparency;
    private CutMethod cutMethod;

    private Appearance() {
    }

    public static class Builder {

        private final Appearance appearance;

        public Builder() {
            appearance = new Appearance();
        }

        public Builder setColor(String color) {
            appearance.color = color;
            return this;
        }

        public Builder setTransparency(int transparency) {
            appearance.transparency = transparency;
            return this;
        }

        public Builder setCutMethod(CutMethod cutMethod) {
            appearance.cutMethod = cutMethod;
            return this;
        }

        public Appearance build() {
            return appearance;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public CutMethod getCutMethod() {
        return cutMethod;
    }

    public void setCutMethod(CutMethod cutMethod) {
        this.cutMethod = cutMethod;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Appearance appearance = (Appearance) obj;

        return Objects.equals(color, appearance.color)
                && transparency == appearance.transparency
                && cutMethod == appearance.getCutMethod();
    }

    @Override
    public int hashCode() {
        Object[] fields = new Object[]{
            color,
            transparency,
            cutMethod
        };
        int result = 1;
        for (Object field : fields) {
            result = 31 * result + (field == null ? 0 : field.hashCode());
        }
        return super.hashCode() + result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("color=").append(color).append(", ");
        str.append("transparency=").append(transparency).append(", ");
        str.append("cutMethod=").append(cutMethod.getValue());
        return str.toString();
    }
}
