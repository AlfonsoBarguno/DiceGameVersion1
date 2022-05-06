package cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@ToString(exclude="players")
@Entity
@Table(name="Game")
public class Game implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGame;
	
	@Column(name="Dice_1", nullable =false)
	private int dice1;
	
	@Column(name="Dice_2",nullable =false)
	private int dice2;
	
	@Column(name="Victory",nullable =false)
	private boolean win;
	
	@JoinColumn(name = "Player")
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Player player;
	/*@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Player_Game", 
	joinColumns = @JoinColumn(name="player_id"),
	inverseJoinColumns = @JoinColumn (name="game_id"))*/
	
	private List<Player> players;
	

	public Game(Long idGame, int dice1, int dice2, boolean win, Player player) {
		
		this.idGame = idGame;
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.win = win;
		this.player = player;
	}

	public Game() {
		
	}

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
	
	
}
