package projeto_6;
import org.bson.Document;


import com.mongodb.client.MongoDatabase;

public class main {

	public static void main(String[] args) {
	
		
		
		ConectaDb conex�o = new ConectaDb();
		
		MongoDatabase db = conex�o.connection("mongodb://localhost:27017", "super_mercado", "produtos");
		
		
		System.out.println("*----------COLE��ES EXISTENTES NO BANCO DE DADOS----------*"+"\n");
		
		Produtos.listaColecoes(db, conex�o);
		
		System.out.println("*----------ITENS EXISTENTES NA COLE��O "+conex�o.getColecao()+"----------*"+"\n");
		Produtos.listaItens(db, conex�o);
		
	
		Document n_a = new NovoProduto().novoProduto("S20", "Celular","1000");
		NovoProduto.addProduto(conex�o, n_a);
		
		n_a = new NovoProduto().novoProduto("S21", "Tablet", "2000");
		NovoProduto.addProduto(conex�o, n_a);
		
		
		n_a = new NovoProduto().novoProduto("MP3", "Player", "123.99");
		NovoProduto.addProduto(conex�o, n_a);
		
		n_a = new NovoProduto().novoProduto("VHS", "Player", "123.99");
		NovoProduto.addProduto(conex�o, n_a);
		
		n_a = new NovoProduto().novoProduto("VHS", "Player", "123.99");
		NovoProduto.addProduto(conex�o, n_a);
		
		
		System.out.println("*----------LISTA ATUALIZADA DOS PRODUTOS----------*"+"\n");
		
		Produtos.listaItens(db, conex�o);
		
		System.out.println("*----------BANCO AP�S AS ALTERA��ES----------*"+"\n");
			
		NovoProduto.removeProduto(conex�o, "S21");
		NovoProduto.updateName(conex�o, "MP3", "MP4");
		NovoProduto.updatePrice(conex�o, "MP4", "125.00");
		NovoProduto.removeProdutos(conex�o, "VHS");
		
		Produtos.listaItens(db, conex�o);		
	
		conex�o.client.close();
	}
}
	
	
	

