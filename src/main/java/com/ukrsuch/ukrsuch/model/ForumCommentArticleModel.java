package com.ukrsuch.ukrsuch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "comment_forum_articles")
public class ForumCommentArticleModel {
	@Id
	@Column(name = "comment_id")
	private int commentId;
	
	@Column(name = "comment_content")
	private String commentContent;

	@NaturalId
	@Column(name = "forum_article_id")
	private int forumArticleId;
	
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

	public int getForumArticleId() {
		return forumArticleId;
	}

	public void setForumArticleId(int forumArticleId) {
		this.forumArticleId = forumArticleId;
	}

	public int getAutorId() {
		return autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}
	
	@Override
	public String toString() {
		return "ForumCommentArticleModel [commentId=" + commentId + ", commentContent=" + commentContent
				+ ", forumArticleId=" + forumArticleId + ", autorId=" + autorId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + autorId;
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result + commentId;
		result = prime * result + forumArticleId;
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
		ForumCommentArticleModel other = (ForumCommentArticleModel) obj;
		if (autorId != other.autorId)
			return false;
		if (commentContent == null) {
			if (other.commentContent != null)
				return false;
		} else if (!commentContent.equals(other.commentContent))
			return false;
		if (commentId != other.commentId)
			return false;
		if (forumArticleId != other.forumArticleId)
			return false;
		return true;
	}
	
	
}

