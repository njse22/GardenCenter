package model;

public abstract class Plant {
    
    private String name; 
    private double cost;
    private String id;

    /**
     * @param name
     * @param cost
     */
    public Plant(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.id = generateCode();
        System.out.println(id);
    }

    public String getId(){
        return this.id;
    }

    public String generateCode(){
        int[][] matrix = MatrixUtil.randomMatrix(4,4);
        String code = "";

        for(int i=0; i <matrix.length;i++){
            for(int j = 0; j < matrix[0].length;j++){
                if(i %2 == 0 && j %2 ==0){
                    code += matrix[i][j];
                }else if(i%2 != 0 && j%2!= 0){
                    code += matrix[i][j];
                }
            }
        }
        return code;
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

    
    

}
