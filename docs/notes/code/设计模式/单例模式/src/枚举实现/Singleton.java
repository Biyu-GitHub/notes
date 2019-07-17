package 枚举实现;

public enum Singleton {
    INSTANCE;

    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) {
        Singleton instance1 = Singleton.INSTANCE;
        instance1.setObjName("1");
        System.out.println(instance1.getObjName());

        Singleton instance2 = Singleton.INSTANCE;
        instance1.setObjName("2");
        System.out.println(instance1.getObjName());

        System.out.println(instance1.getObjName());
    }
}
