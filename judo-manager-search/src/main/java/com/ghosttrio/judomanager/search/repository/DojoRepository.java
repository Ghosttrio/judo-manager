package com.ghosttrio.judomanager.search.repository;

import com.ghosttrio.judomanager.search.document.Dojo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DojoRepository extends MongoRepository<Dojo, String> {
}
