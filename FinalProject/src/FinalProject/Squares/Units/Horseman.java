package FinalProject.Squares.Units;
import FinalProject.Squares.*;
import javax.swing.ImageIcon;

public class Horseman extends Troop {
    private ImageIcon redIcon = new ImageIcon(getClass().getResource("redHorseman.png"));
    private ImageIcon blueIcon = new ImageIcon(getClass().getResource("blueHorseman.png"));
    
    int health = 120;
    int damage = 45;
    int cost = 65;
    
    public Horseman(int xPos, int yPos, boolean team){
        super(null, xPos, yPos, team);
        if (team){
            this.setIcon(redIcon);
        } else {
            this.setIcon(blueIcon);
        }
    }
    
    public boolean canMove(Square target){
        if(xDist(target) == 1 && yDist(target) == 2){
            return true;
        } else if (xDist(target)==2 && yDist(target) == 1) {
            return true;
        }
        return false;
    }
    
    public boolean canMove(int x, int y){
        Square target = new Square(null, x, y);
        return canMove(target);
    }
    
     public boolean attack(Troop enemy){
    	enemy.health = enemy.health - damage;
    	if(enemy.health <= 0){
    		enemy.beDestroyed();
    	}
    }    
}