package com.buythebookstore.dataAccess;

import com.buythebookstore.entities.Kind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KindDao extends JpaRepository<Kind, Integer> {

    Kind getById(int id);
}
