package projeto_6;
import org.bson.Document;


import com.mongodb.client.MongoDatabase;

public class main {

	public static void main(String[] args) {
	
		
		
		ConectaDb conex�o = new ConectaDb();
		
		MongoDatabase db = conex�o.connection("mongodb://localhost:27017", "super_mercado", "produtos");
		

		
		System.out.println("*----------COLE��ES EXISTENTES NO BANCO DE DADOS----------*"+"\n");
		
		Produtos.listaColecoes(db, conex�o);
		Produtos.listaItens(db, conex�o);
		
		
	
	
		Document n_a = new NovoProduto().novoProduto("S20", "Celular","1000");
		NovoProduto.addProduto(conex�o, n_a);
		
		n_a = new NovoProduto().novoProduto("S21", "Tablet", "2000");
		NovoProduto.addProduto(conex�o, n_a);
		
		
		n_a = new NovoProduto().novoProduto("alexandre", "Rocha", "555555");
		NovoProduto.addProduto(conex�o, n_a);
		
		
		System.out.println("*----------ProdutoS ADICIONADOS----------*"+"\n");

		
		NovoProduto.removeProduto(conex�o, "Lais");
		NovoProduto.updateName(conex�o, "Pedro", "Caio");
		NovoProduto.updatePrice(conex�o, "Caio", "00000");
		System.err.println("\n");
		
		
		System.out.println("*----------BANCO AP�S AS ALTERA��ES----------*"+"\n");
	
		
		conex�o.client.close();
	}
}
	
	
	

