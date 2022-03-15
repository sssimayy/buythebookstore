package com.buythebookstore.dataAccess;

import com.buythebookstore.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer> {

}
