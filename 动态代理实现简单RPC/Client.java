package rpc;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException,
			IOException {

		Socket socket = new Socket("localhost", 8081);

		DataPool pool = (DataPool) Proxy.newProxyInstance(ConDataPool.class
				.getClassLoader(), ConDataPool.class.getInterfaces(),
				new DataPoolProxy(ConDataPool.class, socket));

		System.out.println(pool.getData(-44));

		socket.close();

	}

}
