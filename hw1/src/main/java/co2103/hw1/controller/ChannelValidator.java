package co2103.hw1.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Channel;


public class ChannelValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Channel.class.equals(clazz);

	}
	
	@Override
	public void validate(Object target, Errors errors) {
		/// check if ID is taken 
		Channel channel = (Channel) target;
		int identifier = channel.getId();
		
		for ( Channel i : Hw1Application.channels) {
			if (identifier == i.getId()) {
				errors.rejectValue("id", "Sorry...this channel ID is not unique!");
				/// return error
			}	
		}
		if (channel.getName() == null) {
			String errorCode = "Sorry...the name field cannot be empty!";
			errors.rejectValue("name", errorCode );
			/// return error
		}
		
		if (channel.getTopic() == null) {
			String errorCode = "Sorry the topic field cannot be empty!";
			errors.rejectValue("topic", errorCode);
			/// return error
		}	
	}
}
