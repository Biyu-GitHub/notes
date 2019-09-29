package clone;

public class Example implements Cloneable {
    public int a = 1;
    public int b = 2;

    public int[] nums = {1};

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
