package cat.barcelonactiva.bargunyo.alfonso.diceGame1.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Player;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.services.IPlayerService;

@RestController
@RequestMapping
public class PlayerController {

	@Autowired
	IPlayerService playerService;

	@GetMapping("/players")
	public ArrayList<Player> getPlayers() {

		return playerService.findAll();

	}

	@PostMapping("/players")
	public Player savePlayer(@RequestBody Player player) {
		

		return this.playerService.save(player);

	}
	
	@GetMapping 
	Optional<Player> getPlayerById(@PathVariable ("id") Long id){
		
		return this.playerService.getPlayerById(id);
	}
	
	@PostMapping
	public boolean deletePlayerById(@PathVariable ("id") Long id) {
		
		try {
			
			playerService.deletePlayerbyId(id);
			
			return true;
			
		} catch (Exception ex) {
			
			return false;
			
		}
	}
	
	
}
