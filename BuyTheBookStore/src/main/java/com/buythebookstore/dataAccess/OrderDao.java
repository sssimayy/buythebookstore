package com.buythebookstore.dataAccess;

import com.buythebookstore.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Integer> {
}
