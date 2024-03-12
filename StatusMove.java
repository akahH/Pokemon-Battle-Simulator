package projecto_final_2021_B;

public class StatusMove implements PokemonMove{

	private PokemonType type;
	private StatusType statusType;
	private int statusChance;
	private int powerPoints;
	public String name;
	
	public StatusMove(String name, PokemonType type, StatusType statusType, int statusChance, int powerPoints) {
		this.name = name;
		this.type = type;
		this.statusType = statusType;
		this.statusChance = statusChance;
		this.powerPoints = powerPoints;
	}
	
	@Override
	public void execute(Pokemon source, Pokemon target) {
		//see if target is immune to move type
		if(target.getResistances().containsKey(type)) {
			if(target.getResistances().get(type) == 0f)
				System.out.println(target.name + " is immune to " + this.type);
		}
		
		//set status
		else
			if((int)(Math.random()*(100 + 1)) < statusChance) {
				target.setStatus(statusType);
				System.out.println(target.name + " has become " + statusType);
			}
				
				
		powerPoints--;
	}
	
	public int getPowerPoints() {
		return this.powerPoints;
	}
	
	public String getName() {
		return this.name;
	}
}
