package projeto_6;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class ConectaDb {
	
	String url;
	String database;
	String col;
	MongoClient client;
	
	
	public MongoDatabase connection(String url, String database, String coleção) {
		
		this.url = url;
		this.database = database;
		this.col = coleção;
		
		MongoClient client = MongoClients.create(url);		
		this.client = client;
		MongoDatabase db = client.getDatabase(database);
		return db;

	}
	
	public String getUrl() {
		return this.url;
	}
	
	public String getdatabase() {
		return this.database;
	}
	public String getColecao() {
		return this.col;	
	}
	
	public MongoClient getclient() {
		return this.client;	
	}
}
