package org.sid.dao;

import org.sid.entities.Question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository  extends JpaRepository<Question,Long> {

}