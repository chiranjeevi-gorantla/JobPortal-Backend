package com.chirango.JobPortalBackend.service;

import com.chirango.JobPortalBackend.model.JobPost;

import java.util.List;

public interface JobService {

    JobPost saveJobPost(JobPost jobPost);

    List<JobPost> getAllJobPosts();

}
