package projecto_final_2021_B;

public class MultiplierMove implements PokemonMove {
	

	private String multiplierType;
	private boolean self;
	private int powerPoints;
	private String name;
	
	public MultiplierMove(String name, String multiplierType, boolean self, int powerPoints) {
		this.name = name;
		this.powerPoints= powerPoints;
		this.multiplierType = multiplierType;
		this.self = self;
	}

	@Override
	public void execute(Pokemon source, Pokemon target) {
		if(self) {
			if(multiplierType.equalsIgnoreCase("damage") && source.getDamageMultiplier() < 3f)
				{
				source.setDamageMultiplier(source.getDamageMultiplier()+0.5f);
				System.out.println(source.name + " damage has increased");
				}
				
			if(multiplierType.equalsIgnoreCase("defense") && source.getDefenseMultiplier() < 3f)
				{
				source.setDefenseMultiplier(source.getDefenseMultiplier()+0.5f);
				System.out.println(source.name + " defense has increased");
				}
			if(multiplierType.equalsIgnoreCase("speed") && source.getSpeedMultiplier() < 3f)
				{
				source.setSpeedMultiplier(source.getSpeedMultiplier()+0.5f);
				System.out.println(source.name + " speed has increased");
				}
			powerPoints--;
		}
		
		else {
			if(multiplierType.equalsIgnoreCase("damage") && target.getDamageMultiplier() > 0.25f)
				target.setDamageMultiplier(target.getDamageMultiplier()-0.25f);
			if(multiplierType.equalsIgnoreCase("defense") && target.getDefenseMultiplier() > 0.25f)
				target.setDefenseMultiplier(target.getDefenseMultiplier()-0.25f);
			if(multiplierType.equalsIgnoreCase("speed") && target.getSpeedMultiplier() > 0.25f)
				source.setSpeedMultiplier(target.getSpeedMultiplier() - 0.25f);
			powerPoints--;
		}

	}
	
	public int getPowerPoints() {
		return this.powerPoints;
	}
	
	public String getName() {
		return this.name;
	}

}
