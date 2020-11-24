package com.ukrsuch.ukrsuch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment_articles")
public class CommentArticleModel {
	@Id
	@Column(name = "comment_id")
	private int commentId;
	
	@Column(name = "comment_content")
	private String commentContent;

	@Column(name = "article_id")
	private int articleId;
	
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

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getAutorId() {
		return autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}

	@Override
	public String toString() {
		return "CommentArticleModel [commentId=" + commentId + ", commentContent=" + commentContent + ", articleId="
				+ articleId + ", autorId=" + autorId + "]";
	}
	
	
}
