package com.zach.languages.repositories;

import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.zach.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	// this method retrieves all the languages from the database
    List<Language> findAll();
    
    // this method finds languages with names containing the search string
    List<Language> findByCreator(String search);
    

    
}
