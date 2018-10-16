
public class Game {
	
	public String scene1() {
		String output = new String();
		output = "You and your team are standing in a forest, near a staircase going deep down underground.\n"
				+ "At the bottom of the stairs is a big, wooden door. Are you ready to enter the dungeon?";
		return output;
	}
	
	public String scene2() {
		String output = new String();
		output = "You open up the door and walk in a dank tomb. A torch is lit by a team mate and you notice a\n"
				+ "large tile on the ground, which looks different from the rest. Are you ready to walk over it?";
		return output;
	}
	
	public String scene3() {
		String output = new String();
		output = "You walk across the tile and you hear a quiet creak coming from it. You hurry over it.\n"
				+ "You have now all crossed the tile and one of your team mates whispers:\n"
				+ "'Shh! Do you hear that?'\n"
				+ "You turn around and see a tall troll. It charges towards you! Get ready to fight!";
		return output;
	}
}
