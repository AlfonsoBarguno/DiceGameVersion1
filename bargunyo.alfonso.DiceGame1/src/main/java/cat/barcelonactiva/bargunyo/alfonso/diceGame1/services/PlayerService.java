package cat.barcelonactiva.bargunyo.alfonso.diceGame1.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Player;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.repositories.PlayerRepository;

@Service
public class PlayerService implements IPlayerService {

	@Autowired
	PlayerRepository playerRepository;

	@Override
	public ArrayList<Player> findAll() {

		return (ArrayList<Player>) playerRepository.findAll();
	}

	@Override
	public Player save(Player player) {

		return playerRepository.save(player);
	}

	@Override
	public Optional<Player> getPlayerById(Long id) {

		return playerRepository.findById(id);
	}

	@Override
	public boolean deletePlayerbyId(Long id) {

		try {
			playerRepository.deleteById(id);

			return true;

		} catch (Exception ex) {

			return false;
		}
	}

}
