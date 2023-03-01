package com.chirango.JobPortalBackend.repository;

import com.chirango.JobPortalBackend.model.JobPost;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;

    @Override
    public List<JobPost> findByText(String text) {

        final List<JobPost> posts = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("JobsDB");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                                new Document("$search",
                                new Document("text",
                                new Document("query", text )
                                        .append("path", Arrays.asList("techs", "desc", "profile")))),
                                new Document("$sort",
                                new Document("exp", 1L))));

        result.forEach(document -> posts.add(converter.read(JobPost.class, document) ));

        return posts;
    }
}
