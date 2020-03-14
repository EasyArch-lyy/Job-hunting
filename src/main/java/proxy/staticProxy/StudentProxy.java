package proxy.staticProxy;

/**
 * @author lyy
 */
public class StudentProxy implements Person{

    //被代理的学生
    Student stu;
    Student student;

    public StudentProxy(Student student){
        this.student=student;
    }
    public StudentProxy(Person stu){
        //判断反射生成的对象类型
        if(stu.getClass()==Student.class){
            this.stu= (Student) stu;
        }
    }

    //代理上交班费，调用被代理学生上交班费行为
    @Override
    public void giveMoney() {
        stu.giveMoney();
    }

    @Override
    public void giveWater() {
        student.giveWater();
    }


}
