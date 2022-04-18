package Main.Controller;

public class Move {
    public int i;
    public int j;
    public int heightI;
    public int heightJ;
    public boolean swap, singleCol, pivot;

    public Move(int i, int j, int height1, int height2, boolean swap) {
        this.i = i;
        this.j = j;
        this.heightI = height1;
        this.heightJ = height2;
        this.swap = swap;
        this.singleCol = false;
    }

    public Move(int i, int j, int height1, int height2, boolean swap, boolean singleCol) {
        this.i = i;
        this.j = j;
        this.heightI = height1;
        this.heightJ = height2;
        this.swap = swap;
        this.singleCol = singleCol;
        this.pivot = false;
    }

    public Move(int i, int j, int height1, int height2, boolean swap, boolean singleCol, boolean pivot) {
        this.i = i;
        this.j = j;
        this.heightI = height1;
        this.heightJ = height2;
        this.swap = swap;
        this.singleCol = singleCol;
        this.pivot = pivot;
    }

    @Override
    public String toString() {
        return "Move{" +
               "i=" + i +
               ", j=" + j +
               ", heightI=" + heightI +
               ", heightJ=" + heightJ +
               ", swap=" + swap +
               ", singleCol=" + singleCol +
               ", pivot=" + pivot +
               '}';
    }
}
