package zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class WatcherApp implements Watcher {

	private ZooKeeper zk;
	
	public WatcherApp(String hosts) throws IOException, KeeperException, InterruptedException{
		zk = new ZooKeeper(hosts,5000,null);
		
		if (zk.exists("/root", null) == null ){
			zk.create("/root", "abc".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
		
		zk.getData("/root", this, null);
	}
	
	@Override
	public void process(WatchedEvent event) {
		// TODO Auto-generated method stub

		System.out.println(event.getType());
		
		
		try {
			zk.getData("/root", this, null);
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WatcherApp watch = new WatcherApp("localhost:2181");
		
		
		Thread.sleep(Long.MAX_VALUE);
		
	}

}
