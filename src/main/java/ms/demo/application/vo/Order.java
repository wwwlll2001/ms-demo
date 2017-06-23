package ms.demo.application.vo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private int id;
    private int productId;
    private BigDecimal price;
    private Date date;
    private int orderStatus;

    public Order() {
    }

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
