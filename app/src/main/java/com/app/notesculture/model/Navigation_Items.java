package com.app.notesculture.model;

public class Navigation_Items {

	String title, subtitle;
	Integer icon;

	public Navigation_Items(String title, Integer icon) {
		this.title = title;
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public String getSubTitle() {
		return subtitle;
	}

	public Integer getIcon() {
		return icon;
	}

}
