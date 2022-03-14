package com.buythebookstore.dataAccess;

import com.buythebookstore.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationDao extends JpaRepository<Recommendation,Integer> {
}
