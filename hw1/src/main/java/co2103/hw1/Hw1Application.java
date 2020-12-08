package co2103.hw1;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co2103.hw1.domain.Channel;
import co2103.hw1.domain.Show;

@SpringBootApplication
public class Hw1Application implements CommandLineRunner {
	
	public static List<Channel> channels = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(Hw1Application.class, args);
	}
	
	@Override
	public void run(String ... args) throws Exception {
		
		Channel channel = new Channel();
		
		channel.setId(1);
		channel.setName("channel1");
		channel.setTopic("entertainment");
		
		List<Show> shows = new ArrayList<>();
		
		Show show1 = new Show();
		
		show1.setCategory("Documentary");
		show1.setEpisodes(5);
		show1.setProducer("David Craig");
		show1.setTitle("WildLife");

		shows.add(show1);
		
		
		Show show2 = new Show();
		show2.setCategory("Comedy");
		show2.setEpisodes(5);
		show2.setProducer("Daniel Williams");
		show2.setTitle("Who Said My Name?");
		
		shows.add(show2);
		
		channel.setShows(shows);
		
		channels.add(channel);
	}
	
	
}
