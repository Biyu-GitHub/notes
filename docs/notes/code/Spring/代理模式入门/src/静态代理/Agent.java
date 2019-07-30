package 静态代理;

public class Agent implements Person {
    private Actor actor;
    private String before;
    private String after;

    public Agent(Actor actor, String before, String after) {
        this.actor = actor;
        this.before = before;
        this.after = after;
    }

    @Override
    public void speak() {
        System.out.println("Before actor speak, Agent say: " + before);

        this.actor.speak();

        System.out.println("After actor speak, Agent say: " + after);
    }
}
