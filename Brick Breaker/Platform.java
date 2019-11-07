;import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Platform()
    {
    }
    public void act() 
    {
        follow();
    } 
    public void follow()
    {
        if (Greenfoot.mouseMoved(null)) 
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse.getX()<84)
            {
                setLocation(84,370);
            }
            else if(mouse.getX()>516)
            {
                setLocation(516,370);
            }
            else
            {
                setLocation(mouse.getX(),370);
            }
        }
    }
}
