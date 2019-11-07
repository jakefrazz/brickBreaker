import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Arrays.*;
/**
 * Write a description of class Blocks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blocks extends Actor
{
    int health;
    int worth;
    GreenfootImage one = new GreenfootImage("oneHealth.png");
    GreenfootImage two = new GreenfootImage("twoHealth.png");
    GreenfootImage three = new GreenfootImage("threeHealth.png");
    GreenfootImage four = new GreenfootImage("fourHealth.png");
    GreenfootImage five = new GreenfootImage("fiveHealth.png");
    GreenfootImage six = new GreenfootImage("sixHealth.png");
    GreenfootImage[] colors = {one,two,three,four,five,six};
    /**
     * Act - do whatever the Blocks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Blocks(int h)
    {
        health=h;
        worth=h;
        setImage(colors[health-1]);
    }
    public void act() 
    {
        damageCheck();
    }
    public void changeHealth(int h)
    {
        health = h;
    }
    public int getHealth()
    {
        return health;
    }
    public void damageCheck()
    {
        if (isTouching(Ball.class)) 
        {
            if (health == 1)
            {
                for(Ball ball : getIntersectingObjects(Ball.class))
                {
                    ball.addScore(worth);
                }
                if(Greenfoot.getRandomNumber(100)<=4)
                {
                    getWorld().addObject(new Power(),getX(),getY());
                }
                getWorld().removeObject(this);
            }
            else
            {
                changeHealth(health-1);
                setImage(colors[health-1]);
            }
        }
        
    }
}
