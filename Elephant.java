import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Elephant extends Actor
{

    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idle = new GreenfootImage[8];
    
    public Elephant()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
        }
    }
    
    int imageIndex = 0;
    public void animate()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    public void act()
    {
        
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        } 
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        
        animate();
        eat();
    }
    
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld)getWorld();
            world.createApple();
            elephantSound.play();
        }
    }
}
