import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img = getImage();
    int clicks = 0;
    int lives = 3;
    int score = 0;
    int move = 3;
    int pc = 0;
    public void Ball()
    {
    }
    public void act() 
    {
        checkClicks();
        track();
        movement();
        gameOverCheck();
    }
    public void checkClicks()
    {
        if(Greenfoot.mouseClicked(null))
        {
            clicks = 1;
        }
    }    
    public void track()
    {
        if(Greenfoot.mouseMoved(null) && clicks == 0) 
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setRotation(Greenfoot.getRandomNumber(120)+210);
            if(mouse.getX()>=85 && mouse.getX()<=515)
            {
                setLocation(mouse.getX(), 345);
            }
            if(mouse.getX()<85)
            {
                setLocation(85,345);
            }
            if(mouse.getX()>515)
            {
                setLocation(515,345);
            }
        }   
    }
    public void movement()
    {
        if(clicks != 0)
        {
            move(move);
            wallBounce();
            platBounce();
            blockBounce();
        }
    }
    public void wallBounce()
    {
        if (getX() == 0 || getX() == getWorld().getWidth()-1)
        {
            horzBounce();
        }
        if (getY() == 0) 
        {
            vertBounce();
        }
    }
    public void platBounce()
    {
        if(isTouching(Platform.class))
        {
            greenfoot.Actor plat = getOneIntersectingObject(Platform.class);
            if(Math.abs(getX()-plat.getX())<=28)
            {
                vertBounce();
            }
            else if (Math.abs(getX()-plat.getX())<89)
            {
                if((getX()-plat.getX())>0)
                {
                    setRotation(320);
                }
                else
                {
                    setRotation(220);
                }
            }
            else
            {
                if(getX()>plat.getX())
                {
                    setLocation(plat.getX()+94,getY());
                }
                if(getX()<plat.getX())
                {
                    setLocation(plat.getX()-94,getY());
                }
                horzBounce();
            }
        }
    }
    public void blockBounce()
    {
        if(isTouching(Blocks.class))
        {
            greenfoot.Actor block = getOneIntersectingObject(Blocks.class);
            if(Math.abs(getX()-block.getX())<=50)
            {
                vertBounce();
            }
            else
            {
                horzBounce();
            }
        }
    }
    public void horzBounce()
    {
        turn(180-2*getRotation());
    }
    public void vertBounce()
    {
        turn(-2*getRotation());
    }
    public void gameOverCheck()
    {
        if(checkDead() && lives==0)
        {
            getWorld().addObject(new failText(),300,200);
            getWorld().removeObjects(getWorld().getObjects(Blocks.class));
            getWorld().removeObjects(getWorld().getObjects(Platform.class));
            if(getWorld().numberOfObjects()>2)
            {
                getWorld().removeObjects(getWorld().getObjects(Power.class));
            }
            Greenfoot.stop();
        }
        else if (getWorld().getObjects(Blocks.class).isEmpty())
        {
            getWorld().addObject(new victoryText(),300,200);
            getWorld().removeObjects(getWorld().getObjects(Platform.class));
            getWorld().removeObject(this);
            if(getWorld().numberOfObjects()>2)
            {
                getWorld().removeObjects(getWorld().getObjects(Power.class));
            }
            Greenfoot.stop();
        }
        else if (checkDead() && lives > 0)
        {
            track();
        }
    }
    public boolean checkDead()
    {
        if(getY()==399)
        {
            clicks = 0;
            lives -= 1;
            move = 3;
            setLocation(getWorld().getObjects(Platform.class).get(0).getX(),345);
            track();
            return true;
        }
        else
        {
            return false;
        }
    }
    public int getLives()
    {
        return lives;
    }
    public void changeLives(int l)
    {
        lives = l;
    }
    public int getScore()
    {
        return score;
    }
    public void addScore(int s)
    {
        score += s;
    }
}
