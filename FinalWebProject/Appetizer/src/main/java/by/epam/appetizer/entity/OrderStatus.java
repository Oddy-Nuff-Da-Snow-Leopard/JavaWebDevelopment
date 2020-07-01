package by.epam.appetizer.entity;

import java.util.Objects;

public class OrderStatus extends Entity {

    private String status;

    public OrderStatus() {
    }

    public OrderStatus(int id, String status) {
        super(id);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        OrderStatus orderStatus = (OrderStatus) obj;
        return Objects.equals(status, orderStatus.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), status);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("status=").append(status).append("]");
        return str.toString();
    }
}
