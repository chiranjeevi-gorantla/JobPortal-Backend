package com.chirango.JobPortalBackend.repository;

import com.chirango.JobPortalBackend.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends MongoRepository<JobPost, String> {
}
