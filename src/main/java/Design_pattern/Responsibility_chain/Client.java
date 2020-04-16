package Design_pattern.Responsibility_chain;

import java.util.Date;

/**
 * 责任链模式
 *
 * @author lyy
 */
public class Client {
    public static void main(String[] args) {
        //构造告警事件
        Alarm alarm = new Alarm(1, 10, "光功率衰耗", "省政府23号楼", 1, 1, 1, new Date(), "割接");

        //将规则加入责任链
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new Rule1()).addFilter(new Rule2());

        //执行责任链
        filterChain.doFilter(alarm, filterChain);

        //输出结果
        System.out.println(alarm);
    }
}