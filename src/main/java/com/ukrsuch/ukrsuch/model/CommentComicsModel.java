package com.ukrsuch.ukrsuch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment_comics")
public class CommentComicsModel {
	@Id
	@Column(name = "comment_id")
	private int commentId;
	
	@Column(name = "comment_content")
	private String commentContent;

	@Column(name = "comics_id")
	private int comicsId;
	
	@Column(name = "autor_id")
	private int autorId;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getComicsId() {
		return comicsId;
	}

	public void setComicsId(int comicsId) {
		this.comicsId = comicsId;
	}

	public int getAutorId() {
		return autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}

	@Override
	public String toString() {
		return "CommentComicsModel [commentId=" + commentId + ", commentContent=" + commentContent + ", comicsId="
				+ comicsId + ", autorId=" + autorId + "]";
	}
	
}
