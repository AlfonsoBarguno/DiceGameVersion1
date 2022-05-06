package cat.barcelonactiva.bargunyo.alfonso.diceGame1.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	
	public abstract Optional<Player> findById (Long id);
	public abstract Optional<Player> findByName(String name);
	//public abstract Optional<Player> findBySuccess (boolean win);
}
