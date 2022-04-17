package Main.Controller;

public class Move {
    public int i ;
    public int j ;
    public Double heightI ;
    public Double heightJ ;
    public boolean swap ;

    public Move(int i , int j , double height1 , double height2, boolean swap){
        this.i = i ;
        this.j = j ;
        this.heightI = height1 ;
        this.heightJ = height2 ;
        this.swap = swap ;
    }
}
