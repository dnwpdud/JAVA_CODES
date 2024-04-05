package edu.java.sideproject;

public interface LoginDAO {
	public abstract boolean selectLoginManager(int no ,String id, String pw);
	
	public abstract boolean selectLoginUser(int no ,String id, String pw);
}// end LoginDAO
