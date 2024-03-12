package projecto_final_2021_B;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TypeManager {

	private HashMap<PokemonType, Float> moveEffectiveness;
	private List<PokemonType> weaknesses = new ArrayList<>();
	private HashMap<PokemonType, Float> resistances = new HashMap<>();
	
	public HashMap<PokemonType, Float> getMoveEffectiveness(PokemonType type) {
		moveEffectiveness = new HashMap<>();
		switch(type) {
		case NORMAL:
			moveEffectiveness.put(PokemonType.ROCK, 0.5f);
			moveEffectiveness.put(PokemonType.STEEL, 0.5f);
			moveEffectiveness.put(PokemonType.GHOST, 0f);
			break;
		case BUG:
			moveEffectiveness.put(PokemonType.STEEL, 0.5f);
			moveEffectiveness.put(PokemonType.GHOST, 0.5f);
			moveEffectiveness.put(PokemonType.FIRE, 0.5f);
			moveEffectiveness.put(PokemonType.FIGHTING, 0.5f);
			moveEffectiveness.put(PokemonType.POISON, 0.5f);
			moveEffectiveness.put(PokemonType.FLYING, 0.5f);
			moveEffectiveness.put(PokemonType.FAIRY, 0.5f);
			moveEffectiveness.put(PokemonType.GRASS, 2f);
			moveEffectiveness.put(PokemonType.PSYCHIC, 2f);
			moveEffectiveness.put(PokemonType.DARK, 2f);
			break;
		case DARK:
			moveEffectiveness.put(PokemonType.PSYCHIC, 2f);
			moveEffectiveness.put(PokemonType.DARK, 0.5f);
			moveEffectiveness.put(PokemonType.GHOST, 2f);
			moveEffectiveness.put(PokemonType.FAIRY, 0f);
			moveEffectiveness.put(PokemonType.FIGHTING, 0.5f);
			break;
		case DRAGON:
			moveEffectiveness.put(PokemonType.DRAGON, 2f);
			moveEffectiveness.put(PokemonType.STEEL, 0.5f);
			moveEffectiveness.put(PokemonType.FAIRY, 0f);
			break;
		case ELECTRIC:
			moveEffectiveness.put(PokemonType.WATER, 2f);
			moveEffectiveness.put(PokemonType.FLYING, 2f);
			moveEffectiveness.put(PokemonType.GROUND, 0f);
			moveEffectiveness.put(PokemonType.ELECTRIC, 0.5f);
			moveEffectiveness.put(PokemonType.DRAGON, 0.5f);
			break;
		case FAIRY:
			moveEffectiveness.put(PokemonType.DARK, 2f);
			moveEffectiveness.put(PokemonType.FIGHTING, 2f);
			moveEffectiveness.put(PokemonType.DRAGON, 2f);
			moveEffectiveness.put(PokemonType.STEEL, 0.5f);
			moveEffectiveness.put(PokemonType.POISON, 0.5f);
			moveEffectiveness.put(PokemonType.FIRE, 0.5f);
			break;
		case FIGHTING:
			moveEffectiveness.put(PokemonType.NORMAL, 2f);
			moveEffectiveness.put(PokemonType.ROCK, 2f);
			moveEffectiveness.put(PokemonType.STEEL, 2f);
			moveEffectiveness.put(PokemonType.ICE, 2f);
			moveEffectiveness.put(PokemonType.DARK, 2f);
			moveEffectiveness.put(PokemonType.DARK, 0.5f);
			moveEffectiveness.put(PokemonType.FAIRY, 0.5f);
			moveEffectiveness.put(PokemonType.FLYING, 0.5f);
			moveEffectiveness.put(PokemonType.BUG, 0.5f);
			moveEffectiveness.put(PokemonType.POISON, 0.5f);
			moveEffectiveness.put(PokemonType.GHOST, 0f);
			break;
		case FIRE:
			moveEffectiveness.put(PokemonType.WATER, 0.5f);
			moveEffectiveness.put(PokemonType.FIRE, 0.5f);
			moveEffectiveness.put(PokemonType.ROCK, 0.5f);
			moveEffectiveness.put(PokemonType.DRAGON, 0.5f);
			moveEffectiveness.put(PokemonType.GRASS, 2f);
			moveEffectiveness.put(PokemonType.BUG, 2f);
			moveEffectiveness.put(PokemonType.ICE, 2f);
			moveEffectiveness.put(PokemonType.STEEL, 2f);
			break;
		case FLYING:
			moveEffectiveness.put(PokemonType.FIGHTING, 2f);
			moveEffectiveness.put(PokemonType.GRASS, 2f);
			moveEffectiveness.put(PokemonType.BUG, 2f);
			moveEffectiveness.put(PokemonType.STEEL, 0.5f);
			moveEffectiveness.put(PokemonType.ROCK, 0.5f);
			moveEffectiveness.put(PokemonType.ELECTRIC, 0.5f);
			break;
		case GHOST:
			moveEffectiveness.put(PokemonType.PSYCHIC, 2f);
			moveEffectiveness.put(PokemonType.GHOST, 2f);
			moveEffectiveness.put(PokemonType.DARK, 0.5f);
			moveEffectiveness.put(PokemonType.NORMAL, 0f);
			break;
		case GRASS:
			moveEffectiveness.put(PokemonType.WATER, 2f);
			moveEffectiveness.put(PokemonType.ROCK, 2f);
			moveEffectiveness.put(PokemonType.GROUND, 2f);
			moveEffectiveness.put(PokemonType.STEEL, 0.5f);
			moveEffectiveness.put(PokemonType.FIRE, 0.5f);
			moveEffectiveness.put(PokemonType.BUG, 0.5f);
			moveEffectiveness.put(PokemonType.POISON, 0.5f);
			moveEffectiveness.put(PokemonType.DRAGON, 0.5f);
			moveEffectiveness.put(PokemonType.FLYING, 0.5f);
			moveEffectiveness.put(PokemonType.GRASS, 0.5f);
			break;
		case GROUND:
			moveEffectiveness.put(PokemonType.ELECTRIC, 2f);
			moveEffectiveness.put(PokemonType.FIRE, 2f);
			moveEffectiveness.put(PokemonType.STEEL, 2f);
			moveEffectiveness.put(PokemonType.ROCK, 2f);
			moveEffectiveness.put(PokemonType.POISON, 2f);
			moveEffectiveness.put(PokemonType.GRASS, 0.5f);
			moveEffectiveness.put(PokemonType.BUG, 2f);
			moveEffectiveness.put(PokemonType.FLYING, 0f);
			break;
		case ICE:
			moveEffectiveness.put(PokemonType.DRAGON, 2f);
			moveEffectiveness.put(PokemonType.FLYING, 2f);
			moveEffectiveness.put(PokemonType.GRASS, 2f);
			moveEffectiveness.put(PokemonType.GROUND, 2f);
			moveEffectiveness.put(PokemonType.FIRE, 0.5f);
			moveEffectiveness.put(PokemonType.WATER, 0.5f);
			moveEffectiveness.put(PokemonType.STEEL, 0.5f);
			moveEffectiveness.put(PokemonType.ICE, 0.5f);
			break;
		case POISON:
			moveEffectiveness.put(PokemonType.FAIRY, 2f);
			moveEffectiveness.put(PokemonType.GRASS, 2f);
			moveEffectiveness.put(PokemonType.DARK, 0.5f);
			moveEffectiveness.put(PokemonType.POISON, 0.5f);
			moveEffectiveness.put(PokemonType.ROCK, 0.5f);
			moveEffectiveness.put(PokemonType.GHOST, 0.5f);
			moveEffectiveness.put(PokemonType.STEEL, 0f);
			break;
		case PSYCHIC:
			moveEffectiveness.put(PokemonType.FIGHTING, 2f);
			moveEffectiveness.put(PokemonType.POISON, 2f);
			moveEffectiveness.put(PokemonType.PSYCHIC, 0.5f);
			moveEffectiveness.put(PokemonType.STEEL, 0.5f);
			moveEffectiveness.put(PokemonType.DARK, 0f);
			break;
		case ROCK:
			moveEffectiveness.put(PokemonType.FLYING, 2f);
			moveEffectiveness.put(PokemonType.ICE, 2f);
			moveEffectiveness.put(PokemonType.FIRE, 2f);
			moveEffectiveness.put(PokemonType.GRASS, 0.5f);
			moveEffectiveness.put(PokemonType.STEEL, 0.5f);
			moveEffectiveness.put(PokemonType.FIGHTING, 0.5f);
			break;
		case STEEL:
			moveEffectiveness.put(PokemonType.FAIRY, 2f);
			moveEffectiveness.put(PokemonType.ROCK, 2f);
			moveEffectiveness.put(PokemonType.ICE, 2f);
			break;
		case WATER:
			moveEffectiveness.put(PokemonType.FIRE, 2f);
			moveEffectiveness.put(PokemonType.ROCK, 2f);
			moveEffectiveness.put(PokemonType.GROUND, 2f);
			moveEffectiveness.put(PokemonType.GRASS, 0.5f);
			moveEffectiveness.put(PokemonType.DRAGON, 0.5f);
			moveEffectiveness.put(PokemonType.WATER, 0.5f);
			break;
		}
		
		
		return moveEffectiveness;
		
	}
	
	public List<PokemonType> getWeakness(PokemonType type) {

		switch(type) {
		case NORMAL:
			weaknesses.add(PokemonType.FIGHTING);
			break;
		case BUG:
			weaknesses.add(PokemonType.FIRE);
			weaknesses.add(PokemonType.FLYING);
			weaknesses.add(PokemonType.ROCK);
			break;
		case DARK:
			weaknesses.add(PokemonType.FIGHTING);
			weaknesses.add(PokemonType.BUG);
			weaknesses.add(PokemonType.FAIRY);
			break;
		case DRAGON:
			weaknesses.add(PokemonType.FAIRY);
			weaknesses.add(PokemonType.DRAGON);
			weaknesses.add(PokemonType.ICE);
			break;
		case ELECTRIC:
			weaknesses.add(PokemonType.GROUND);
			break;
		case FAIRY:
			weaknesses.add(PokemonType.POISON);
			weaknesses.add(PokemonType.STEEL);
			break;
		case FIGHTING:
			weaknesses.add(PokemonType.FAIRY);
			weaknesses.add(PokemonType.PSYCHIC);
			weaknesses.add(PokemonType.FLYING);
			break;
		case FIRE:
			weaknesses.add(PokemonType.WATER);
			weaknesses.add(PokemonType.ROCK);
			weaknesses.add(PokemonType.GROUND);
			break;
		case FLYING:
			weaknesses.add(PokemonType.ROCK);
			weaknesses.add(PokemonType.ELECTRIC);
			weaknesses.add(PokemonType.ICE);
			break;
		case GHOST:
			weaknesses.add(PokemonType.GHOST);
			weaknesses.add(PokemonType.DARK);
			break;
		case GRASS:
			weaknesses.add(PokemonType.FIRE);
			weaknesses.add(PokemonType.FLYING);
			weaknesses.add(PokemonType.POISON);
			weaknesses.add(PokemonType.BUG);
			weaknesses.add(PokemonType.ICE);
			break;
		case GROUND:
			weaknesses.add(PokemonType.WATER);
			weaknesses.add(PokemonType.ICE);
			weaknesses.add(PokemonType.GRASS);
			break;
		case ICE:
			weaknesses.add(PokemonType.FIGHTING);
			weaknesses.add(PokemonType.FIRE);
			weaknesses.add(PokemonType.ROCK);
			weaknesses.add(PokemonType.STEEL);		
			break;
		case POISON:
			weaknesses.add(PokemonType.GROUND);
			weaknesses.add(PokemonType.PSYCHIC);	
			break;
		case PSYCHIC:
			weaknesses.add(PokemonType.DARK);
			weaknesses.add(PokemonType.BUG);
			weaknesses.add(PokemonType.GHOST);	
			break;
		case ROCK:
			weaknesses.add(PokemonType.WATER);
			weaknesses.add(PokemonType.GRASS);
			weaknesses.add(PokemonType.GROUND);
			weaknesses.add(PokemonType.FIGHTING);
			weaknesses.add(PokemonType.STEEL);	
			break;
		case STEEL:
			weaknesses.add(PokemonType.FIGHTING);
			weaknesses.add(PokemonType.FIRE);
			weaknesses.add(PokemonType.GROUND);
			break;
		case WATER:
			weaknesses.add(PokemonType.GRASS);
			weaknesses.add(PokemonType.ELECTRIC);
			break;
		}
		
		
		return weaknesses;
		
	}
	
public HashMap<PokemonType, Float> getResistances(PokemonType type) {
		resistances = new HashMap<>();
		switch(type) {
		case NORMAL:
			break;
		case BUG:
			resistances.put(PokemonType.GRASS , 0.5f);
			resistances.put(PokemonType.FIGHTING, 0.5f);
			resistances.put(PokemonType.GROUND, 0.5f);
			break;
		case DARK:
			resistances.put(PokemonType.GHOST, 0.5f);
			resistances.put(PokemonType.DARK, 0.5f);
			resistances.put(PokemonType.PSYCHIC, 0f);
			break;
		case DRAGON:
			resistances.put(PokemonType.FIRE, 0.5f);
			resistances.put(PokemonType.WATER, 0.5f);
			resistances.put(PokemonType.GRASS, 0.5f);
			resistances.put(PokemonType.ELECTRIC, 0.5f);
			break;
		case ELECTRIC:
			resistances.put(PokemonType.STEEL, 0.5f);
			resistances.put(PokemonType.FLYING, 0.5f);
			resistances.put(PokemonType.ELECTRIC, 0.5f);
			break;
		case FAIRY:
			resistances.put(PokemonType.DRAGON, 0f);
			resistances.put(PokemonType.DARK, 0.5f);
			resistances.put(PokemonType.FIGHTING, 0.5f);
			resistances.put(PokemonType.BUG, 0.5f);
			break;
		case FIGHTING:
			resistances.put(PokemonType.BUG, 0.5f);
			resistances.put(PokemonType.ROCK, 0.5f);
			resistances.put(PokemonType.DARK, 0.5f);
			break;
		case FIRE:
			resistances.put(PokemonType.FIRE, 0.5f);
			resistances.put(PokemonType.GRASS, 0.5f);
			resistances.put(PokemonType.STEEL, 0.5f);
			resistances.put(PokemonType.BUG, 0.5f);
			resistances.put(PokemonType.ICE, 0.5f);
			resistances.put(PokemonType.FAIRY, 0.5f);
			break;
		case FLYING:
			resistances.put(PokemonType.FIGHTING, 0.5f);
			resistances.put(PokemonType.GRASS, 0.5f);
			resistances.put(PokemonType.BUG, 0.5f);
			resistances.put(PokemonType.GROUND, 0f);
			break;
		case GHOST:
			resistances.put(PokemonType.BUG, 0.5f);
			resistances.put(PokemonType.POISON, 0.5f);
			resistances.put(PokemonType.NORMAL, 0f);
			break;
		case GRASS:
			resistances.put(PokemonType.GRASS, 0.5f);
			resistances.put(PokemonType.ELECTRIC, 0.5f);
			resistances.put(PokemonType.GROUND, 0.5f);
			resistances.put(PokemonType.WATER, 0.5f);
			break;
		case GROUND:
			resistances.put(PokemonType.POISON, 0.5f);
			resistances.put(PokemonType.ROCK, 0.5f);
			resistances.put(PokemonType.ELECTRIC, 0f);
			break;
		case ICE:
			resistances.put(PokemonType.ICE, 0.5f);
			break;
		case POISON:
			resistances.put(PokemonType.POISON, 0.5f);
			resistances.put(PokemonType.FAIRY, 0.5f);
			resistances.put(PokemonType.BUG, 0.5f);
			resistances.put(PokemonType.GRASS, 0.5f);
			resistances.put(PokemonType.FIGHTING, 0.5f);
			break;
		case PSYCHIC:
			resistances.put(PokemonType.FIGHTING, 0.5f);
			resistances.put(PokemonType.PSYCHIC, 0.5f);
			break;
		case ROCK:
			resistances.put(PokemonType.FIRE, 0.5f);
			resistances.put(PokemonType.NORMAL, 0.5f);
			resistances.put(PokemonType.POISON, 0.5f);
			resistances.put(PokemonType.FLYING, 0.5f);
			break;
		case STEEL:
			resistances.put(PokemonType.NORMAL, 0.5f);
			resistances.put(PokemonType.POISON, 0f);
			resistances.put(PokemonType.FLYING, 0.5f);
			resistances.put(PokemonType.PSYCHIC, 0.5f);
			resistances.put(PokemonType.BUG, 0.5f);
			resistances.put(PokemonType.GRASS, 0.5f);
			resistances.put(PokemonType.ICE, 0.5f);
			resistances.put(PokemonType.FAIRY, 0.5f);
			resistances.put(PokemonType.DRAGON, 0.5f);
			break;
		case WATER:
			resistances.put(PokemonType.FIRE, 0.5f);
			resistances.put(PokemonType.WATER, 0.5f);
			resistances.put(PokemonType.STEEL, 0.5f);
			resistances.put(PokemonType.ICE, 0.5f);
			break;
		}
		
		
		return resistances;
		
	}

	
	
}
