package my.chapter3.item10.abstra;

public class Rect extends Shape {
    private int len;
    public Rect(int l) { len = l; }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Shape))
            return false;
        if (! (o instanceof Rect))
            return false;
        Rect r = (Rect)o;
        return r.len == len;
    }
}
