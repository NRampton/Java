package com.codingdojo.nrampton.dojooverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="questions")
public class Question {
	@Id
	@GeneratedValue
	private Long id;
	@Size(min=1, message="That is literally no question at all. Put some text in there.")
	private String text;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@OneToMany(mappedBy="question", fetch=FetchType.LAZY)
	private List<Answer> answers;
	@OneToMany(mappedBy="question", fetch=FetchType.LAZY)
	private List<JointQT> joints;
	
	//constructors
	public Question(String text) {
		super();
		this.text = text;
	}
	
	public Question() {
		
	}
	
	//handle createdAt and updatedAt
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void updatedAt() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public List<JointQT> getJoints() {
		return joints;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void setJoints(List<JointQT> joints) {
		this.joints = joints;
	}

}
