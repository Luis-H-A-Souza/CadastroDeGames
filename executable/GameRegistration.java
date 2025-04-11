package executable;

import java.util.Scanner;

public class GameRegistration {
	private Node first = null;
	private Node last = null;
	private Node current;

	Scanner sc = new Scanner(System.in);

	public Node getCurrent() {
		return current;
	}

	public void add() {
		Node node = new Node();
		System.out.print("\n=== REGISTER GAME ===\nInform your game's name: ");
		String name = sc.nextLine();
		System.out.print("\nInform your game's genre: ");
		String genre = sc.nextLine();
		System.out.print("\nInform your game's release Year: ");
		int releaseYear = sc.nextInt();
		System.out.println("\nDoes it have online services? (Y/N)");
		String online;
		do {
			online = sc.next();
			if (!online.equalsIgnoreCase("Y") && !online.equalsIgnoreCase("N")) {
				System.out.print("\nType only 'Y' or 'N': ");
			}
		} while (!online.equalsIgnoreCase("Y") && !online.equalsIgnoreCase("N"));
		Game game = new Game(name, genre, releaseYear, (online.toUpperCase().equalsIgnoreCase("Y") ? true : false));
		node.setValue(game);
		System.out.println("\n" + name + " registered successfully!");
		sc.nextLine();

		if (first == null) {
			first = node;
			last = node;
		} else {
			last.setNext(node);
			last = node;
		}
	}

	public boolean isNext() {
		if (first == null) {
			return false;
		} else if (current == null) {
			current = first;
			return true;
		} else {
			boolean isNext = current.getNext() != null ? true : false;
			current = current.getNext();
			return isNext;
		}
	}

	private Node recoverPenultimate(Node node) {
		if (node.getNext().equals(last)) {
			return node;
		} else {
			return recoverPenultimate(node.getNext());
		}
	}

	public void remove() {
		if (first == null) {
			System.out.println("\nList is empty!");
		} else if (first.getNext() == null) {
			System.out.println("\n" + last.getValue().getName() + " Deleted successfully!");
			first = last = null;
		} else {
			System.out.println("\n" + last.getValue().getName() + " Deleted successfully!");
			Node node = recoverPenultimate(first);
			last = node;
			last.setNext(null);
		}
	}

	public void displayList() {
		if (first != null) {
			System.out.println("\n=== GAME LIST ===\nName | Genre | Release Year | Campaign\n");
			while (isNext()) {
				System.out.println(current.getValue().getName() + " | " + current.getValue().getGenre() + " | "
						+ current.getValue().getReleaseYear() + " | "
						+ (current.getValue().isOnline() ? "Multiplayer" : "Singleplayer"));
			}
		} else {
			System.out.println("\nList is empty!");
		}
	}

	public void startProgram() {
		boolean op = true;
		while (op) {
			System.out.print(
					"\n=== GAMER LIST ===\n1 - Add Game\n2 - Remove Game\n3 - Display Games\n0 - Close Program\n\nChoose an option: ");
			int n = sc.nextInt();
			sc.nextLine();
			switch (n) {
			case 1:
				add();
				break;

			case 2:
				remove();
				break;

			case 3:
				displayList();
				break;

			case 0:
				op = false;
				System.out.println("\nEnding Program...");
				break;

			default:
				System.out.println("\nInform a valid code!");
				break;
			}
			if (op == true) {
				System.out.println("\nPress Enter to continue!");
				sc.nextLine();
			}

		}
	}
}
