import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Elephant extends Actor implements Movable
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    SimpleTimer timer = new SimpleTimer();
    String facing = "right";
    
    public Elephant()
    {
        // Add animation images to arrays
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
    public void move()
    {
        // Mark the timer every 100ms
        if(timer.millisElapsed() < 100)
        {
            return;
        }
        timer.mark();
        
        // Switch animation depending on facing which side
        if (facing.equals("right"))
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

    public void teleport()
    {
        if(getX() == 0)
        {
            setLocation(600, getY());
        } else
        if (getX() == 600) {
            setLocation(0, getY());
        }
    }
    
    public void act()
    {
        // Move the elephant depending on which key is pressed
        if (Greenfoot.isKeyDown("left"))
        {
            move(-4);
            facing = "left";
        } 
        else if (Greenfoot.isKeyDown("right"))
        {
            move(4);
            facing = "right";
        }

        checkFoodCollision();
        move();
        teleport();
    }

    /**
     * Check for food collision, and increase score/remove food if hit
     */
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
