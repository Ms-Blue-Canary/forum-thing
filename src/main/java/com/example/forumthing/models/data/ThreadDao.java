package com.example.forumthing.models.data;
import com.example.forumthing.models.Thread;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface ThreadDao extends CrudRepository<Thread, Integer>{
}
