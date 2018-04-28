package com.example.forumthing.models.data;

import com.example.forumthing.models.NewPost;
import com.example.forumthing.models.Home;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HomeDao extends CrudRepository<Home, Integer> {
}

