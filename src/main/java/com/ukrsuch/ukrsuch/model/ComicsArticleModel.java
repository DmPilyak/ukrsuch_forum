package com.ukrsuch.ukrsuch.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "comics")
public class ComicsArticleModel {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "Title")
	private String title;

	@Column(name = "Description")
	private String description;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "autor_name")
	private String autorName;
	
	@Column(name = "img", columnDefinition="BLOB")
	@Lob
	private Blob img;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAutorName() {
		return autorName;
	}

	public void setAutorName(String autorName) {
		this.autorName = autorName;
	}

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autorName == null) ? 0 : autorName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComicsArticleModel other = (ComicsArticleModel) obj;
		if (autorName == null) {
			if (other.autorName != null)
				return false;
		} else if (!autorName.equals(other.autorName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ComicsArticleModel [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date
				+ ", autorName=" + autorName + "]";
	}
	
	
}
