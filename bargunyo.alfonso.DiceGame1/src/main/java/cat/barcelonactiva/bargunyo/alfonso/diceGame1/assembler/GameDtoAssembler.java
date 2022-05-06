package cat.barcelonactiva.bargunyo.alfonso.diceGame1.assembler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import cat.barcelonactiva.bargunyo.alfonso.diceGame1.controllers.WebController;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.dto.GameDto;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Game;

public class GameDtoAssembler extends RepresentationModelAssemblerSupport<Game, GameDto> {

	public GameDtoAssembler() {
		super(WebController.class, GameDto.class);
	}

	@Override
	public GameDto toModel(Game entity) {
		
		GameDto gameDto = instantiateModel(entity);
		
		gameDto.add(linkTo(
				methodOn(WebController.class)
				.getGameById(entity.getIdGame()))
				.withSelfRel());
		
		gameDto.setIdGame(entity.getIdGame());
		gameDto.setPlayer(entity.getPlayer());
		gameDto.setDice1(entity.getDice1());
		gameDto.setDice2(entity.getDice2());
		gameDto.setWin(entity.isWin());
		
		return gameDto;
	}
	
	@Override
	public CollectionModel<GameDto> toCollectionModel(Iterable<? extends Game> entities){
		
	CollectionModel<GameDto> games = super.toCollectionModel(entities);
	
	games.add(linkTo(methodOn(WebController.class).getAllGames()).withSelfRel());
	
	return games;
	}
	
	private List<GameDto> toGameDto (List<Game> games){
		
		if(games.isEmpty())
			return Collections.emptyList();
		
		return games.stream()
				.map(game-> gameDto.builder() 
				.id(game.getIdGame())
				.player(game.getPlayer())
				.dice1(game.getDice1())
				.dice2(game.getDice2())
				.win(game.isWin())
				.build()
				.add(linkTo(
						methodOn(WebController.class)
						.getGameById(game.getIdGame()))
						.withSelfRel()))
				.collect(Collectors.toList());
	}
	
	
	
}
