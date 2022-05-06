package cat.barcelonactiva.bargunyo.alfonso.diceGame1.services;

import java.util.ArrayList;
import java.util.Optional;


import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Player;

public interface IPlayerService {

	
	
	public ArrayList<Player> findAll(); 
	
	public Player save (Player player);
	
	Optional<Player> getPlayerById(Long id);
	
	boolean deletePlayerbyId(Long id);
	
	
}
