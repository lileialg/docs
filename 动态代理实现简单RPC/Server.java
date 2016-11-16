package rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		final ConDataPool pool = new ConDataPool();
	

		ServerSocket server = new ServerSocket(8081);

		while (true) {
			final Socket socket = server.accept();

			new Thread() {

				public void run() {

					try {
						ObjectInputStream ois = new ObjectInputStream(
								socket.getInputStream());

						// 类名
						Class className = (Class) ois.readObject();
						//方法名
						String methodName = ois.readUTF();
						//参数类型数组
						Class[] paramClasses = (Class[]) ois.readObject();
						
						//参数数组
						Object[] args = (Object[]) ois.readObject();
						
						Method method = pool.getClass().getMethod(methodName, paramClasses);
						
						Object result = method.invoke(pool, args);
						
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
						
						oos.writeObject(result);
					
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				};

			}.start();
			;
		}
	}

}
