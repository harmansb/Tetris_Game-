package tetris;
import java.awt.Color;
import java.awt.Graphics; 
import java.util.Random;
import javax.swing.JPanel;
import tetrisblocks.*;
public class GameArea extends JPanel{
    private int gridRows;
    private int gridColumns; 
    private int gridCellSize;
    private TetrisBlock block;
    private TetrisBlock[] blocks;
    private Color[][] background;
    
    public GameArea (JPanel placeholder, int columns){
        placeholder.setVisible(false);
        placeholder.setVisible(true);

        this.setBounds( placeholder.getBounds() );
        this.setBackground( placeholder.getBackground () );
        this.setBorder( placeholder.getBorder());

        gridColumns = columns;
        gridCellSize = this.getBounds().width / gridColumns;
        gridRows = this.getBounds ().height / gridCellSize;
        
        background=new Color[gridRows][gridColumns];
        blocks=new TetrisBlock[]{new IShape(),new LShape(),new ZShape(),new TShape(),new SShape(),new JShape()};
    }
    public void spawnBlock(){
        Random r=new Random();
        block=blocks[r.nextInt(blocks.length)];
        block.spawn(gridColumns);
    } 
    public boolean isBlockOut0fBounds (){
        if(block.getY()<0){
            block=null;
            return true;
        }
        
        return false;
    }
    public boolean moveBlockDown(){
        if(checkBottom()==false) {
            /*moveBlockToBackground();
            clearLines();*/
            return false;
        }
        block.moveDown();
        repaint();
        return true;
    }
     public void moveBlockRight(){
        if(block==null)return; 
        if(checkRight()==false)return;
            block.moveRight();
        repaint();
    }
    public void moveBlockLeft (){
         if(block==null)return; 
         if(!checkLeft())return;
            block.moveLeft();
            repaint();
    }
    public void dropBlock(){
        if(block==null)return; 

        while(checkBottom()){//while checkbottom returns false
            block.moveDown();
        }
        repaint();
    }
    public void rotateBlock (){
        if(block==null) return;
        block.rotate();
        if(block.getLeftEdge()<0)block.setX(0);
        if(block.getRightEdge()>=gridColumns)block.setX(gridColumns-block.getWidth());
        if(block.getBottomEdge()>=gridRows)block.setY(gridRows-block.getHeight());
        repaint();
    }
    private boolean checkBottom(){
        if(block.getBottomEdge()==gridRows){
            return false;
        }
        int [][]shape = block.getShape();
        int w = block.getWidth() ;
        int h=block.getHeight();
        for(int col =0;col < w; col++){
            for(int row=h-1; row >= 0; row--){
                if(shape [row][col]!= 0){
                    int x = col + block.getX();
                    int y = row + block.getY()+1;
                    if(y<0) break;
                    if (background [y][x]!= null) return false;
                    break;
                }
            }
        }
                return true;
    }
    private boolean checkLeft (){
        if(block.getLeftEdge() == 0) return false;
        int [][]shape = block.getShape();
        int w = block.getWidth() ;
        int h=block.getHeight();
        for(int row=0;row < h; row++){
            for(int col=0; col<w; col++){
                if(shape [row][col]!= 0){
                    int x = col + block.getX()-1;
                    int y = row + block.getY();
                    if(y<0) break;
                    if (background [y][x]!= null) return false;
                    break;
                }
            }
        }
            return true;
    }
    
    private boolean checkRight (){
        if(block.getRightEdge() == gridColumns ) return false;
        int [][]shape = block.getShape();
        int w = block.getWidth() ;
        int h=block.getHeight();
        for(int row=0;row < h; row++){
            for(int col=w-1; col>=0; col--){
                if(shape[row][col]!= 0){
                    int x = col + block.getX()+1;
                    int y = row + block.getY();
                    if(y<0) break;
                    if (background [y][x]!= null) return false;
                    break;
                }
            }
        }
        return true;
    }
    public int clearLines(){
        boolean lineFilled;
        int linesCleared=0;
        for (int r = gridRows - 1; r >= 0; r--){
            lineFilled = true;
            for(int c = 0; c < gridColumns; c++){
                if (background [r] [c] == null){
                    lineFilled = false;
                    break;}
            }
            if(lineFilled){
                linesCleared++;
                clearLine(r);//clears that line
                shiftLineDown(r);
                clearLine(0);
                r++;
                repaint ();
            }
        }
        return linesCleared;
    }
    private void clearLine(int r){
        for(int i=0;i<gridColumns;i++){
            background[r][i]=null;
        }
    }
    private void shiftLineDown(int r){
        for(int row = r; row > 0; row--){
            for(int col = 0; col < gridColumns; col++){
                background [row] [col] = background [row - 1] [col];
            }
        }
    }
    
    public void moveBlockToBackground(){
        int [][]shape=block.getShape();
        int h=block.getHeight();
        int w=block.getWidth();
        int xPos=block.getX();
        int yPos=block.getY();
        Color color=block.getColor();
        for(int row = 0; row < h; row++){
            for (int col = 0; col < w; col++){
                if (shape [row][col] == 1){
                    background[row+yPos][col+xPos]=color;
                }
            }
        }
    }
  
   private void drawBlock (Graphics g){
    int h = block.getHeight();
    int w = block.getWidth();
    Color c = block.getColor ();
    int [][] shape = block.getShape () ;
    for(int row = 0; row < h; row++){
        for (int col = 0; col < w; col++){
            if (shape [row][col] == 1){
                 int x=(block.getX()+col)*gridCellSize;
                 int y=(block.getY()+row)*gridCellSize;
                g.setColor(c);
                g. fillRect(x,y, gridCellSize, gridCellSize); 
                g.setColor (Color.black);
                g.drawRect (x,y, gridCellSize, gridCellSize);
            }
        }
    }
   }
   private void drawBackground(Graphics g){
        Color color;
        for(int row = 0; row < gridRows; row++){
            for (int col = 0; col < gridColumns; col++){
                color=background[row][col];
                if (color!=null){
                    int x=col*gridCellSize;
                    int y=row*gridCellSize;
                    g.setColor(color);
                    g. fillRect(x,y, gridCellSize, gridCellSize); 
                    g.setColor (Color.black);
                    g.drawRect (x,y, gridCellSize, gridCellSize);
                }
            }
        }
   }
    @Override
    protected void paintComponent (Graphics g){
        super. paintComponent(g) ;
        drawBackground(g);
        drawBlock(g);
    }
}

