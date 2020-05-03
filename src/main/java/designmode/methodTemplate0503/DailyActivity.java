package designmode.methodTemplate0503;

public abstract class DailyActivity {
    public void daily(){
        morning();
        launch();
        evening();
    }
    public  void morning(){
        System.out.println("eat morning");
    };
    public abstract void launch();
    public  void evening(){
        System.out.println("eat evening");
    };
}
