package org.techhub.helper;
import org.techhub.question.*;
import java.util.*;

public class OnlineExamHelper {
	List list=new ArrayList();
	int count=0;
	public void addNewQuestion(Question question) {
		list.add(question);
	}
	public void viewAllQuestions(){
		if(list.size()!=0) {
		for(Object obj:list) {
			Question q=(Question)obj;
			System.out.println(q.getId()+"\t"+q.getName()+"\t"+q.getOption1()+"\t"+q.getOption2()+"\t"
					+q.getOption3()+"\t"+q.getOption4()+"\t"+q.getAnswer());
		}
		}else {
			System.out.println("No Questions to display..please add Questions");
		}
	}
	public void removeQuestion(int questionId) {
		int index=0;
		boolean flag=false;
	if(list.size()!=0) {	
	for(Object obj:list) {
		Question q=(Question)obj;
		int qid=q.getId();
		if(qid==questionId) {
			index=list.indexOf(q);
			if(index!=-1) {
				flag=true;
				break;
			}
		}
	}
	if(flag) {
		list.remove(index);
		System.out.println("Question removed..\n");
	}else {
		System.out.println("Question not found..\n");
	}
	}else {
		System.out.println("No Questions to Remove..");
	}
	}
	public boolean searchQuestion(String questionName) {
		Iterator ii=list.iterator();
		boolean flag=false;
		while(ii.hasNext()) {
			Object obj=ii.next();
			Question q=(Question)obj;
			String qname=q.getName();
			if(qname.equals(questionName)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			 return true;	
		}
		else {
			return false;
		}
	}
	public void attemptQuestion(int questionId,String answer) {
		for(Object obj:list) {
			Question q=(Question)obj;
			int qid=q.getId();
			String ans=q.getAnswer();
			if(qid==questionId && ans.equals(answer)) {
				++count;
			}
		}
	}
	public void showResult() {
		if(list.size()!=0) {
		float totalQuestions=(float)list.size();
		float incorrectQuestions=totalQuestions-count;
		float  per=count/totalQuestions;
//		System.out.println("count "+count);
		System.out.println("Percetages achive by student "+(per*100));
		}else {
			System.out.println("Please add questions in test then you get result");
		}
	}
}
