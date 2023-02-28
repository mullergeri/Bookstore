package org.example.model;

import jakarta.persistence.*;

@Entity
public class Stock {

    @EmbeddedId
    private StockId stockid = new StockId();


    private int quantity;


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StockId getStockid() {
        return stockid;
    }

    public void setStockid(StockId stockid) {
        this.stockid = stockid;
    }




    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stock{");
        sb.append("stockid=").append(stockid);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}
