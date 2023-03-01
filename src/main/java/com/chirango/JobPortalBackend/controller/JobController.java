package com.chirango.JobPortalBackend.controller;

import com.chirango.JobPortalBackend.model.JobPost;
import com.chirango.JobPortalBackend.repository.SearchRepository;
import com.chirango.JobPortalBackend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private SearchRepository searchRepository;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/");
    }

    @PostMapping("/createJobPost")
    public JobPost saveJobPost(@RequestBody JobPost jobPost) {
        return jobService.saveJobPost(jobPost);
    }

    @GetMapping("/allJobPosts")
    public List<JobPost> getAllJobPosts() {
        return jobService.getAllJobPosts();
    }

    @GetMapping("/jobPosts/{text}")
    public List<JobPost> searchJobPost(@PathVariable String text) {
        return searchRepository.findByText(text);
    }
}
