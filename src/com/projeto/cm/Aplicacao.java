package com.projeto.cm;

import com.projeto.cm.modelo.Tabuleiro;
import com.projeto.cm.visao.TabuleiroConsole;

public class Aplicacao {
	
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 4);
		
		new TabuleiroConsole(tabuleiro);
	
	}
}
