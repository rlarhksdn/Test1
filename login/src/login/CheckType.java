package login;

public enum CheckType {
	 DB_ERROR(1),
	   ID_ERROR(1),
	   PW_ERROR(2),
	   SUCCESS(3);
	   private int num;
	  
	CheckType(int num){
		this.num=num;
	}
	
	public int value() {
		return num;
	}

}
