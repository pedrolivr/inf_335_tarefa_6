package projeto_6;
import org.bson.Document;


import com.mongodb.client.MongoDatabase;

public class main {

	public static void main(String[] args) {
	
		
		
		ConectaDb conexão = new ConectaDb();
		
		MongoDatabase db = conexão.connection("mongodb://localhost:27017", "super_mercado", "produtos");
		
		
		System.out.println("*----------COLEÇÕES EXISTENTES NO BANCO DE DADOS----------*"+"\n");
		
		Produtos.listaColecoes(db, conexão);
		
		System.out.println("*----------ITENS EXISTENTES NA COLEÇÃO "+conexão.getColecao()+"----------*"+"\n");
		Produtos.listaItens(db, conexão);
		
	
		Document n_a = new NovoProduto().novoProduto("S20", "Celular","1000");
		NovoProduto.addProduto(conexão, n_a);
		
		n_a = new NovoProduto().novoProduto("S21", "Tablet", "2000");
		NovoProduto.addProduto(conexão, n_a);
		
		
		n_a = new NovoProduto().novoProduto("MP3", "Player", "123.99");
		NovoProduto.addProduto(conexão, n_a);
		
		n_a = new NovoProduto().novoProduto("VHS", "Player", "123.99");
		NovoProduto.addProduto(conexão, n_a);
		
		n_a = new NovoProduto().novoProduto("VHS", "Player", "123.99");
		NovoProduto.addProduto(conexão, n_a);
		
		
		System.out.println("*----------LISTA ATUALIZADA DOS PRODUTOS----------*"+"\n");
		
		Produtos.listaItens(db, conexão);
		
		System.out.println("*----------BANCO APÓS AS ALTERAÇÕES----------*"+"\n");
			
		NovoProduto.removeProduto(conexão, "S21");
		NovoProduto.updateName(conexão, "MP3", "MP4");
		NovoProduto.updatePrice(conexão, "MP4", "125.00");
		NovoProduto.removeProdutos(conexão, "VHS");
		
		Produtos.listaItens(db, conexão);		
	
		conexão.client.close();
	}
}
	
	
	

