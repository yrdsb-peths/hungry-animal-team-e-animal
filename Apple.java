import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Apple extends Food implements Movable
{
    public Apple() {
        super(2);
        GreenfootImage apple = new GreenfootImage("images/apple.png");
        apple.scale(40, 40);
        setImage(apple);
    }

    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move();
        
        // Remove apple if reached end
        MyWorld world = (MyWorld) getWorld();
        if (getY() >= world.getHeight()) {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void move()
    {
       setLocation(getX(), getY() + this.getValue()); 
    }
}
