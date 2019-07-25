class SMDUNSIV {  //Static Method Dont Use Non Static Instance Variable
	int vars;
	public static void main(String[] args) {
		System.out.println("Variable is " + vars);//Static Method Dont Use Non Static Instance Variable
		System.out.println("Variable is " + getVars());//Static Method Dont Use Non Static Methods
	}
	public void setVars(int s) {
		vars = s;
	}
	public int getVars() {
		return vars;
	}
}