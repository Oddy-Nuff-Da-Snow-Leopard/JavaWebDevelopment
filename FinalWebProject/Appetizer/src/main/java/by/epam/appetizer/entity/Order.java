package by.epam.appetizer.entity;

import java.util.Date;
import java.util.Objects;

public class Order extends Entity {

    private int userCartId;
    private int statusId;
    private double totalPrice;
    private Date date;
    private String comment;

    public Order() {
    }

    public Order(int id, int userId, int statusId, double totalPrice, Date date,
            String comment) {
        super(id);
        this.userCartId = userId;
        this.statusId = statusId;
        this.totalPrice = totalPrice;
        this.date = date;
        this.comment = comment;
    }

    public int getUserCartId() {
        return userCartId;
    }

    public void setUserCartId(int userCartId) {
        this.userCartId = userCartId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        Order order = (Order) obj;
        return userCartId == order.userCartId && statusId == order.statusId
                && Objects.equals(totalPrice, order.totalPrice)
                && Objects.equals(date, order.date)
                && Objects.equals(comment, order.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userCartId, statusId, totalPrice,
                date, comment);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("userCartId=").append(userCartId).append(", ");
        str.append("statusId=").append(statusId).append(", ");
        str.append("totalPrice=").append(totalPrice).append(", ");
        str.append("date=").append(date).append(", ");
        str.append("comment=").append(comment).append("]");
        return str.toString();
    }
}
