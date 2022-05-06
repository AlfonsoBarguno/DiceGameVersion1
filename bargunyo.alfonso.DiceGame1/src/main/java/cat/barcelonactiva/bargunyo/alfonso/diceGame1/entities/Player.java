package cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString(exclude="games)")
@Entity
@Table(name="Player")
public class Player implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idPlayer;
	
	@Column(name="Name", nullable = false, length=30, unique=true)
	private String name;
	
	@Column(name="Registration_date")
	private LocalDate date;
	
	@Column(name="Results_games")
	@OneToMany(mappedBy = "player")
	private List<Game> games;
	
	@Column(name="Percentage_victorys")
	private double victory;
	
	/*@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Player_Game", 
	joinColumns = @JoinColumn(name="player_id"),
	inverseJoinColumns = @JoinColumn (name="game_id"))*/
	
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
	
	

	/*public Player(Long idPlayer, String name, LocalDate date, List<Game> games, double victory) {
		super();
		this.idPlayer = idPlayer;
		this.name = name;
		this.date = date;
		this.games = games;
		this.victory = victory;
	}

	
	public Player() {
		
	}


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
	}*/
	
	

}
