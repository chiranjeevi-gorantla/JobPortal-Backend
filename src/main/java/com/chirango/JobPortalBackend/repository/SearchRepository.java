package com.chirango.JobPortalBackend.repository;

import com.chirango.JobPortalBackend.model.JobPost;

import java.util.*;

public interface SearchRepository {

    List<JobPost> findByText(String text);
}
