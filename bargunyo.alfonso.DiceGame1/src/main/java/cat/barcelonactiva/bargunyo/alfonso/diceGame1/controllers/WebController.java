package cat.barcelonactiva.bargunyo.alfonso.diceGame1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cat.barcelonactiva.bargunyo.alfonso.diceGame1.assembler.GameDtoAssembler;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.assembler.PlayerDtoAssembler;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.dto.GameDto;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.dto.PlayerDto;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Game;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Player;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.repositories.GameRepository;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.repositories.PlayerRepository;

@RestController
public class WebController {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private PlayerDtoAssembler playerDtoAssembler;

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private GameDtoAssembler gameDtoAssembler;

	@GetMapping("/players")
	public ResponseEntity<CollectionModel<PlayerDto>> getAllPlayers() {

		List<Player> players = playerRepository.findAll();
		return new ResponseEntity<>(playerDtoAssembler.toCollectionModel(players), HttpStatus.OK);
	}

	@GetMapping("/players/{id}")
	public ResponseEntity<PlayerDto> getPlayerById(@PathVariable("id") Long id) {

		return playerRepository.findById(id).map(playerDtoAssembler::toModel).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/games")
	public ResponseEntity<CollectionModel<GameDto>> getAllGames(){
		
		List<Game> games = gameRepository.findAll();
		
		return new ResponseEntity<>(
				gameDtoAssembler.toCollectionModel(games), 
				HttpStatus.OK);
	}
	
	@GetMapping("/games/{id}")
	public ResponseEntity<GameDto> getGameById(@PathVariable("id") Long id){
		
	return gameRepository.findById(id)	
			.map(gameDtoAssembler::toModel)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}
	
}
