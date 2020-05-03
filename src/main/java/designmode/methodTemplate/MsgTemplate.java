package designmode.methodTemplate;

public abstract class MsgTemplate {
    public void sendMsg(){
        //开始日志报文
        addHeadLog();
        //调用具体不同应用商发送
        httpRequest();
        //结束日志报文
        addFootLog();
    }

    private void addFootLog(){
        System.out.println("调用运营商结束。。。");
    }

    public abstract void httpRequest();

    private void addHeadLog(){
        System.out.println("调用运营商开始。。。");
    }
}
