import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
        
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        } 
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        eat();
    }
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
        }
    }
}
