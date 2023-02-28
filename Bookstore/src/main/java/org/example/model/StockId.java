package org.example.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StockId implements Serializable {

    private Long storeId;
    private Long bookId;


    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StockId{");
        sb.append("storeId=").append(storeId);
        sb.append(", bookId=").append(bookId);
        sb.append('}');
        return sb.toString();
    }
}
