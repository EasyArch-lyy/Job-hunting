package Design_pattern.Decorator;

/**
 * @author lyy
 */
public class Decorator implements Component {

    /**持有抽象角色的引用*/
    private Component component;

    public Decorator(Component component){
        this.component=component;
    }

    @Override
    public void doSomething() {
        component.doSomething();
    }
}
