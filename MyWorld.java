import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        // Create label
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        
        createApple();
    }
    
    /**
     * Spawn apple at random location
     */
    public void createApple() {
        Apple apple = new Apple();
        addObject(apple, Greenfoot.getRandomNumber(600), 0);      
    }
    
    /**
     * Display game over
     */
    public void gameOver() {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
        
    /**
     * Increase Score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
}
