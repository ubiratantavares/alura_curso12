package br.com.alura.screenmatch;

import br.com.alura.screenmatch.service.ConsumoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner leitura = new Scanner(System.in);
		System.out.println("Digite o titulo de um filme para busca: ");
		var titulo = leitura.nextLine();
		var consumoApi = new ConsumoApi();
		var endereco = String.format("https://www.omdbapi.com/?t=%s&apikey=201cedb8",
				titulo.replace(" ", "+"));
		System.out.println(consumoApi.obterDados(endereco));
	}
}
