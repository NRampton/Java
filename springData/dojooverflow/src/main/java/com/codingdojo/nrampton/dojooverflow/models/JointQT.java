package com.codingdojo.nrampton.dojooverflow.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jointQTs")
public class JointQT {
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="question_id")
	private Question question;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tag_id")
	private Tag tag;
	
	//constructors
	public JointQT() {
		
	}

	public JointQT(Question question, Tag tag) {
		super();
		this.question = question;
		this.tag = tag;
	}

	public Long getId() {
		return id;
	}

	public Question getQuestion() {
		return question;
	}

	public Tag getTag() {
		return tag;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
