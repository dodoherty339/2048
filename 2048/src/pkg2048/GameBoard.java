package pkg2048;
 
import java.util.Random;
 
public class GameBoard
{
    private int x;
   
    private int y;
   
    private final Cell[][] board = new Cell[4][4];
   
    private final Integer[] newValue;
   
    private final Random rand = new Random();
   
    private Thread t;
   
    public GameBoard()
    {
        this.newValue = new Integer[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 4};
        for(int row=0;row<4;row++)
        {
            for(int col=0;col<4;col++)
            {
                board[row][col] = new Cell();
            }
        }
        //Add a two or a four to two random cells
        setRandCell();
        setRandCell();
    }
   
    private void setRandCell()
    {
        do
        {
            x = rand.nextInt(4);
            y = rand.nextInt(4);
        }while(!(board[x][y].isCellOpen()));
        board[x][y].setValue(newValue[rand.nextInt(10)]);
    }
/* TODO: figure out how to thread left operation
    public void left()
    {
        Thread[] tArray = null;
        for(int i=0;i==3;i++)
        {
            final int row = i;
            t = new Thread(new Runnable()
            {
                public void run()
                {
                    Cell[] tempRow = new Cell[4];
                    board[row]=left(tempRow,row,1);
                }
            });
            t.start();
            tArray[i]=t;
        }
    }
   */
    
    public void left()
    {
        for(int row=0;row<=3;row++)
        {
            Cell[] tempRow;
            tempRow=board[row];
            board[row]=left(tempRow,0,1);
        }
        setRandCell();
        printBoard();
    }
    
    Cell[] left(Cell[] tempRow, final int lCell, int rCell)
    {
        if(rCell<tempRow.length){
            Integer lVal = tempRow[lCell].getValue();
            Integer rVal = tempRow[rCell].getValue();

            if((lVal==null)&&(rVal==null)){
                tempRow = left(tempRow,lCell+1,rCell+1);
            }else if((lVal!=null)&&(rVal==null)){
                tempRow = left(tempRow,lCell,rCell+1);
            }else if((lVal==rVal)||((lVal==null)&&(rVal!=null))){
                if(lVal==null){
                    lVal=0;
                }
                lVal = lVal+rVal;
                tempRow[lCell].setValue(null);
                tempRow[rCell].setValue(null);
                for(int i=0;i<=lCell;i++){
                    if(tempRow[i].isCellOpen()){
                        tempRow[i].setValue(lVal);
                        break;
                    }
                }
                tempRow = left(tempRow,lCell+1,rCell+1);
            }else if((lVal!=rVal)&&(lVal!=null)&&(rVal!=null)){
                for(int i=lCell;i<=rCell;i++){
                    if(tempRow[i].isCellOpen()){
                        tempRow[rCell].setValue(null);
                        tempRow[i].setValue(rVal);
                        break;
                    }
                }
                tempRow = left(tempRow,lCell+1,rCell+1);
            }
        }
        return tempRow;
    }
   
    public void right()
    {
        for(int row=0;row<=3;row++)
        {
            Cell[] tempRow;
            tempRow=board[row];
            board[row]=right(tempRow,2,3);
        }
        setRandCell();
        printBoard();
    }
    
    Cell[] right(Cell[] tempRow, final int lCell, int rCell)
    {
        if(lCell>=0){
            Integer lVal = tempRow[lCell].getValue();
            Integer rVal = tempRow[rCell].getValue();

            if((rVal==null)&&(lVal==null)){
                tempRow = right(tempRow,lCell-1,rCell-1);
            }else if((rVal!=null)&&(lVal==null)){
                tempRow = right(tempRow,lCell-1,rCell);
            }else if((rVal==lVal)||((rVal==null)&&(lVal!=null))){
                if(rVal==null){
                    rVal=0;
                }
                rVal = rVal+lVal;
                tempRow[lCell].setValue(null);
                tempRow[rCell].setValue(null);
                for(int i=3;i>=0;i--){
                    if(tempRow[i].isCellOpen()){
                        tempRow[i].setValue(rVal);
                        break;
                    }
                }
                tempRow = right(tempRow,lCell-1,rCell-1);
            }else if((rVal!=lVal)&&(rVal!=null)&&(lVal!=null)){
                for(int i=rCell;i>=lCell;i--){
                    if(tempRow[i].isCellOpen()){
                        tempRow[lCell].setValue(null);
                        tempRow[i].setValue(lVal);
                        break;
                    }
                }
                tempRow = right(tempRow,lCell-1,rCell-1);
            }
        }
        return tempRow;
    }
   
    public void up()
    {

    }
   
    public void down()
    {
       
    }
    
    public void printBoard()
    {
        System.out.println("-----------------");
        for(int row=3;row>=0;row--)
        {
            System.out.print("| ");
            for(int col=0;col<4;col++)
            {
                Integer val = board[row][col].getValue();
                if(val==null)
                {
                    System.out.printf("  | ");
                }else
                {
                    System.out.printf("%d | ", val);
                }
            }
            System.out.println("");
        }
        System.out.println("-----------------");
    }

}
