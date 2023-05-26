
/**
 * Write a description of class restaurant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class restaurant
{
    private food[] orders;
    private int clickCount;
    /**
     * Constructor for objects of class restaurant
     */
    public restaurant()
    {
        clickCount = 0;    
        orders = new food[1];
        orders[0] = new bananaSmoothie();
        
    }
    public void incrementOrder(){
        clickCount++;
    }
    public int getOrderNum(){
        return clickCount;
    }
    public int getOrderLength(){
        return orders.length;
    }
    public food getMyOrder(){
        if(clickCount < orders.length){
            return orders[clickCount];
        }
        return null;
    }
}
