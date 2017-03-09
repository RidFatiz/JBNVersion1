package org.sid.metier;

import java.util.List;

import org.sid.dao.RecommendationRepository;
import org.sid.entities.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RecommendationMetierImpl   implements RecommendationMetier{

	@Autowired
	private RecommendationRepository recommendationRepository;
	@Override
	public Recommendation save(Recommendation p) {
		// TODO Auto-generated method stub
		return recommendationRepository.save(p);
	}

	@Override
	public List<Recommendation> find(String username) {
		// TODO Auto-generated method stub
		return recommendationRepository.findRecommendationbyusername(username);
	}

}
