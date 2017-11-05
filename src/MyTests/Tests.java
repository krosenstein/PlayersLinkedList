package MyTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import PlayerLinkedList.PlayerLinkedList;

public class Tests {

	@Test
	public void testPlayerLinkedList() {
		PlayerLinkedList list = new PlayerLinkedList();   
		list.addPlayer("Leonel Messi", "Forward");   
		list.addPlayer("Ousmane Dembele", "Forward");   
		list.addPlayer("Luis Suarez", "Forward");   
		list.addPlayer("Paulinho", "Midfielder");   
		list.addPlayer("Gerard Pique", "Defender");   
		list.addPlayer("Nelson Semedo", "Defender");   
		list.addPlayer("Andres Iniesta", "Midfielder");   
		list.addPlayer("Arda Turan", "Midfielder");   
		list.addPlayer("Gerard Deulofeu", "Forward");   
		list.addPlayer("Rafinha", "Midfielder");   
		list.addPlayer("Andre Gomes", "Midfielder");   
		list.addPlayer("Ivan Rakitic", "Midfielder"); 
		list.addPlayer("Sergi Roberto", "Midfielder"); 
		list.addPlayer("Marc-Andre ter Stergen", "Goalkeeper");
		list.addPlayer("Aleix Vidal", "Midfielder");  
		list.addPlayer("Samuel Umtiti", "Defender"); 
		list.addPlayer("Sergio Busquets", "Midfielder"); 
		list.addPlayer("Denis Suarez", "Midfielder");  
		list.addPlayer("Javier Mascherano", "Defender");  
		list.addPlayer("Thomas Vermaelen", "Defender");  
		list.addPlayer("Lucas Digne", "Defender");  
		list.addPlayer("Jordi Alba", "Defender");  
		list.addPlayer("Paco Alcacer", "Forward");  
		list.addPlayer("Jasper Cillessen", "Goalkeeper");    
		
		list.scoreGoal("Lionel Messi");   
		list.scoreGoal("Lionel Messi");  
		list.scoreGoal("Lionel Messi");  
		list.scoreGoal("Lionel Messi");  
		list.scoreGoal("Lionel Messi");  
		list.scoreGoal("Sergi Roberto");  
		list.scoreGoal("Sergi Roberto");   
		list.scoreGoal("Luis Suarez");   
		list.scoreGoal("Luis Suarez");  
		list.scoreGoal("Luis Suarez"); 
		list.scoreGoal("Andres Iniesta"); 
		list.scoreGoal("Andres Iniesta");  
		list.scoreGoal("Sergio Busquets");  
		list.scoreGoal("Gerard Pique");     
		
		assertTrue(list.getGoals("Leonel Messi") == 2);
		assertTrue(list.getGoals("Gerard Pique") == 1);
		assertTrue(list.getGoals("Jordi Alba") == 0);
		
		assertTrue(list.getPosition("Leonel Messi").equals(list.getPosition("Luis Suarez")));
		assertFalse(list.getPosition("Gerard Pique").equals(list.getPosition("Luis Suarez")));
		assertTrue(list.getPosition("Jasper Cillessen").equals(list.getPosition("Marc-Andre ter Stergen")));
		
		assertEquals(list.getTeamSize(), 24);
		
		list.remove("Arda Turan");
		assertEquals(list.getTeamSize(), 23);
		
		ArrayList<String> arr = new ArrayList<>();
		arr.add("Jasper Cillessen");
		arr.add("Marc-Andre ter Stergen");
		for (int i = 0; i < arr.size(); i++) {
			assertTrue(arr.get(i).equals(list.getPlayersWithPosition("Goalkeeper").get(i)));
		}
		
		ArrayList<String> arr2 = new ArrayList<>();
		arr.add("Lionel Messi");
		arr.add("Luis Suarez");
		for (int i = 0; i < arr.size(); i++) {
			assertTrue(arr.get(i).equals(list.getPlayersWithMoreGoals(3)));
		}
	}

}
