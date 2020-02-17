package sample;
import javafx.scene.paint.Color;

/**The parent class for each figure on the canvas*/

public class Figure {
    private double beginX = 0;
    private double beginY = 0;
    private double endX = 0;
    private double endY = 0;
    private Color color = Color.BLACK;
    private int size = 0;

    /**The constructor of figure's class. Also this method
     * make begin in the top left pint of the figure.
     * @param beginX  the first point on the x-coordinate of figure,
     * @param beginY the first point on the y-coordinate of figure,
     * @param endX the last point on the x-coordinate of figure,
     * @param endY the last point on the y-coordinate of figure,
     * @param color the color of the figure,
     * @param size the thickness of figure's stroke.
     */
    public Figure(double beginX, double beginY,
                  double endX, double endY,
                  Color color, int size) {
        this.beginX = beginX > endX ? endX : beginX;
        this.beginY = beginY > endY ? endY : beginY;
        this.endX = endX < beginX ? beginX : endX;
        this.endY = endY < beginY ? beginY : endY;
        this.color = color;
        this.size = size;
    }

    public double getBeginX(){
        return beginX;
    }

    public double getBeginY() {
        return beginY;
    }

    public double getEndX(){
        return endX;
    }

    public double getEndY(){
        return endY;
    }

    /**This method is calculated length of figure's x-side.
     * @return length of the x-side.
     */
    public double getXSide(){
        return Math.abs(endX - beginX);
    }

    /**This method is calculated length of figure's y-side.
     * @return length of the y-side.
     */
    public double getYSide(){
        return Math.abs(endY - beginY);
    }
}

