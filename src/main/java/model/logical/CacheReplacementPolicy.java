package model.logical;

public interface CacheReplacementPolicy{
	void add(String word);
	String remove(); 
}
