package com.zach.languages.services;

import java.util.*;
import org.springframework.stereotype.Service;
import com.zach.languages.models.Language;
import com.zach.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

	// adding the book repository as a dependency
	 private final LanguageRepository languageRepository;
	 
	 public LanguageService(LanguageRepository languageRepository) {
	     this.languageRepository = languageRepository;
	 }
	 // returns all the books
	 public List<Language> allLanguages() {
	     return languageRepository.findAll();
	 }
	 // creates a book
	 public Language createLanguage(Language language) {
	     return languageRepository.save(language);
	 }
	 
	 // update a book 
	 public Language updateLanguage(Long id, String name, String creator, double version) {
		Language lang = findLanguage(id);
		lang.setName(name);
		lang.setCreator(creator);
		lang.setVersion(version);
		return languageRepository.save(lang);
	 }
	 
	 
	 // deletes a book using the CRUD command deleteById
	 public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	 }
	 
	 // retrieves a book
	 public Language findLanguage(Long id) {
	     Optional<Language> optionalLang = languageRepository.findById(id);
	     if(optionalLang.isPresent()) {
	         return optionalLang.get();
	     } else {
	         return null;
	     }
	 }
	
}
