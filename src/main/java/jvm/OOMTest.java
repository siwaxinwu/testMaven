package jvm;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class OOMTest {
    public static final int MB = 1024*1024;
    static List<byte[]> byteList = new ArrayList<byte[]>();
    private static void oom(HttpExchange exchange){
        String response = "oom begin";
        try {
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; ; i++) {
            byte[] bytes = new byte[MB];
            byteList.add(bytes);
            System.out.println(i + "MB");
            memPrint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static void memPrint(){
        for (MemoryPoolMXBean mp : ManagementFactory.getMemoryPoolMXBeans()) {
            System.out.println(mp.getName() + " committed:" + mp.getUsage().getCommitted()
            + "used :" + mp.getUsage().getUsed());

        }
    }

    private static void srv() throws Exception{
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8888), 0);
        HttpContext context = httpServer.createContext("/");
        context.setHandler(OOMTest::oom);
        httpServer.start();
    }

    public static void main(String[] args) throws Exception {
        srv();
    }
}
