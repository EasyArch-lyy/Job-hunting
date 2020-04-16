package basics.abstractTest;

/**
 * 抽象类通过子类实例化
 *
 * @author lyy
 */
public class AbstractDemo {

   public static void main(String[] args) {
      Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
      Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);

      System.out.println("Call mailCheck using Salary reference --");
      s.mailCheck();

      System.out.println("\n Call mailCheck using Employee reference--");
      e.mailCheck();
   }
}