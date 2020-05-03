package designmode.methodTemplate;

import designmode.methodTemplate.MsgTemplate;

//移动接口
public class YiDong extends MsgTemplate {
    @Override
    public void httpRequest() {
        System.out.println("http://yidong.itmayiedu.com");
    }
}
