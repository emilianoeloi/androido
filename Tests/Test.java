import java.math.BigDecimal;

public class Test {
  public static void main(String ...args) {
    BigDecimal idade = new BigDecimal(15);
    new Thread(new Runnable() {
      public void run() {
        System.out.println("idade:"+idade);
      }
    }).start();
  }
}
