package basics.reference;

/**
 * @ClassName:MyThreadLocal
 * @Description:ThreadLocal线程本地变量
 * @author lyy
 */
public class MyThreadLocal{

    /**线程本地共享变量*/
    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>(){
        /**
         * ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
         */
        @Override
        protected Object initialValue() {
            System.out.println("[线程"+Thread.currentThread().getName()+"]调用get方法时，当前线程共享变量没值，调用initialValue获取默认值！");
            return null;
        }
    };
     
    public static void main(String[] args){
        //1.开启任务1线程
        new Thread(new MyIntegerTask("IntegerTask1")).start();
        //2.中间休息3秒，用以测试数据差异
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //3.开启任务2线程
        new Thread(new MyIntegerTask("IntegerTask2")).start();
    }
     
    /**
     * 
     * @ClassName:MyIntegerTask
     * @Description:整形递增线程
     * @author diandian.zhang
     * @date 2017年12月4日上午10:00:41
     */
    public static class MyIntegerTask implements Runnable{
        private String name;
         
        MyIntegerTask(String name)
        {
            this.name = name;
        }
 
        @Override
        public void run()
        {
            for(int i = 0; i < 5; i++)
            {
                // ThreadLocal.get方法获取线程变量
                if(null == MyThreadLocal.threadLocal.get())
                {
                    // ThreadLocal.set方法设置线程变量
                    MyThreadLocal.threadLocal.set(0);
                    System.out.println("i="+i+"[线程" + name + "]当前线程不存在缓存,set 0");
                }
                else
                {
                    int num = (Integer)MyThreadLocal.threadLocal.get();
                    MyThreadLocal.threadLocal.set(num + 1);
                    System.out.println("i="+i+"[线程" + name + "]往threadLocal中set: " + MyThreadLocal.threadLocal.get());
                    //当i=3即循环4次时，移除当前线程key
                    if(i == 3)
                    {
                        System.out.println("i="+i+"[线程" + name + "]，threadLocal移除当前线程" );
                        MyThreadLocal.threadLocal.remove();
                    }
                }
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }  
        }
    }
}