
/**
 * The Point class represents a point in the plane according to a Cartesian axis system
 *
 * @author Rina gantz
 * @version (a version number or a date)
 */
public class Point
{
    //attributes 
    private double _x;
    private double _y;
    /**
     * Constructor for objects of class Point 
     * @param x the value to set
     * @param y the value to set 
     */
    public Point(double x, double y)
    {
        _x=x;
        _y=y;
    }

    /**
     * * copy constructor
     * @param other the point to be copied
     */
    public Point(Point other)
    {
        _x=other._x;
        _y=other._y;
    }

    /**
     * gets x value
     * @return The value of x
     */
    public double getX()
    {
        return _x;
    }

    /**
     * gets x value
     * @return The value of x
     */
    public double getY()
    {
        return _y;
    }

    /**
     * sets the x value
     * @param num the x value to be set
     */
    public void setX(double num)
    {
        _x=num;
    }

    /**
     * sets the x value
     * @param num the x value to be set
     */
    public void setY(double num)
    {
        _y=num;
    }

    /**
     * returns a String that represents this point
     * @return String that represents this point in the following format: (x,y) for example: (3.0,4.0)
     */
    public String toString()
    {
        return "("+_x+","+_y+")";
    }

    /** 
     *  check if 2 points are the same
     * @param other the point to compare this point to
     * @return true if they are equal, oterwise false. 
     */
    public boolean equals(Point other)
    {
        return _x==other._x&&_y==other._y;
    }

    /** 
     * check if this point is above other point
     * @param other point to compare this point to
     * @return true if this point is above other point, oterwise false. 
     */
    public boolean isAbove(Point other)
    {
        return _y>other._y;
    }

    /** 
     * check if this point is under other point
     * @param other point to compare this point to
     * @return true if this point is under other point, oterwise false. 
     */
    public boolean isUnder(Point other)
    {
        return other.isAbove(this);
    }

    /** 
     * check if this point is left other point
     * @param other point to compare this point to
     * @return true if this point is left other point, oterwise false. 
     */
    public boolean isLeft (Point other)
    {
        return _x<other._x;
    }

    /** 
     * check if this point is right other point
     * @param other point to compare this point to
     * @return true if this point is right other point, oterwise false. 
     */
    public boolean isRight(Point other)
    {
        return  other.isLeft(this);
    }

    /**
     * calculates the distance between two points according to the distance formula
     * @param p the point to calculate the difference between
     * @return the number of distance between the points
     */
    public double distance(Point p)
    {
        return Math.sqrt((_y-p._y)*(_y-p._y)+(_x-p._x)*(_x-p._x));
    }

    /**
     * Move the point according to the given values
     * @param X- the value at which the X should be moved
     * @param Y- the value at which the Y should be moved
     */
    
    public void move(double dx, double dy)
    {
        if ((_x+dx)>=0&&(_y+dy)>=0){
            _x+=dx;
            _y+=dy;
        }
    }
}//end of class Point
