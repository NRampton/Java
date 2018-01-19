package com.codingdojo.nrampton.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.dojooverflow.models.Answer;
import com.codingdojo.nrampton.dojooverflow.models.JointQT;
import com.codingdojo.nrampton.dojooverflow.models.Question;
import com.codingdojo.nrampton.dojooverflow.models.Tag;
import com.codingdojo.nrampton.dojooverflow.repositories.AnswerRepository;
import com.codingdojo.nrampton.dojooverflow.repositories.JointQTRepository;
import com.codingdojo.nrampton.dojooverflow.repositories.QuestionRepository;
import com.codingdojo.nrampton.dojooverflow.repositories.TagRepository;

@Service
public class QuestionService {

	private QuestionRepository _qr;
	private AnswerRepository _ar;
	private TagRepository _tr;
	private JointQTRepository _jr;
	
	
	
	public QuestionService(QuestionRepository _qr, AnswerRepository _ar, TagRepository _tr, JointQTRepository _jr) {
		super();
		this._qr = _qr;
		this._ar = _ar;
		this._tr = _tr;
		this._jr = _jr;
	}

	public List<Question> getAllQuestions() {
		return (List<Question>) _qr.findAll();
	}
	
	public Question getQuestionById(Long id) {
		return _qr.findOne(id);
	}
	
	public void createQuestion(Question question) {
		_qr.save(question);
	}
	
	public Tag createTag(String subject) {
		List<Tag> allTags = (List<Tag>) _tr.findAll();
		for ( Tag targetTag : allTags) {
			String targetSubject = targetTag.getSubject();
			if (subject.equals(targetSubject)) {
				return targetTag;
			}
		}
		Tag tag = new Tag(subject);
		_tr.save(tag);
		return tag;
	}
	
	public void rollAJointQT(Question question, Tag tag) {
		JointQT newJoint = new JointQT(question, tag);
		_jr.save(newJoint);
	}
	
	public void createAnswer(Answer answer) {
		_ar.save(answer);
	}
	
	public void theNuclearOption() {
		_qr.deleteAll();
		_ar.deleteAll();
		_tr.deleteAll();
		_jr.deleteAll();
	}
	
}
