package com.chirango.JobPortalBackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "JobPost")
public class JobPost {
    private String desc;
    private Long exp;
    private String profile;
    private  List<String> techs;
}
