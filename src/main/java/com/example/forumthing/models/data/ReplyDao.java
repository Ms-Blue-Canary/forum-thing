package com.example.forumthing.models.data;
import com.example.forumthing.models.Home;
import com.example.forumthing.models.Reply;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface ReplyDao extends CrudRepository<Reply, Integer>{
}