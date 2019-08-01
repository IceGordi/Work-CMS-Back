package cms_b.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document
public class FAQ {

	@Field
		public boolean available;
		@Field
		public Date created;
		@Field
		public Date modified;
		@Field
		public String keyId;
		@Field
		public String id;

	
		@Field
		public String language;
		@Field
		private String type = "faq";
	  	@Field
	    private List<FAQQuestionAnswer> questionsAnswers = new ArrayList<FAQQuestionAnswer>();
	  	
	  	@Field
		@Id
		public String docId;
	  	
		public FAQ() {}
		
		
		
		public FAQ(boolean available, Date created, Date modified, String keyId, String id, String language,
				String type, List<FAQQuestionAnswer> questionsAnswers, String docId) {
			this.available = available;
			this.created = created;
			this.modified = modified;
			this.keyId = keyId;
			this.id = id;
			this.language = language;
			this.type = type;
			this.questionsAnswers = questionsAnswers;
			this.docId = docId;
		}



		public boolean isAvailable() {
			return available;
		}



		public void setAvailable(boolean available) {
			this.available = available;
		}



		public Date getCreated() {
			return created;
		}



		public void setCreated(Date created) {
			this.created = created;
		}



		public Date getModified() {
			return modified;
		}



		public void setModified(Date modified) {
			this.modified = modified;
		}



		public String getKeyId() {
			return keyId;
		}



		public void setKeyId(String keyId) {
			this.keyId = keyId;
		}



		public String getId() {
			return id;
		}



		public void setId(String id) {
			this.id = id;
		}



		public void setType(String type) {
			this.type = type;
		}



		public void setDocId(String docId) {
			this.docId = docId;
		}



		public String getDocId() {
			return docId;
		}

		public void set_DocId(String docId) {
			this.docId = docId;
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
