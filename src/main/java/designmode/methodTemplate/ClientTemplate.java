package designmode.methodTemplate;

import designmode.methodTemplate.MsgTemplate;
import designmode.methodTemplate.YiDong;

/**
 * 开发中应用场景
 *  其实，各个框架中，都有模板方法模式的影子。
 * 数据库访问的封装、Junit单元测试、servlet中关于doGet/doPost方法的调用
 * Hibernate中模板程序、spring中JDBCTemplate，HibernateTemplate等等
 */
public class ClientTemplate {
    public static void main(String[] args) {
        MsgTemplate yiDong = new YiDong();
        yiDong.sendMsg();
    }
}
