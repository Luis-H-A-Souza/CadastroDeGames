package executable;

public class Game {
	private String name;
	private String genre;
	private int releaseYear;
	private boolean online;
	
	public Game (String name, String genre, int releaseYear, boolean online) {
		this.name = name;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.online = online;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

}
