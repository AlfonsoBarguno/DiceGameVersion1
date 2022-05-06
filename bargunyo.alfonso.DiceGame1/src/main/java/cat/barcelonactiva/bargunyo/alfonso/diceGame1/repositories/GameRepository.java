package cat.barcelonactiva.bargunyo.alfonso.diceGame1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
