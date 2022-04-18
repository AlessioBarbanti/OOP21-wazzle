package wazzle.controller.maingame;

import java.util.Optional;
import java.util.Set;

import javafx.util.Pair;
import wazzle.controller.common.WazzleController;
import wazzle.model.common.Dictionary;
import wazzle.model.maingame.Difficulty;
import wazzle.model.maingame.MainGame;

public interface MainGameController {
	Optional<MainGame> getGame();
	
	void startNewGame(final Dictionary dataset, final Pair<Integer,Integer> gridShape, final Difficulty difficulty);
	
	void endGame();
	
	boolean attempt(final String word);
	
	boolean needHelp();
	
	boolean areWeDone();
	
	void useScoreBonus();
	
	void useTimeBonus();
	
	Set<String> useWordBonus();
	
	WazzleController getMainController();
	
	String longestWord();
	
	String highestScoreWord();
	
	void startTimer();
	
	void stopTimer();
	
	long getRemainingTime();
}