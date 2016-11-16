package rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

import sun.security.util.ObjectIdentifier;

public class DataPoolProxy implements InvocationHandler {
	
	private Class className;
	
	private Socket socket;
	
	public DataPoolProxy(Class className,Socket socket){
		this.className = className;
		this.socket = socket;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		Class[] paramClasses = method.getParameterTypes();
		
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		
		oos.writeObject(className);
		
		oos.writeUTF(method.getName());
		
		oos.writeObject(paramClasses);
		
		oos.writeObject(args);
		
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		
		return ois.readObject();
		
	}

}
