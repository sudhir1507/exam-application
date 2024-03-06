package org.techhub.onlineexam;
import org.techhub.helper.*;
import org.techhub.question.*;
import java.util.*;
public class OnlineExamClientApp {

	public static void main(String[] args) {
		OnlineExamHelper helper=new OnlineExamHelper();
		do {
		Scanner xyz=new Scanner(System.in);
		System.out.println("\n1 .Add Questions");
		System.out.println("2 .Remove Question");
		System.out.println("3 .Display all Questions");
		System.out.println("4 .Search Questions by name");
		System.out.println("5 .Attempt Questions");
		System.out.println("6 .Show result");
		System.out.println("Enter your choice ");
		int choice=xyz.nextInt();
		switch(choice) {
		case 1:
			xyz.nextLine();
			System.out.println("Enter the Question id");
			int qid=xyz.nextInt();
			xyz.nextLine();
			System.out.println("Enter the Question");
			String question=xyz.nextLine();
			System.out.println("Enter the option1 value");
			String option1=xyz.nextLine();
			System.out.println("Enter the option2 value");
			String option2=xyz.nextLine();
			System.out.println("Enter the option3 value");
			String option3=xyz.nextLine();
			System.out.println("Enter the option4 value");
			String option4=xyz.nextLine();
			System.out.println("Enter the answer value");
			String ans=xyz.nextLine();
			Question q=new Question();
			q.setId(qid);
			q.setName(question);
			q.setOption1(option1);
			q.setOption2(option2);
			q.setOption3(option3);
			q.setOption4(option4);
			q.setAnswer(ans);
			helper.addNewQuestion(q);
			break;
		case 2:
			System.out.println("Enter the question id which you want to remove ");
			int questionId=xyz.nextInt();
			helper.removeQuestion(questionId);
			break;
		case 3:
			helper.viewAllQuestions();
			break;
		case 4:
			xyz.nextLine();
			System.out.println("Enter the question name which you want to search ");
			String questionName=xyz.nextLine();
			boolean result=helper.searchQuestion(questionName);
			if(result) {
				System.out.println("Question found...\n");
			}else {
				System.out.println("Question not found..\n");
			}
			break;
		case 5:
			xyz.nextLine();
			System.out.println("Enter the Answer ");
			ans=xyz.nextLine();
			System.out.println("Enter the Question id ");
			qid=xyz.nextInt();
			helper.attemptQuestion(qid, ans);
			break;
		case 6:
			helper.showResult();
			break;
		default:
			System.out.println("Wrong choice..");
		}
		}while(true);
	}
	
	}


