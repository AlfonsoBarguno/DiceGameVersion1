package cat.barcelonactiva.bargunyo.alfonso.diceGame1.services;

import java.util.ArrayList;

import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Game;

public interface IGameService {

	
	public ArrayList<Game> findAll();
	
	public Game saveGame (Game game);
	
	boolean deleteGamesByPlayerId(Long Id);
}
