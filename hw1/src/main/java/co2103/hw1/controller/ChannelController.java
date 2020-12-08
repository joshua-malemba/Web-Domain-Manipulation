package co2103.hw1.controller;
import javax.validation.Valid;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Channel;


@Controller
public class ChannelController {
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new ChannelValidator());
	}
	
	@GetMapping("/channels")
	public String getChannels(Model model) {
		List<Channel> channels = Hw1Application.channels;

		model.addAttribute("channels", channels);

		return "channels/list";
	}
		
	@RequestMapping("/newChannel")
	public String updateChannel(Model model) {	
		model.addAttribute("channel", new Channel());		
		return "channels/form";
	}
	
	@PostMapping("/addChannel")
	public String addChannel(@Valid @ModelAttribute Channel channel, BindingResult result) {
		
		if (result.hasErrors()) {
			return "channels/form";
		}
		
		Hw1Application.channels.add(channel);
		
		return "redirect:/channels";	
	}
}


