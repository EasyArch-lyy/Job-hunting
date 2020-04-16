package Design_pattern.Responsibility_chain;

import java.util.ArrayList;
import java.util.List;
/**
 * 责任链
 *
 * @author lyy
 */
public class FilterChain {

    /**规则过滤器列表，实现Filter接口的过滤器将真正执行对事件的处理*/
    private List<Filter> filters = new ArrayList<>();

    /**过滤器列表的索引*/
    private int index = 0;

    /**向责任链中加入过滤器（单个）*/
    public FilterChain addFilter(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    /**向责任链中加入过滤器（多个）*/
    public FilterChain addFilters(List<Filter> filters) {
        this.filters.addAll(filters);
        return this;
    }

    /**处理事件（alarm）从FilterChain中获取过滤器，进行处理，处理完成之后过滤器会再调用该方法，*/
    /**继续执行下一个filter.这就需要在每个Filter接口的实现类中最后一句需要回调FilterChain的doFilter方法。*/
    public void doFilter(Alarm alarm, FilterChain chain) {
        if (index == filters.size()) {
            return;
        }
        Filter filter = filters.get(index);
        index++;
        filter.execute(alarm, chain);
    }
}