import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    Ball ball;
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Text(Ball b)
    {
        ball = b;
    }
    public void act() 
    {
        getWorld().showText("<3 ".repeat(ball.getLives()),45,390);
        getWorld().showText("Score: ",535,390);
        getWorld().showText(Integer.toString(ball.getScore()),581,390);
    }    
}
