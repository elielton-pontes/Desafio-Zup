package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Web {

	  
	public static WebDriver createChrome() {
		//Abrindo Navegador
		System.setProperty("webdriver.chrome.driver","C:\\Users\\eliel\\chromedriver.exe");
	    WebDriver navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Navegando para a p�gina da Americana
        navegador.get("https://www.americanas.com.br");

        return navegador;
	}
}

//	Cen�rio: Deve simular um produto no carrinho do site Americanas
//		Dado que eu entro no site da americanas
//		E no campo  buscar digito Notebook
//		E clico no Notebook desejado
//		Quando clicar no bot�o comprar 
//		Ent�o o produto ser� adicionado no carrinho