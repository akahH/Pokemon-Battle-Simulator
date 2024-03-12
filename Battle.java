package projecto_final_2021_B;

import java.util.List;
import java.util.Scanner;

public class Battle {

	private static PokemonPool pokemonPool = new PokemonPool();
	private static List<Pokemon> pokemonList = pokemonPool.pokemonPool();
	private static PlayerTrainer trainer;
	private static AITrainer aiTrainer;
	private static Pokemon trainerPokemon;
	private static Pokemon aiTrainerPokemon;
	private static boolean endBattle;
	private static Scanner in;
	


	public static void fight(PokemonMove move, PlayerTrainer trainerA, AITrainer trainerB) {
		trainer = trainerA;
		aiTrainer = trainerB;
		trainerPokemon = trainer.getActivePokemon();
		aiTrainerPokemon = aiTrainer.getActivePokemon();
		printActivePokemon();

			
			PokemonMove trainerMove = move;
			PokemonMove aiTrainerMove = aiTrainer.chooseMove();
			
			boolean trainerPokemonCanMove = trainerPokemon.startStatusEffect();
			boolean aiTrainerPokemonCanMove = aiTrainerPokemon.startStatusEffect();
			
			if(trainerPokemon.getSpeed() > aiTrainerPokemon.getSpeed()) {
				
				if(trainerPokemonCanMove)
					{
					System.out.println(trainer.getActivePokemon().name + " used " + trainerMove.getName());
					trainerMove.execute(trainerPokemon, aiTrainerPokemon);
					}

				printActivePokemon();
				if(aiTrainerPokemon.isFainted()) {
					System.out.println(aiTrainerPokemon.name + " fainted");
					if(checkEnd())
						System.out.println("Battle is over");
					else
						aiTrainer.chooseActivePokemon();
				}
				else {
					System.out.println(aiTrainer.getActivePokemon().name + " used " + aiTrainerMove.getName());
					if(aiTrainerPokemonCanMove)
						{
						System.out.println(aiTrainer.getActivePokemon().name + " used " + aiTrainerMove.getName());
						aiTrainerMove.execute(aiTrainerPokemon , trainerPokemon);
						}

					printActivePokemon();
					if(trainerPokemon.isFainted()) {
						System.out.println(trainerPokemon.name + " fainted");
						if(checkEnd())
							System.out.println("Battle is over");
						else
							changePokemon();
					}
				}
			}
			
			else{
				
				if(aiTrainerPokemonCanMove)
					{
					System.out.println(aiTrainer.getActivePokemon().name + " used " + aiTrainerMove.getName());
					aiTrainerMove.execute(aiTrainerPokemon , trainerPokemon);
					}

				printActivePokemon() ;
				if(trainerPokemon.isFainted()) {
					System.out.println(trainerPokemon.name + " fainted");
					if(checkEnd())
						System.out.println("Battle is over");
					else
						changePokemon();
				}
				else {
					
					if(trainerPokemonCanMove)
						{
						System.out.println(trainer.getActivePokemon().name + " used " + trainerMove.getName());
						trainerMove.execute(trainerPokemon, aiTrainerPokemon);
						
						}

					printActivePokemon() ;
					if(aiTrainerPokemon.isFainted()) {
						System.out.println(aiTrainerPokemon.name + " fainted");
						if(checkEnd())
							System.out.println("Battle is over");
						else
							aiTrainer.chooseActivePokemon();
					}
				}
				
			}
		
		trainerPokemon.endStatusEffect();
		aiTrainerPokemon.endStatusEffect();

	}
	
	public static boolean checkEnd() {
		if(trainer.teamFainted() || aiTrainer.teamFainted())
			endBattle = true;
		return endBattle;
	}
	
	public static void changePokemon() {
		trainer.printTeam();
		int pokemon = in.nextInt();
		if(pokemon > 0 && pokemon < 3 && !trainer.getTeam().get(pokemon).isFainted())
			trainer.chooseActivePokemon(pokemon);
		else
			changePokemon();
	}
	
	private static void printActivePokemon() {
		System.out.println("---------------------------");
		System.out.println("Your Pokemon: ");
		trainerPokemon.print();
		System.out.println();
		System.out.println("Opponent's Pokemon: ");
		aiTrainerPokemon.print();
		System.out.println("---------------------------");
		System.out.println();
	}
	
}
