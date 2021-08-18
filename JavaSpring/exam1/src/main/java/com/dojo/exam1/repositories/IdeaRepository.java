package com.dojo.exam1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.exam1.models.Idea;




@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {
	Idea findByUser(Long userId);
	
	List<Idea> findAll();
	
	@Query(value="SELECT ideas.content, users.name,  COUNT(users_liked_ideas.user_id) AS likes FROM ideas join users_liked_ideas on ideas.id = users_liked_ideas.idea_id join users on users_liked_ideas.user_id = users.id group by idea_id;", nativeQuery=true)
    List<Object[]> joinUsersAndIdeas();
	
}
