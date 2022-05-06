package cat.barcelonactiva.bargunyo.alfonso.diceGame1.assembler;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import cat.barcelonactiva.bargunyo.alfonso.diceGame1.controllers.WebController;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.dto.PlayerDto;
import cat.barcelonactiva.bargunyo.alfonso.diceGame1.entities.Player;
import lombok.RequiredArgsConstructor;



@Component
@RequiredArgsConstructor
public class PlayerDtoAssembler extends RepresentationModelAssemblerSupport<Player, PlayerDto>{

	
	public PlayerDtoAssembler() {
		super(WebController.class, Player.class);
	}

	@Override
	public PlayerDto toModel(Player entity) {
		
		PlayerDto playerDto = instantiateModel(entity);
		
		playerDto.add(linkTo(
				methodOn(WebController.class)
				.getPlayerById(entity.getIdPlayer()))
				.withSelfRel());
		
		playerDto.setIdPlayer(entity.getIdPlayer());
		playerDto.setDate(entity.getDate());
		playerDto.setName(entity.getName());
		playerDto.setVictory(entity.getVictory());
		playerDto.setGames(entity.getGames());
		
		return playerDto;
		
		
	}
	
	@Override
	public CollectionModel<PlayerDto> toCollectionModel(Iterable<? extends Player> entities){
		
		CollectionModel<Player> players = super.toCollectionModel(entities);
		
		players.add(linkTo(methodOn(WebController.class).getAllPlayers()).withSelfRel());
		
		return players;
	}
	
	private List<PlayerDto> toPlayerDto(List<Player> players) {
	    if (players.isEmpty())
	      return Collections.emptyList();
	 
	    return players.stream()
	        .map(player -> PlayerDto.builder()
	            .id(player.getIdPlayer())
	            .victory(player.getVictory())
	            .build()
	            .add(linkTo(
	                methodOn(WebController.class)
	                .getPlayerById(player.getIdPlayer()))
	                .withSelfRel()))
	        .collect(Collectors.toList());
	  }
	
	
}
