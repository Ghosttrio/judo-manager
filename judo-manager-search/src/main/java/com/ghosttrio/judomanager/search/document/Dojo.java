package com.ghosttrio.judomanager.search.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "dojos")
public class Dojo {

    public Dojo(String id, String test) {
        this.id = id;
        this.test = test;
    }

    @Id
    private String id;
    private String test;

    public static Dojo create() {
        return new Dojo(null, "test");
    }

}