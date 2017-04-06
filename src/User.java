public class User {
	//в этом классе будет записана информация о пользователе (логин, пароль, был ли он уже залогинен(???))
	enum Type {common, admin};
	
	boolean logged_in;
	Type type;
}
