package projecto_final_2021_B;

public class DamageMove implements PokemonMove {

	private int damage;
	private PokemonType type;
	private StatusType statusType;
	private int statusChance;
	private int powerPoints;
	public String name;
	
	public DamageMove(String name, int damage, PokemonType type, StatusType statusType, int statusChance, int powerPoints){
		this.name = name;
		this.damage = damage;
		this.type = type;
		this.statusType = statusType;
		this.statusChance = statusChance;
		this.powerPoints = powerPoints;
	}
	
	@Override
	public void execute(Pokemon source, Pokemon target) {
		int moveDamage = damage;

		
		//apply damage and defense stats/multipliers


		float levelCalcule = (2*100 / 5 + 2);
		float modifiersCalcule = ((moveDamage * source.getAttack()) * source.getDamageMultiplier()) / ((target.getDefenseMultiplier()) * target.getDefense());
		moveDamage = (int) (((levelCalcule * modifiersCalcule)/50) + 2);
		//check if move type is a weakness of target
		for(PokemonType pokemonType : target.getWeaknesses()) {
			if (pokemonType.equals(type))
				moveDamage = (int) (moveDamage * 2f);
		}

		
		//check if move type is a resistance of target
		if(target.getResistances().containsKey(type))
			moveDamage = (int) (moveDamage * target.getResistances().get(type));

		if(source.getStatus() == StatusType.BURN)
			moveDamage = (int) (moveDamage * 0.5);
		
		System.out.println(source.name + " did " + moveDamage + " points of damage");
		//set new hp for target
		if(target.getHp()-moveDamage > 0)
			target.setHp(target.getHp()-moveDamage);
		else target.setHp(0);
		
		
		//set status
		if(statusType != StatusType.DEFAULT)
			if((int)(Math.random()*(100 + 1)) < statusChance)
				target.setStatus(statusType);
		
		powerPoints--;
		
	}
	
	public int getPowerPoints() {
		return this.powerPoints;
	}
	
	public String getName() {
		return this.name;
	}

}
