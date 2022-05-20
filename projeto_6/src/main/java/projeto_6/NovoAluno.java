package projeto_6;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;



public class NovoAluno {
	
	
	
	String first_name;
	String last_name;
	String phone_number;
	
	
	
		public  Document novoAluno(String fn, String ln, String pn ){
			
			
			this.first_name = fn;
			this.last_name = ln;
			this.phone_number = pn;
	
			Document naluno = new Document();
			
			naluno.append("first_name", fn);
			naluno.append("last_name", ln);
			naluno.append("phone_number", pn);
			
			
			
			return naluno;
			
			

		}
		
		public static void addAluno(ConectaDb cdb, Document dtco){
			
			
					
			MongoClient client = MongoClients.create(cdb.getUrl());			
			MongoDatabase db = client.getDatabase(cdb.getdatabase());
			MongoCollection<Document> collection = db.getCollection(cdb.getColecao());
			
			collection.insertOne(dtco);
			cdb.client.close();
		
		}
		
		public static void removeAluno(ConectaDb cdb, String fn) {
			
			
			MongoClient client = MongoClients.create(cdb.getUrl());			
			MongoDatabase db = client.getDatabase(cdb.getdatabase());
			MongoCollection<Document> collection = db.getCollection(cdb.getColecao());	
			collection.deleteOne((Filters.eq("first_name", fn)));
			cdb.client.close();
		}
			
		public static void removeAlunos(ConectaDb cdb, String fn) {
			
			
			MongoClient client = MongoClients.create(cdb.getUrl());			
			MongoDatabase db = client.getDatabase(cdb.getdatabase());
			MongoCollection<Document> collection = db.getCollection(cdb.getColecao());	
			collection.deleteMany((Filters.eq("first_name", fn)));
			cdb.client.close();
		}
		
		public static void updateFirst_Name(ConectaDb cdb, String fn, String sr) {
			
			MongoClient client = MongoClients.create(cdb.getUrl());			
			MongoDatabase db = client.getDatabase(cdb.getdatabase());
			MongoCollection<Document> collection = db.getCollection(cdb.getColecao());
			
			

			collection.updateOne(Filters.eq("first_name", fn), Updates.set("first_name", sr));
			cdb.client.close();
	
		}
		
		public static void updateLast_Name(ConectaDb cdb, String ln, String sr) {
			
			MongoClient client = MongoClients.create(cdb.getUrl());			
			MongoDatabase db = client.getDatabase(cdb.getdatabase());
			MongoCollection<Document> collection = db.getCollection(cdb.getColecao());
			
			

			collection.updateOne(Filters.eq("last_name", ln), Updates.set("last_name", sr));
			cdb.client.close();
	
		}
		
		public static void updatePhone_number(ConectaDb cdb, String fn, String sr) {
			
			MongoClient client = MongoClients.create(cdb.getUrl());			
			MongoDatabase db = client.getDatabase(cdb.getdatabase());
			MongoCollection<Document> collection = db.getCollection(cdb.getColecao());	
			

			collection.updateOne(Filters.eq("first_name", fn), Updates.set("phone_number", sr));
			cdb.client.close();
			
	
		}
		
		public String getFirstName() {
			return first_name;
		}
		
		public String getLastName() {
			return last_name;
		}
		
		public String getPhoneNumber() {
			return phone_number;
		}
}
		



		
