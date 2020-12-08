package co2103.hw1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Channel;
import co2103.hw1.domain.Show;

@Controller
public class ShowController {
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new ShowValidator());
	}
	
	@GetMapping("/shows")
	public String getShows(@RequestParam("channel") int channel,  Model model) {
		
		
		for (Channel i : Hw1Application.channels) {
			if (i.getId() == channel) {
				model.addAttribute("shows", i.getShows());
			}
		}
		
		return "shows/list";
	}
	
	@RequestMapping("/newShow")
	public String newShow(@RequestParam("channel") int channel, Model model) {
		model.addAttribute("show", new Show());		
		return "shows/form";
	}
	
	@PostMapping("/addShow")
	public String addShow(@Valid @ModelAttribute Show show, BindingResult result, @RequestParam("channel") int channel) {
		
		if (result.hasErrors()) {
			System.out.print("error");
			return "shows/form";
		}
		
		Channel channel1 = null;
		
		for (Channel i : Hw1Application.channels) {
			
			if (i.getId() == channel) {
				channel1 = i;
				break;
				}
			}
		
		if (channel1 != null) {
			channel1.getShows().add(show);
		}	
		
		
		Hw1Application.channels.add(channel1);
		
		
		return "redirect:/channels";
    }
}
