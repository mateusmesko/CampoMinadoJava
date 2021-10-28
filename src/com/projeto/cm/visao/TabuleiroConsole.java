package com.projeto.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import com.projeto.cm.excecao.ExplosaoExeption;
import com.projeto.cm.excecao.sairException;
import com.projeto.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
	
	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);
	
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			
			while(continuar) {
				cicloDoJogo();
				
				System.out.println("outra partida(S/n)");
				String reposta = entrada.nextLine();
				if("n".equalsIgnoreCase(reposta))
				{
					continuar= false;
				}else {
					tabuleiro.reiniciar(); 
				}
			}
		} catch (sairException e) {
			System.out.println("Tchau!!");
		}finally {
			entrada.close();
		}
	}

	private void cicloDoJogo() {
		try {
			while (!tabuleiro.objetivoTrue()) {
				System.out.println(tabuleiro);
				String digitado=capturarValorDigitado("digite linha e coluna desejada");
				
				Iterator<Integer> xy =Arrays.stream(digitado.split(","))
					.map(e -> Integer.parseInt(e.trim())).iterator();
				digitado=capturarValorDigitado("1 - abrir ou 2 -(des)marcar:");
				
				if("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				}else if("2".equals(digitado)) {
					tabuleiro.alternarMarcacao(xy.next(), xy.next());
				}
			}
			
			System.out.println("GANHOU!!!");
		} catch (ExplosaoExeption e) {
			System.out.println(tabuleiro);
			System.out.println("PERDEU!!!");
		}
	}
	private String capturarValorDigitado(String texto) {
		System.out.print(texto);
		
		String digitado = entrada.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new sairException();
		}
		return digitado;
	}
}
