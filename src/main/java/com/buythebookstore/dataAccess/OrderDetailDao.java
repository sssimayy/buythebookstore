package com.buythebookstore.dataAccess;

import com.buythebookstore.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer> {

    @Query("Select sum(o.number) From OrderDetail o  where  o.book.id=:bookId")
    Integer getTotalSellNumberByBookId(int bookId);
}
