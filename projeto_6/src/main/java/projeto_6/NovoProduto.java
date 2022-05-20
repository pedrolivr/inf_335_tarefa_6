package projeto_6;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;



public class NovoProduto {
	
	
	
	String name;
	String type;
	String price;
	
	
	
		public  Document novoProduto(String name, String type, String price ){
			
			
			this.name = name;
			this.type = type;
			this.price = price;
	
			Document naluno = new Document();
			
			naluno.append("name", name);
			naluno.append("type", type);
			naluno.append("price", price);
			
			
			
			return naluno;
			
			

		}
		
		public static void addProduto(ConectaDb cdb, Document dtco){
			
			
					
			MongoClient client = MongoClients.create(cdb.getUrl());			
			MongoDatabase db = client.getDatabase(cdb.getdatabase());
			MongoCollection<Document> collection = db.getCollection(cdb.getColecao());
			
			collection.insertOne(dtco);
			cdb.client.close();
		
		}
		
		public static void removeProduto(ConectaDb cdb, String fn) {
			
			
			MongoClient client = MongoClients.create(cdb.getUrl());			
			MongoDatabase db = client.getDatabase(cdb.getdatabase());
			MongoCollection<Document> collection = db.getCollection(cdb.getColecao());	
			collection.deleteOne((Filters.eq("name", fn)));
			cdb.client.close();
		}
			
		public static void removeProdutos(ConectaDb cdb, String fn) {
			
			
			MongoClient client = MongoClients.create(cdb.getUrl());			
			MongoDatabase db = client.getDatabase(cdb.getdatabase());
			MongoCollection<Document> collection = db.getCollection(cdb.getColecao());	
			collection.deleteMany((Filters.eq("name", fn)));
			cdb.client.close();
		}
		
		public static void updateName(ConectaDb cdb, String fn, String sr) {
			
			MongoClient client = MongoClients.create(cdb.getUrl());			
			MongoDatabase db = client.getDatabase(cdb.getdatabase());
			MongoCollection<Document> collection = db.getCollection(cdb.getColecao());
			
			

			collection.updateOne(Filters.eq("name", fn), Updates.set("name", sr));
			cdb.client.close();
	
		}
		
		public static void updateType(ConectaDb cdb, String name, String sr) {
			
			MongoClient client = MongoClients.create(cdb.getUrl());			
			MongoDatabase db = client.getDatabase(cdb.getdatabase());
			MongoCollection<Document> collection = db.getCollection(cdb.getColecao());
			
			

			collection.updateOne(Filters.eq("name", name), Updates.set("type", sr));
			cdb.client.close();
	
		}
		
		public static void updatePrice(ConectaDb cdb, String name, String price) {
			
			MongoClient client = MongoClients.create(cdb.getUrl());			
			MongoDatabase db = client.getDatabase(cdb.getdatabase());
			MongoCollection<Document> collection = db.getCollection(cdb.getColecao());	
			

			collection.updateOne(Filters.eq("name", name), Updates.set("price", price));
			cdb.client.close();
			
	
		}
		
		public String getName() {
			return name;
		}
		
		public String getType() {
			return type;
		}
		
		public String getPrice() {
			return price;
		}
}
		



		
