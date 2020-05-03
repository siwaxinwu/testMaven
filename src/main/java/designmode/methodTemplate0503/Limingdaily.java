package designmode.methodTemplate0503;

public class Limingdaily extends DailyActivity {
    @Override
    public void launch() {
        System.out.println("liming is launch eat");
    }

    public static void main(String[] args) {
        DailyActivity limingdaily = new Limingdaily();
        limingdaily.daily();
    }
}
