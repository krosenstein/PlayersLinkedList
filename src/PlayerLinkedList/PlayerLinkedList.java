package PlayerLinkedList;

import java.util.ArrayList;
import java.util.Comparator;

public class PlayerLinkedList {
	int size;
	Player head;
	Player tail;
	
	private class Player {
		String position;
		String name;
		int goals;
		Player next;
		
		public Player(String nameIn, String positionIn) {
			name = nameIn;
			position = positionIn;
			goals = 0;
		}
		public void setNext(Player playerIn) {
			next = playerIn;
		}
	}
	
	private class MyComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return compare(o1, o2);
		}
		
	}
	// Sorted Linked List
	public PlayerLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addPlayer(String name, String position) {
		if (name == null || position == null) 
			throw new IllegalArgumentException();
		MyComparator comparator = new MyComparator();
		Player player = new Player(name, position);
		Player curr = head;
		if (size == 0) {
			head = player;
			tail = player;
		}
		else if (comparator.compare(name, head.name) <= 0) {
			player.setNext(head);
			head = player;
		}
		else if (comparator.compare(name, tail.name) >= 0) {
			tail.setNext(player);
			tail = player;
		}
		else {
			while (curr.next != null) {
				if (comparator.compare(name, curr.next.name) <= 0) {
					Player temp = curr.next;
					
					curr.next = player;
					curr.next.next = temp;
					size++;
				}
				curr = curr.next;
			}
		}
	}
	
	public int getTeamSize() {
		return size;
	}
	
	public void remove(String player) {
		if (player == null)
			throw new IllegalArgumentException();
		Player curr = head;
		Player prev = null;
		if (size == 0)
			return;
		if (head.name.equals(player)) {
			head = curr.next;
			curr = null;
		}
		while (curr != null && curr.name.equals(player)) {
			prev = curr;
			curr = curr.next;
		}
		if (curr == null) {
			return;
		}
		if (curr.next == null) {
			prev.next = null;
			tail = prev;	
		}
		else {
			prev.next = curr.next;
			curr = null;
		}
	}
	
	public void scoreGoal(String player) {
		if (player == null) 
			throw new IllegalArgumentException();
		Player curr = head;
		while (curr != null) {
			if (curr.name.equals(player))
				curr.goals++;
		}
	}
	
	public int getGoals(String player) {
		if (player == null) 
			throw new IllegalArgumentException();
		Player curr = head;
		while (curr != null) {
			if (curr.name.equals(player))
				return curr.goals;
		}
		return -1;
	}
	
	public String getPosition(String player) {
		if (player == null) 
			throw new IllegalArgumentException();
		Player curr = head;
		while (curr != null) {
			if (curr.name.equals(player))
				return curr.position;
		}
		return null;
	}

	public ArrayList<String> getPlayersWithMoreGoals(int goals) {
		if (goals < 0)
			throw new IllegalArgumentException();
		ArrayList<String> players = new ArrayList<>();
		Player curr = head;
		while (curr != null) {
			if (curr.goals >= goals) {
				players.add(curr.name);
			}
		}
		return players;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public ArrayList<String> getPlayersWithPosition(String position) {
		if (position == null)
			throw new IllegalArgumentException();
		ArrayList<String> players = new ArrayList<>();
		Player curr = head;
		while (curr != null) {
			if (curr.position.equals(position)) {
				players.add(curr.name);
			}
		}
		return players;
	}
}
