package cat.barcelonactiva.bargunyo.alfonso.diceGame1.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonRootName;

import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Game;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "game")
@Relation(collectionRelation = "games")
//@JsonInclude(Include.NON_NULL)
public class GameDto extends RepresentationModel<GameDto> {

	
	private Long idGame;
	
	private int dice1;
	
	private int dice2;
	
	private boolean win;
	
	private Player player;

	public Long getIdGame() {
		return idGame;
	}

	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}

	public int getDice1() {
		return dice1;
	}

	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}

	public int getDice2() {
		return dice2;
	}

	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public GameDto(Long idGame, int dice1, int dice2, boolean win, Player player) {
		super();
		this.idGame = idGame;
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.win = win;
		this.player = player;
	}

	public GameDto() {
	}
	
	
}
