package projecto_final_2021_B;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pokemon {
	final public String name;
	private int hp;
	public List<PokemonType> types = new ArrayList<PokemonType>();
	public List<PokemonMove> moves = new ArrayList<PokemonMove>();
	private StatusType status = StatusType.DEFAULT;
	private Float damageMultiplier = 1f;
	private Float defenseMultiplier = 1f;
	private Float speedMultiplier = 1f;
	private int defense;
	private int attack;
	private int speed;
	private TypeManager typeManager = new TypeManager();
	private int sleepCounter = 0;
	final public String iconPath;
	final public String spritePath;
	final public int maxHP;
	
	
	public Pokemon(String name, int hp, PokemonType type, int defense, int attack, int speed, String iconPath, String spritePath  ) {
		this.name = name;
		if(hp < 1)
			throw new IllegalArgumentException("Hp needs to be at least 1");
		this.hp = hp;
		this.maxHP = hp;
		this.types.add(type);
		if(defense < 0)
			throw new IllegalArgumentException("Defense has to be positive");
		this.defense = defense;
		if(attack < 0)
			throw new IllegalArgumentException("Attack has to be positive");
		this.attack = attack;
		if(speed < 0)
			throw new IllegalArgumentException("Attack has to be positive");
		this.speed = speed;
		this.iconPath = iconPath;
		this.spritePath = spritePath;
	}
	
	public Pokemon(String name, int hp, PokemonType type1, PokemonType type2 , int defense, int attack, int speed, String iconPath, String spritePath  ) {
		this.name = name;
		if(hp < 1)
			throw new IllegalArgumentException("Hp needs to be at least 1");
		this.hp = hp;
		this.maxHP = hp;
		this.types.add(type1);
		this.types.add(type2);
		if(defense < 0)
			throw new IllegalArgumentException("Defense has to be positive");
		this.defense = defense;
		if(attack < 0)
			throw new IllegalArgumentException("Attack has to be positive");
		this.attack = attack;
		if(speed < 0)
			throw new IllegalArgumentException("Attack has to be positive");
		this.speed = speed;
		this.iconPath = iconPath;
		this.spritePath = spritePath;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public boolean isFainted() {
		if(hp == 0)
			return true;
		else return false;
	}
	
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	public StatusType getStatus() {
		return this.status;
	}
	
	public int getDefense() {
		return this.defense;
	}
	
	public int getAttack() {
		return this.attack;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setDefenseMultiplier(float defenseMultiplier) {
		this.defenseMultiplier = defenseMultiplier;
	}
	
	public void setDamageMultiplier(float damageMultiplier) {
		this.damageMultiplier = damageMultiplier;
	}
	
	public void setSpeedMultiplier(float speedMultiplier) {
		this.speedMultiplier = speedMultiplier;
	}
	
	public Float getDefenseMultiplier() {
		return this.defenseMultiplier;
	}
	
	public Float getDamageMultiplier() {
		return this.damageMultiplier;
	}
	
	public Float getSpeedMultiplier() {
		return this.speedMultiplier;
	}
	
	public void printMoves() {
		for(int i = 0 ; i < this.moves.size(); i++) {
			System.out.println(i + " " + moves.get(i).getName() + " ( " + "PP / " + moves.get(i).getPowerPoints() + " )");
		}
	}

	
	public HashMap<PokemonType, Float> getResistances(){
		HashMap<PokemonType, Float> finalResistances = new HashMap<PokemonType, Float>();
		HashMap<PokemonType, Float> aux;
		for(PokemonType type : types) {
			aux = typeManager.getResistances(type);
			for(Map.Entry<PokemonType, Float> a : aux.entrySet()) {
				if(finalResistances.isEmpty() ||  finalResistances.containsKey(a.getKey())  )
					finalResistances.put(a.getKey(), a.getValue()*0.5f);
				if(finalResistances.isEmpty() ||  !finalResistances.containsKey(a.getKey())  )
					finalResistances.put(a.getKey(), a.getValue());
				
			}
		}
		return finalResistances;
	}
	
	public List<PokemonType> getWeaknesses(){
		List<PokemonType> finalWeaknesses = new ArrayList<>();
		List<PokemonType> aux = new ArrayList<>();
		for(PokemonType type : types) {
			aux = typeManager.getWeakness(type);
			for(PokemonType weakType : aux) {
				if(!finalWeaknesses.contains(weakType))
					finalWeaknesses.add(weakType);				
			}
		}
		return finalWeaknesses;
	}
	
	public void addMoves(PokemonMove move1, PokemonMove move2, PokemonMove move3, PokemonMove move4) {
		if(moves.isEmpty()) {
			moves.add(move1);
			moves.add(move2);
			moves.add(move3);
			moves.add(move4);
		}
		else throw new IllegalArgumentException("Pokemon already has 4 moves");

	}
	
	
	public void endStatusEffect() {
		if(this.status == StatusType.POISON || this.status == StatusType.BURN )
			{
			System.out.println(this.name + " lost hp due to it's status condition!");
			setHp((int)(hp - (hp*0.125)));
			}
		if(this.status == StatusType.PARALYZE)
			this.speed = (int) (this.speed * 0.5);
	}
	
	public boolean startStatusEffect() {
		if(this.status == StatusType.PARALYZE)
			{
			int paralyzeChance = (int) (Math.random()*100);
			if(paralyzeChance < 25)
				{
				System.out.println(this.name + "  is paralyzed and can't move!");
				return false;
				}
			else
				return true;
			}

		if(this.status == StatusType.SLEEP) {
			int wakeUpChance = (int) (Math.random()*100);
			if(wakeUpChance < 20 || sleepCounter == 3)
				{
				System.out.println(this.name + " woke up!");
				this.status = StatusType.DEFAULT;
				return true;
				}
			else {
				System.out.println(this.name + " is still fast asleep!");
				sleepCounter++;
				return false;
			}
		}
		if(this.status == StatusType.FREEZE) {
			int defrostChance = (int) (Math.random()*100);
			if(defrostChance < 20 )
				{
				System.out.println(this.name + " has defrosted!");
				this.status = StatusType.DEFAULT;
				return true;
				}
			else
				{
				System.out.println(this.name + "is frozen!");
				return false;
				}
		}
		return true;
	}
	
	public boolean equals(Pokemon pokemon) {
		if(pokemon.name.equalsIgnoreCase(this.name))
			return true;
		return false;
	}
	
	public Pokemon clone() {
		Pokemon clone = this;
		return clone;
	}
	
	public void print() {
		if(this.status == StatusType.DEFAULT)
			System.out.println(this.name + " / " + this.getHp());
		else
			System.out.println(this.name + " / " + this.getHp() + " / " + this.status.toString());
	}
	
	public static void main(String[] args) {
		Pokemon espeon = new Pokemon("Espeon", 240, PokemonType.PSYCHIC, 238, 175, 202, "../images/espeon_icon.gif", "../images/espeon_sprite.png" );
		PokemonMove psychic = new DamageMove("Psychic" ,120, PokemonType.PSYCHIC, StatusType.DEFAULT, 0, 10);
		PokemonMove dazzlingGleam = new DamageMove("Dazzling Gleam", 90, PokemonType.FAIRY, StatusType.DEFAULT,0, 15);
		PokemonMove shadowBall = new DamageMove("Shadow Ball", 90, PokemonType.GHOST, StatusType.DEFAULT,0, 15);
		PokemonMove calmMind = new MultiplierMove("Calm Mind", "attack", true, 20);
		espeon.addMoves(psychic, dazzlingGleam, shadowBall, calmMind);
		
		espeon.printMoves();
	}
	
	
	
	
}
