package co2103.hw1.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import co2103.hw1.domain.Show;


public class ShowValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Show.class.equals(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		Show show = (Show) target;		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "", "The show needs a title!...");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "producer", "", "The show needs a given producer!...");
				
		
		if (show.getCategory().equals("Comedy") == false && show.getCategory().equals("Drama") == false && show.getCategory().equals("Documentary") == false)
		
		{
		errors.rejectValue("category", "", "The theme must be of category Drama, Comedy or Documentary!....");
		}
		
		if (show.getEpisodes() < 1 || show.getEpisodes() > 24) {
			errors.rejectValue("episodes",  "", "the episodes must be between 1 and 24!");
		}
		
	}

}
