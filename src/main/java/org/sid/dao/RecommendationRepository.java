package org.sid.dao;

import java.util.List;
import org.sid.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long>  {
	
	@Query("select r from Recommendation r where r.recepteur.username=:x")
	public List<Recommendation> findRecommendationbyusername(@Param("x") String username );
	
}
