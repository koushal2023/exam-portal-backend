package com.exam.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.models.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	public Quiz findByQid(Long qid);

	public Set<Quiz> findByCategoryCid(Long cid);

	@Query("from Quiz q where q.qid=:qid and q.active=true")
	public Quiz getByQid(@Param("qid") Long qid);

	@Query("from Quiz q where q.category.cid=:cid and q.active=true")
	public Set<Quiz> getByCategoryCid(@Param("cid") Long cid);

	@Query("from Quiz q where q.active=true")
	public List<Quiz> getAllActiveQuizzes();
}
