package wazzle.model;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.util.Pair;
import wazzle.model.common.Dictionary;
import wazzle.model.common.DictionaryImpl;
import wazzle.model.maingame.Difficulty;
import wazzle.model.maingame.GridGenerator;
import wazzle.model.maingame.GridGeneratorImpl;
import wazzle.model.maingame.GridValidator;
import wazzle.model.maingame.GridValidatorImpl;
import wazzle.model.maingame.Mediator;

public class TestGridGenerator {

	// These tests are used to see how much time it takes to generate a grid of a certain difficulty
	
//	private final Difficulty easy = new Difficulty(351, 500, 240000L);
//	private final Difficulty hard = new Difficulty(250, 350, 180000L);
//	
//	@Test
//	public void testGeneratorEasy() {
//		try {
//			final Dictionary dataset = new DictionaryImpl(".\\src\\test\\res\\datasetNuovo.txt");
//			final GridGenerator generatorEasy = new GridGeneratorImpl(dataset, new Pair<Integer,Integer>(6,6), this.easy);
//			
//			var grid = generatorEasy.generate();
//			System.out.println(grid);
//		
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGeneratorHard() {		
//		try {
//			final Dictionary dataset = new DictionaryImpl(".\\src\\test\\res\\datasetNuovo.txt");
//			final GridGenerator generatorHard = new GridGeneratorImpl(dataset, new Pair<Integer,Integer>(6,6), this.hard);
//			
//			var grid = generatorHard.generate();
//			
//			System.out.println(grid);
//		
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

}
