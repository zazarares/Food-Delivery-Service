package Data;

import java.io.Serializable;

public class Pair implements Serializable{
	public String user;
	public String password;
	public int orders=0;
	public Pair(String u,String p)
	{
		user=u;
		password=p;
	}
}
