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

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PesquisarClientesTest {

	WebDriver driver;

	@Dado("^Acessar a pagina depesquisa de clintes$")
	public void acessar_a_pagina_depesquisa_de_clintes() {

		// definindo o local onde esta o driver do google chrome
		System.setProperty("webdriver.chrome.driver", "c:\\teste\\chromedriver.exe");

		// Abrindo o google chrome
		driver = new ChromeDriver();

		// Maximizando a janela do navegador
		driver.manage().window().maximize();

		// Acessando a pagina de cadastro de funcionario
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio04");

	}

	@Dado("^Informar o CPF \"([^\"]*)\"$")
	public void informar_o_CPF(String cpf) {

		driver.findElement(By.xpath("//*[@id=\"Cpf\"]")).sendKeys(cpf);

	}

	@Quando("^solicitar a realizacao da pesquisa$")
	public void solicitar_a_realizacao_da_pesquisa() {

		driver.findElement(By.xpath("//*[@id=\"btnPesquisa\"]")).click();

	}

	@Entao("^sistema o nome do cliente \"([^\"]*)\"$")
	public void sistema_o_nome_do_cliente(String nome) {

		// ler a mensagem exibida na tela do sistema
		String resultado = driver.findElement(By.xpath("//*[@id=\"nome\"]")).getText();

		// comparando a mensagem obitida com o resultado esperado na feature
		assertEquals(resultado, nome);

	}

	@Entao("^Sistema exibe a data de nascimento do cliente \"([^\"]*)\"$")
	public void sistema_exibe_a_data_de_nascimento_do_cliente(String dataNascimento) {

		// ler a mensagem exibida na tela do sistema
		String resultado = driver.findElement(By.xpath("//*[@id=\"datanascimento\"]")).getText();

		// comparando a mensagem obitida com o resultado esperado na feature
		assertEquals(resultado, dataNascimento);

	}

	@Entao("^sistema exibe o email do cliente \"([^\"]*)\"$")
	public void sistema_exibe_o_email_do_cliente(String email) {

		// ler a mensagem exibida na tela do sistema
		String resultado = driver.findElement(By.xpath("//*[@id=\"email\"]")).getText();

		// comparando a mensagem obitida com o resultado esperado na feature
		assertEquals(resultado, email);

		// Gerar a evidencia do teste
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			String dataAtual = new SimpleDateFormat("dd_MM_yyyy HH_mm_ss").format(new Date());

			FileUtils.copyFile(file, new File("c:\\evidencias\\Pesquisar Clientes " + dataAtual + ".png"));
		} catch (Exception e) {

		}

		// fechar o navegador
		driver.close();
		driver.quit();

	}

}
