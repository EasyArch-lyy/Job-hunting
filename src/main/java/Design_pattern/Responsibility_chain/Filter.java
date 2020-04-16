package Design_pattern.Responsibility_chain;


/**
 * 过滤器接口
 *
 * @author lyy
 */
public interface Filter {

    void execute(Alarm alarm, FilterChain chain);
}