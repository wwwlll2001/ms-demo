package ms.demo.application.vo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private final int id;
    private final int productId;
    private final BigDecimal price;
    private final Date date;
    private final int orderStatus;

    public Order(int id, int productId, BigDecimal price, Date date, int orderStatus) {
        this.id = id;
        this.productId = productId;
        this.price = price;
        this.date = date;
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public int getOrderStatus() {
        return orderStatus;
    }
}
