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
        checkFoodCollision();
    }

    public void checkFoodCollision()
    {
        Actor actor = getOneIntersectingObject(Food.class); // Might be null
        if(actor != null) {
            Food food = (Food) actor;
            MyWorld world = (MyWorld) getWorld();

            //world.increaseScore(food.value);
            getWorld().removeObject(food);
            world.spawnFood();
        }
    }
}
