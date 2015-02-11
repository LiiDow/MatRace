package matrace;
/**
 *
 * @author Reda ben
 */
public class Player {
    int x,y;
    int score;
    String name;
    int id_game;
    int stars;
    String avatar;
    public Player(int x,int y,int score,int s,String name){
        this.x = x;
        this.y = y;
        this.name = name;
        this.score = score;
        stars = s;
    }
}
