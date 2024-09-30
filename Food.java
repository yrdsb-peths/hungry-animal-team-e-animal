import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Food extends Actor implements Movable {
    int value;
    
    public Food(int value) {
        this.value = value;
    }
    
    public abstract void move();
    
    public int getValue()
    {
        return value; 
    }
}
