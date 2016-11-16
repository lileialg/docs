package rpc;

import java.util.HashMap;
import java.util.Map;

public class ConDataPool implements DataPool {
	
	private static final Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	
	static{
		for(int i=0;i<100;i++)
			map.put(i, i);
	}

	@Override
	public int getData(int key) {
		// TODO Auto-generated method stub
		return map.containsKey(key)?map.get(key):-23;
	}

}
