package com.objectbay.switchyard.bp.db.domain;

import java.io.Serializable;

public class GasStation implements Serializable {
	private static final long serialVersionUID = -6261224052310885993L;
	private long _id;
	private String _name;
	
	public GasStation() {}

	public GasStation(long id, String name) {
		this._id = id;
		this._name = name;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		this._id = id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
	}
}
