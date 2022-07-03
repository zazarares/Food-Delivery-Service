package OrderManager;

import java.io.Serializable;
import java.time.LocalDateTime;

import Data.Pair;

public class Order implements Serializable {
	int id;
	Pair ClientId;
	LocalDateTime Time;
	float Price=0;
	public Order(int id,Pair ClientId,LocalDateTime T)
	{
	this.id=id;
	this.ClientId=ClientId;
	this.Time=T;
	}
	@Override
	public int hashCode() {
		return id;
	}
}
