package projeto_6;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Produtos {
	
	
	
	static void listaColecoes(MongoDatabase mdb, ConectaDb cdb) {
		
		 mdb = cdb.connection(cdb.getUrl(), cdb.getdatabase(), cdb.getColecao());
		 Iterable<Document> collections = mdb.listCollections();

		
		for(Document col : collections) {
			System.out.println(col.get("name"));
			cdb.client.close();

	}

}
	
	
	static void listaItens(MongoDatabase mdb, ConectaDb cdb) {
		
		 mdb = cdb.connection(cdb.getUrl(), cdb.getdatabase(), cdb.getColecao());
		 MongoCollection<Document> collections = mdb.getCollection(cdb.getColecao());
		 Iterable <Document> produtos = collections.find();
		 
			for(Document produto : produtos) {	
				String fnome = produto.getString("first_name");
				String lnome = produto.getString("last_name");
				String phone = produto.getString("phone_number");
				System.out.println("Alunos"+" "+ fnome+ " - "+lnome+" - " +phone);
				
				cdb.client.close();
		
			}
	}
}