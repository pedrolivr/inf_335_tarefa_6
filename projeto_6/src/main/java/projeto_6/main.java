package projeto_6;
import org.bson.Document;


import com.mongodb.client.MongoDatabase;

public class main {

	public static void main(String[] args) {
	
		
		
		ConectaDb conexão = new ConectaDb();
		
		MongoDatabase db = conexão.connection("mongodb://localhost:27017", "super_mercado", "produtos");
		

		
		System.out.println("*----------COLEÇÕES EXISTENTES NO BANCO DE DADOS----------*"+"\n");
		
		Produtos.listaColecoes(db, conexão);
		Produtos.listaItens(db, conexão);
		
		
	
	
		Document n_a = new NovoProduto().novoProduto("S20", "Celular","1000");
		NovoProduto.addProduto(conexão, n_a);
		
		n_a = new NovoProduto().novoProduto("S21", "Tablet", "2000");
		NovoProduto.addProduto(conexão, n_a);
		
		
		n_a = new NovoProduto().novoProduto("alexandre", "Rocha", "555555");
		NovoProduto.addProduto(conexão, n_a);
		
		
		System.out.println("*----------ProdutoS ADICIONADOS----------*"+"\n");

		
		NovoProduto.removeProduto(conexão, "Lais");
		NovoProduto.updateName(conexão, "Pedro", "Caio");
		NovoProduto.updatePrice(conexão, "Caio", "00000");
		System.err.println("\n");
		
		
		System.out.println("*----------BANCO APÓS AS ALTERAÇÕES----------*"+"\n");
	
		
		conexão.client.close();
	}
}
	
	
	

