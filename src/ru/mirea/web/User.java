package ru.mirea.web;
public class User {
	enum Type {common, admin};
	
	public boolean logged_in;
	public String type;
	public String login;
	public String password;
}
