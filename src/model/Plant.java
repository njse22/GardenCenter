package model;

public abstract class Plant {
    
    private String name; 
    private double cost;
    private String code;

    private int[][] matrixCode;

    /**
     * @param name
     * @param cost
     */
    public Plant(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.matrixCode = new int[4][4];
        for (int i = 0; i < this.matrixCode.length ; i++) {
            for (int j = 0; j < this.matrixCode[0].length; j++) {
                this.matrixCode[i][j] = (int) (Math.random() * 10);
            }
        }
        StringBuilder codeConcat = new StringBuilder();
        for (int i = 0; i < this.matrixCode.length; i++) {
            for (int j = 0; j < this.matrixCode[0].length; j++) {
                if((i+j)%2 == 0){
                    codeConcat.append(this.matrixCode[i][j]);
                }
            }
        }
        this.code = codeConcat.toString();
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

    public int[][] getMatrixCode() {
        return matrixCode;
    }

    public void setMatrixCode(int[][] matrixCode) {
        this.matrixCode = matrixCode;
    }
}
