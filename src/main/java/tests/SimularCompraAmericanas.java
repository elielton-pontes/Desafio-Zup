package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suporte.Web;


public class SimularCompraAmericanas {
	private WebDriver navegador;
	
	
	@Before
	public void inicializar() {
		navegador = Web.createChrome();
	}
	
	@Test
	public void simularUmProdutoNoCarrinho() {
		
		
        
        //Digitar no campo pesquisar com o id  "h_search-input" , algum produto.
        navegador.findElement(By.id("h_search-input")).sendKeys("Notebook");
        
        //Clicar no botão de pesquisar através do seu xpath "//button[@type="submit"]"
        navegador.findElement(By.xpath("//button[@type=\"submit\"]")).click();
       
        // Validando retorno da busca 
        Assert.assertEquals("notebook",navegador.findElement(By.xpath("//h1[@class = \"h1 page-title\"]")).getText());
        
        //Ir para o produto desejado utilizando a url "https://www.americanas.com.br/produto/133621741?pfm_carac=Notebook&pfm_page=search&pfm_pos=grid&pfm_type=search_page&voltagem=BIVOLT"
        navegador.get("https://www.americanas.com.br/produto/133621741?pfm_carac=Notebook&pfm_page=search&pfm_pos=grid&pfm_type=search_page&voltagem=BIVOLT");
        
        // Clicar no botão de comprar para por o produto no carrinho utilizando o xpath "//a[@class = \"TouchableUI-sc-1i9za0i-6 klvhBE TouchableA-p6nnfn-0 joVuoc\"]"
        navegador.findElement(By.xpath("//a[@class = \"TouchableUI-sc-1i9za0i-6 klvhBE TouchableA-p6nnfn-0 joVuoc\"]")).click();

        
        //Confirmar o produto escolhido utilizando xpath "//a[@value='Sim, continuar']"
        navegador.findElement(By.xpath("//a[@value='Sim, continuar']")).click();
        
        //Clicar no botão continuar sem garantia de furto e roubo utilizando o id "btn-continue"
        navegador.findElement(By.id("btn-continue")).click();
        
        //Validando o produto no carrinho
        Assert.assertEquals("minha cesta", navegador.findElement(By.xpath("//h2[@class =\"page-title col-xs-7\"]")).getText());
	}

	
	@After
	public void finalizar() {
        //Fechar o navegador
        navegador.quit();
	}
}
