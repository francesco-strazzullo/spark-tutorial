package it.cosenonjaviste.sparktutorial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private static List<User> users = new ArrayList<User>();

	static{
		users.add(new User(0, "Solid Snake"));
		users.add(new User(1, "Vulcan Raven"));
		users.add(new User(2, "Meryl Silverburgh"));
		users.add(new User(3, "Hal Emmerich"));
		users.add(new User(4, "Frank Jaeger"));
	}

	private Integer id;
	private String name;

	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static List<User> getAll(){
		return users;

	}

	public static User get(final Integer id){
		return users.stream().filter((p)->p.getId().equals(id)).findFirst().get();
	}

	public static User store(User p){
		if(p.getId() == null){
			User maxIdPerson = users.stream().max((p1,p2)->Integer.compare(p1.getId(), p2.getId())).get();
			p.setId(maxIdPerson.getId()+1);
			users.add(p);
		}else{
			users.set(p.getId(), p);
		}

		return p;
	}

	public static void delete(User p){
		users.remove(p);
	}
}