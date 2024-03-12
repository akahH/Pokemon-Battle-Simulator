package projecto_final_2021_B;

import java.util.ArrayList;
import java.util.List;

public class PokemonPool {
	private List<Pokemon> pokemonPool = new ArrayList<Pokemon>();
	
	public List<Pokemon> pokemonPool(){
		// criar pokemons
		Pokemon espeon = new Pokemon("Espeon", 240, PokemonType.PSYCHIC, 238, 175, 202, "../images/espeon_icon.png", "../images/espeon_sprite.png" );
		Pokemon venausaur = new Pokemon("Venusaur", 270, PokemonType.GRASS, PokemonType.POISON, 184, 184, 148, "../images/venusaur_icon.png", "../images/venusaur_sprite.png" );
		Pokemon dragapult = new Pokemon("Dragapult", 286, PokemonType.DRAGON, PokemonType.GHOST, 220, 139, 260 , "../images/dragapult_icon.png","../images/dragapult_sprite.png" );
		Pokemon ninetailsAlola = new Pokemon("Ninetails - Alola", 250, PokemonType.ICE, PokemonType.FAIRY, 150, 184, 200, "../images/ninetails_icon.png", "../images/ninetails_sprite.png");
		Pokemon tyranitar = new Pokemon("Tyranitar", 310, PokemonType.DARK, PokemonType.ROCK, 245, 202, 114, "../images/tyranitar_icon.png", "../images/tyranitar_sprite.png" );
		Pokemon charizard = new Pokemon("Charizard", 266, PokemonType.FIRE, PokemonType.FLYING, 200, 157, 184, "../images/charizard_icon.png", "../images/charizard_sprite.png"  );
		Pokemon jolteon = new Pokemon("Jolteon", 240, PokemonType.ELECTRIC, 202, 175, 238, "../images/jolteon_icon.png", "../images/jolteon_sprite.png" );
		Pokemon lapras = new Pokemon("Lapras", 370, PokemonType.WATER, PokemonType.ICE, 157, 175, 112, "../images/lapras_icon.png","../images/lapras_sprite.png" );
		Pokemon dragonite = new Pokemon("Dragonite", 292, PokemonType.DRAGON, PokemonType.FLYING, 245, 184, 148, "../images/dragonite_icon.png","../images/dragonite_sprite.png" );
		Pokemon scizor = new Pokemon("Scizor", 250, PokemonType.BUG, PokemonType.STEEL, 238, 184, 121, "../images/scizor_icon.png", "../images/scizor_sprite.png" );
		Pokemon snorlax = new Pokemon("Snorlax", 430, PokemonType.NORMAL, 202, 202, 58, "../images/snorlax_icon.png", "../images/snorlax_sprite.png" );
		
		//criar moves
		PokemonMove psychic = new DamageMove("Psychic" ,120, PokemonType.PSYCHIC, StatusType.DEFAULT, 0, 10);
		PokemonMove dazzlingGleam = new DamageMove("Dazzling Gleam", 90, PokemonType.FAIRY, StatusType.DEFAULT,0, 15);
		PokemonMove shadowBall = new DamageMove("Shadow Ball", 90, PokemonType.GHOST, StatusType.DEFAULT,0, 15);
		PokemonMove calmMind = new MultiplierMove("Calm Mind", "attack", true, 20);
		PokemonMove dracoMeteor = new DamageMove("Draco Meteor", 130, PokemonType.DRAGON, StatusType.DEFAULT, 0, 7);
		PokemonMove thunderWave = new StatusMove("Thunder Wave", PokemonType.ELECTRIC, StatusType.PARALYZE, 90, 20);
		PokemonMove hydroPump = new DamageMove("Hydro Pump", 130, PokemonType.WATER, StatusType.DEFAULT, 0, 7);
		PokemonMove sludgeBomb = new DamageMove("Sludge Bomb", 90, PokemonType.POISON, StatusType.POISON, 30, 10);
		PokemonMove gigaDrain = new DamageMove("Giga Drain", 75, PokemonType.GRASS, StatusType.DEFAULT, 0, 15);
		PokemonMove growth = new MultiplierMove("Growth", "attack", true, 20);
		PokemonMove sleepPoweder = new StatusMove("Sleep Powder", PokemonType.POISON, StatusType.SLEEP, 75, 7 );
		PokemonMove freezeDry = new DamageMove("Freeze Dry", 75, PokemonType.ICE, StatusType.FREEZE, 10, 15);
		PokemonMove hypnosis = new StatusMove("Hypnosis", PokemonType.PSYCHIC, StatusType.SLEEP, 60, 7);
		PokemonMove moonBlast = new DamageMove("Moonblast", 100 , PokemonType.FAIRY, StatusType.DEFAULT, 0 , 10);
		PokemonMove earthquake = new DamageMove("Earthquake", 100, PokemonType.GROUND, StatusType.DEFAULT, 0, 10);
		PokemonMove crunch = new DamageMove("Crunch", 90, PokemonType.DARK, StatusType.DEFAULT, 0, 15);
		PokemonMove stoneEdge = new DamageMove("Stone Edge", 100, PokemonType.ROCK, StatusType.DEFAULT, 0, 10 );
		PokemonMove firePunch = new DamageMove("Fire Punch", 75, PokemonType.FIRE, StatusType.DEFAULT, 0, 15);
		PokemonMove fireBlast = new DamageMove("Fire Blast", 120, PokemonType.FIRE, StatusType.BURN, 10, 7);
		PokemonMove dragonDance = new MultiplierMove("Dragon Dance", "attack", true, 20);
		PokemonMove focusBlast = new DamageMove("Focus Blast", 120, PokemonType.FIGHTING, StatusType.DEFAULT, 0, 7);
		PokemonMove thunderbolt = new DamageMove("Thunderbolt", 90, PokemonType.ELECTRIC, StatusType.PARALYZE, 10, 15);
		PokemonMove signalBeam = new DamageMove("Signal Beam", 75, PokemonType.BUG, StatusType.DEFAULT, 0, 20);
		PokemonMove toxic = new StatusMove("Toxic", PokemonType.POISON, StatusType.POISON, 90, 10);
		PokemonMove iceBeam = new DamageMove("Ice Beam", 90, PokemonType.ICE, StatusType.FREEZE, 10, 15 );
		PokemonMove dualWingBeat = new DamageMove("Dual Wingbeat", 80, PokemonType.FLYING, StatusType.DEFAULT, 0, 20);
		PokemonMove bulletPunch = new DamageMove("Bullet Punch", 80, PokemonType.STEEL, StatusType.DEFAULT, 0, 20);
		PokemonMove knockOff = new DamageMove("Knock Off", 80, PokemonType.DARK, StatusType.DEFAULT, 0, 20);
		PokemonMove xScissor = new DamageMove("X-Scissor", 80, PokemonType.BUG, StatusType.DEFAULT, 0, 20);
		PokemonMove curse = new MultiplierMove("Curse", "defense", true, 20);
		PokemonMove bodySlam = new DamageMove("Body Slam", 85, PokemonType.NORMAL, StatusType.PARALYZE, 10, 15);
		
		//adicionar os moves aos pokemons
		snorlax.addMoves(earthquake, firePunch, curse, bodySlam);
		scizor.addMoves(dualWingBeat, bulletPunch, knockOff, xScissor);
		dragonite.addMoves(iceBeam, dragonDance, dualWingBeat, earthquake);
		lapras.addMoves(thunderbolt, hydroPump, freezeDry, iceBeam);
		jolteon.addMoves(shadowBall, thunderbolt, signalBeam, toxic);
		charizard.addMoves(earthquake, fireBlast, dragonDance, focusBlast);
		tyranitar.addMoves(earthquake, crunch, stoneEdge, firePunch);
		ninetailsAlola.addMoves(dazzlingGleam, freezeDry, hypnosis, moonBlast);
		venausaur.addMoves(sludgeBomb, gigaDrain, growth, sleepPoweder);
		dragapult.addMoves(shadowBall, dracoMeteor, thunderWave, hydroPump);
		espeon.addMoves(psychic, dazzlingGleam, shadowBall, calmMind);
		
		//adicionar os pokemons à lista
		pokemonPool.add(snorlax);
		pokemonPool.add(scizor);
		pokemonPool.add(dragonite);
		pokemonPool.add(jolteon);
		pokemonPool.add(charizard);
		pokemonPool.add(tyranitar);
		pokemonPool.add(ninetailsAlola);
		pokemonPool.add(venausaur);
		pokemonPool.add(dragapult);
		pokemonPool.add(espeon);
		
		
		return pokemonPool;
	}
}
