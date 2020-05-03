package designmode.adaptor;

public class TestAdaptor {
    public static void main(String[] args) {
        CN220VInterfaceImpl cn220VInterface = new CN220VInterfaceImpl();
        PowerAdaptor powerAdaptor = new PowerAdaptor(cn220VInterface);
        ElectricCooker electricCooker = new ElectricCooker(powerAdaptor);
        electricCooker.cook();
        
    }
}

interface JP110VInterface {
    public void connect();
}
class JP110VInterfaceImpl implements JP110VInterface {

    @Override
    public void connect() {
        System.out.println("日本110V电源接口开始工作");
    }
}

interface CN220VInterface {
    public void connect();
}
class CN220VInterfaceImpl implements CN220VInterface{

    @Override
    public void connect() {
        System.out.println("中国220V电源接口，开始工作");
    }
}

class ElectricCooker {

    private JP110VInterface jp110VInterface;

    public ElectricCooker(JP110VInterface jp110VInterface){
        this.jp110VInterface = jp110VInterface;
    }
    public void cook(){
        jp110VInterface.connect();
        System.out.println("开始做饭");

    }
}

class PowerAdaptor implements JP110VInterface{
    private CN220VInterface cn220VInterface;
    public PowerAdaptor(CN220VInterface cn220VInterface){
        this.cn220VInterface = cn220VInterface;
    }
    @Override
    public void connect() {
        cn220VInterface.connect();
    }
}