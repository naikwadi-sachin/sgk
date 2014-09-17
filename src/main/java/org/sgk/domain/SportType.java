package org.sgk.domain;

public class SportType {

	private int id;
	private String name;
	
	public SportType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SportType)
		{
			SportType sportType = (SportType) obj;
			if(this == sportType || this.getId()==sportType.getId())
				return true;
		}
		return false;
	}
}