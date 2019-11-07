import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GreenfootImage back = new GreenfootImage("background.png");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, true);
        Ball ball = new Ball();
        setBackground(back);
        for (int i = 45; i < 600; i += 85)
        {
            addObject(new Blocks(1),i,190);
            addObject(new Blocks(2),i,165);
            addObject(new Blocks(3),i,140);
            addObject(new Blocks(4),i,115);
            addObject(new Blocks(5),i,90);
            addObject(new Blocks(6),i,65);
        }
        addObject(ball,300,345);
        addObject(new Platform(),300,370);
        addObject(new Text(ball),0,0);
        setActOrder(Ball.class,Blocks.class,Power.class,Platform.class,Text.class);
        setPaintOrder(victoryText.class,Text.class,Blocks.class,Platform.class,Ball.class,Power.class);
    }
}
