import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Power here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Power extends Actor
{
    /**
     * Act - do whatever the Power wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(),getY()+1);
        givePower();
        delete();
    }
    public void givePower()
    {
        if(isTouching(Platform.class))
        {
            getWorld().getObjects(Ball.class).get(0).move *= 1.5;
            getWorld().removeObject(this);
        }
    }
    public void delete()
    {
        if(getWorld()!=null)
        {
            if(getY()==399 || getWorld().getObjects(Ball.class).get(0).clicks == 0)
            {
                getWorld().removeObject(this);
            }
        }
    }
}
