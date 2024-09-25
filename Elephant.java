import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    SimpleTimer timer = new SimpleTimer();
    String facing = "right";
    
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
        }
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
        }
            timer.mark();
            setImage(idleRight[0]);
    }

    int imageIndex = 0;
    public void animate()
    {
        if(timer.millisElapsed() < 100)
        {
            return;
        }
        timer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }

    public void act()
    {

        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-5);
            facing = "left";
        } 
        else if(Greenfoot.isKeyDown("right"))
        {
            move(5);
            facing = "right";
        }

        animate();
        checkFoodCollision();
    }

    public void checkFoodCollision()
    {
        Actor actor = getOneIntersectingObject(Food.class); // Might be null
        if(actor != null) {
            Food food = (Food) actor;
            MyWorld world = (MyWorld) getWorld();
            elephantSound.play();
            world.increaseScore(food.value);
            getWorld().removeObject(food);
            world.spawnFood();
        }

    }
}
