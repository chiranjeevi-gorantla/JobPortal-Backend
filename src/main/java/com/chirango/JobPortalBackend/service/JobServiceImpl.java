package com.chirango.JobPortalBackend.service;

import com.chirango.JobPortalBackend.model.JobPost;
import com.chirango.JobPortalBackend.repository.JobRepository;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public JobPost saveJobPost(JobPost jobPost) {
        return jobRepository.save(jobPost);
    }

    @Override
    public List<JobPost> getAllJobPosts() {
        return jobRepository.findAll();
    }
}
