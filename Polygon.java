
/**
 * Write a description of class Polygon here.
 *
 * @author Rina Gantz
 * @version 10/06/2020
 */

public class Polygon
{
    private PointNode _head;
    /**
     * Constructor for objects of class Polygon
     */
    public Polygon()
    {

        _head=null;
    }

    public boolean addVertex(Point p, int pos)
    {
        PointNode pn=new PointNode(p);
        if(pos <= 0)
            return false;
        if ((_head==null||_head.getNext()==null)){
            if(pos==1){
                PointNode temp = _head;
                _head= pn;
                pn.setNext(temp);
                return true;
            }
            if(_head!=null)
                if (pos==2){
                    _head.setNext(pn);
                    return true;
                }
            return false;}
        PointNode temp=_head, cur=_head;
        pos--;
        while (cur.getNext()!=null&&pos!=1){
            cur=cur.getNext();
            pos--;
        }
        if(pos==1){
            pn.setNext(cur.getNext());
            cur.setNext(pn);
            return true;
        }  
        return false; 
    }

    public Point highestVertex()
    {
        if(_head==null)
            return null;
        PointNode high=new PointNode(_head);
        PointNode temp=new PointNode(_head);
        while(temp!=null){
            if(high.getPoint().isUnder(temp.getPoint()))
                high=temp;
            temp=temp.getNext(); 
        }
        return new Point(high.getPoint());            
    }

    public String toString()
    {
        if(_head==null)
            return "The polygon has 0 vertices.";
        String s="("+_head.getPoint();
        PointNode temp=_head.getNext();
        int count=1;
        while (temp!=null){
            s+=","+temp.getPoint();
            temp=temp.getNext();
            count++;
        }
        s+=")";
        return "The polygon has "+count+" vertices:\n"+s;
    }

    public double calcPerimeter(){
        if(_head==null||_head.getNext()==null)
            return 0;
        PointNode temp=_head;
        double perimeter=0;
        while(temp.getNext()!=null){
            perimeter+=temp.getPoint().distance(temp.getNext().getPoint());
            temp=temp.getNext();
        }
        if(_head.getNext().getNext()!=null)
            perimeter+=_head.getPoint().distance(temp.getPoint());
        return perimeter;
    }

    public double calcArea()
    {
        if(_head==null||_head.getNext()==null)
            return 0;
        double sum=0, a,b,c;
        PointNode po1=_head.getNext();
        PointNode po2=_head.getNext().getNext();
        while(po2!=null){
            sum+=calcelAreaTriangle(_head,po1,po2);
            po1=po2;
            po2=po2.getNext();
        }
        return sum;
    }

    private double calcelAreaTriangle(PointNode head, PointNode p1,PointNode p2){
        double a,b,c,halfPer;
        a=_head.getPoint().distance(p1.getPoint());
        b=p1.getPoint().distance(p2.getPoint());
        c=p2.getPoint().distance(_head.getPoint());
        halfPer=(a+b+c)/2;
        return Math.sqrt(halfPer*(halfPer-a)*(halfPer-b)*(halfPer-c));
    }

    public boolean isBigger(Polygon other)
    {
        return this.calcArea()>other.calcArea();
    }

    public int findVertex(Point p)
    {
        int place=1;
        PointNode temp=_head;
        while(temp!=null){
            if(temp.getPoint().equals(p))
                return place;
            place++;
            temp=temp.getNext();
        }
        return -1;
    }

    public Point getNextVertex(Point p)
    {
        if(_head==null)
            return null;
        PointNode temp= _head;
        while(temp.getNext()!=null){    
            if(p.equals(temp.getPoint()))
                return new Point(temp.getNext().getPoint());
            temp=temp.getNext();
        }
        if(temp.getNext()==null&&p.equals(temp.getPoint()))
            return new Point(_head.getPoint());
        return null;
    }

    public Polygon getBoundingBox(){
        if (_head==null||_head.getNext()==null||_head.getNext().getNext()==null)
            return null;
        Point high=highestVertex();
        Point left=_head.getPoint();
        Point right=_head.getPoint();
        Point under=_head.getPoint();
        PointNode temp=_head;
        while(temp!=null){
            if(temp.getPoint().isLeft(left))
                left=temp.getPoint();
            if(temp.getPoint().isRight(right))
                right=temp.getPoint();
            if(temp.getPoint().isUnder(under))
                under=temp.getPoint();
            temp=temp.getNext();
        }
        Point point1= new Point (left.getX(),under.getY()); 
        Point point2= new Point (right.getX(),under.getY()); 
        Point point3= new Point (right.getX(),high.getY()); 
        Point point4= new Point (left.getX(),high.getY()); 
        Polygon square= new Polygon();
        square.addVertex(point1,1);
        square.addVertex(point2,2);
        square.addVertex(point3,3);
        square.addVertex(point4,4);
        return square;
    }
}