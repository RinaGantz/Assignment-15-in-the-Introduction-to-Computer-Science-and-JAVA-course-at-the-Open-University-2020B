
/**
 * 
 *
 * @author Rina gantz
 * @version 19/06/2020
 */
public class PointNode
{
    private Point _point;
    private PointNode _next;
    public PointNode(Point p)
    {
        _point=new Point(p);
        _next=null;
    }
    public PointNode(Point p, PointNode n)
    {
        _point=new Point (p);
        _next=n;
    }
    public PointNode(PointNode p)
    {
        _point=new Point(p._point);
        _next=p._next;
    }
    public Point  getPoint()
    {
        return new Point(_point);
    }
    public PointNode  getNext()
    {
        return _next;
    }
    public void setPoint(Point p)
    {
        _point=new Point(p);
    }
    public void setNext (PointNode next)
    {
        _next=next;
    }
}
