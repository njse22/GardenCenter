package model;

public abstract class Plant {
    
    private String name; 
    private double cost;
    private String code;

    /**
     * @param name
     * @param cost
     */
    public Plant(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.code = "NOT_FOUND";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }
    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "Plant [" + (name != null ? "name=" + name + ", " : "") + "cost=" + cost + "]";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    } 

    
    

}
