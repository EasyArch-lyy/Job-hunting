package Design_pattern.Responsibility_chain;


//过滤器接口
public interface Filter {

    void execute(Alarm alarm, FilterChain chain);
}