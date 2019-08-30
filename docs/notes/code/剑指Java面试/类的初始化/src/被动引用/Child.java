package 被动引用;

/**
 * 所有引用类的方式都不会触发初始化，称为被动引用
 */
public class Child extends Father {
    public static void main(String[] args) {

        // 1. 通过子类引用父类的静态字段，不会导致子类初始化
        System.out.println(Child.val);

        // 2. 初始化类的数组
        Father[] fathers = new Father[10];

        // 3. 使用常量
        System.out.println(Father.val2);
    }
}
