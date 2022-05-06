package cat.barcelonactiva.bargunyo.alfonso.diceGame1.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Game;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "player")
@Relation(collectionRelation = "players")
//@JsonInclude(Include.NON_NULL)
public class PlayerDto extends RepresentationModel<PlayerDto> {

	
private Long idPlayer;
	
	private String name;
	
	private LocalDate date;
	
	private List<Game> games;
	
	private double victory;
	
	private List<Player> players;

	public Long getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public double getVictory() {
		return victory;
	}

	public void setVictory(double victory) {
		this.victory = victory;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
}
