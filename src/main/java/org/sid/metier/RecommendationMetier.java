package org.sid.metier;

import java.util.List;

import org.apache.catalina.User;
import org.sid.entities.Recommendation;

public interface RecommendationMetier {
	
	public Recommendation save(Recommendation p);
	public List<Recommendation> find(String username);
	
}
