package cms_b.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;

@Document
public class FAQ extends ParentModel implements Serializable{

	private static final long serialVersionUID = 1L;
		
		@Field
		public String language;
		@Field
		private String type = "FAQ";
	  	@Field
	    private List<FAQQuestionAnswer> questionsAnswers = new ArrayList<FAQQuestionAnswer>();
	  	
		public FAQ() {
			super();
		}
		
		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public String getType() {
			return type;
		}

		public List<FAQQuestionAnswer> getQuestionsAnswers() {
			return questionsAnswers;
		}
		
		public void setQuestionsAnswers(List<FAQQuestionAnswer> questionsAnswers) {
			this.questionsAnswers = questionsAnswers;
		}
}
