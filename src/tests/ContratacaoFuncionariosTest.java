package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class ContratacaoFuncionariosTest {

	WebDriver driver;

	@Dado("^Acessar a pagina de edicao de tipo de contratacao$")
	public void acessar_a_pagina_de_edicao_de_tipo_de_contratacao() {

		// definindo o local onde esta o driver do google chrome
		System.setProperty("webdriver.chrome.driver", "c:\\teste\\chromedriver.exe");

		// Abrindo o google chrome
		driver = new ChromeDriver();

		// Maximizando a janela do navegador
		driver.manage().window().maximize();

		// Acessando a pagina de cadastro de funcionario
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio02");

	}

	@Dado("^Selecionar o funcionario \"([^\"]*)\"$")
	public void selecionar_o_funcionario(String funcionario) {

		new Select(driver.findElement(By.xpath("//*[@id=\"Funcionario\"]"))).selectByVisibleText(funcionario);

	}

	@Dado("^Selecionar o tipo de contratacao \"([^\"]*)\"$")
	public void selecionar_o_tipo_de_contratacao(String tipo) {

		new Select(driver.findElement(By.xpath("//*[@id=\"TipoContratacao\"]"))).selectByVisibleText(tipo);

	}

	@Quando("^Solicitar realizacao do cadastro$")
	public void solicitar_realizacao_do_cadastro() {

		// clicar no botão de confirmação
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

	}

	@Então("^Sistema exibe a mensagem \"([^\"]*)\"$")
	public void sistema_exibe_a_mensagem(String mensagem) {

		// verificar a mensagem exibida pelo sistema
		String resultado = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// comparando a mensagem exibida pelo sistema
		assertEquals(resultado, mensagem);

		// Gerar a evidencia do teste
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			String dataAtual = new SimpleDateFormat("dd_MM_yyyy HH_mm_ss").format(new Date());

			FileUtils.copyFile(file, new File("c:\\evidencias\\Tipo de Contratacao " + dataAtual + ".png"));
		} catch (Exception e) {

		}

		// fechar o navegador
		driver.close();
		driver.quit();

	}

}
