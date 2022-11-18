package model;

public class Ornamental extends Plant{
	private double high; 

	public Ornamental(String name, double cost,String id,  double high){
		super(name, cost, id);
		this.high = high;
	}
	 public double getHigh(){
        return high;
    }

}