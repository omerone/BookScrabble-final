package bookScrabble.model.gameLogic;

public interface CacheReplacementPolicy{
	void add(String word);
	String remove(); 
}
