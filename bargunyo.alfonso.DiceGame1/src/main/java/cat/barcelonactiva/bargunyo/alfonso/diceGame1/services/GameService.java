package cat.barcelonactiva.bargunyo.alfonso.diceGame1.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Game;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Player;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.repositories.GameRepository;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.repositories.PlayerRepository;

@Service
public class GameService implements IGameService {

	@Autowired
	GameRepository gameRepository;

	@Autowired
	PlayerRepository playerRepository;

	@Override
	public ArrayList<Game> findAll() {

		return (ArrayList<Game>) gameRepository.findAll();
	}

	@Override
	public Game saveGame(Game game) {

		return gameRepository.save(game);
	}

	@Override
	public boolean deleteGamesByPlayerId(Long id) {

		try {

			Player player = playerRepository.findById(id).get();

			player.getGames().clear();

			return true;

		} catch (Exception ex) {

			return false;
		}

	}
}
