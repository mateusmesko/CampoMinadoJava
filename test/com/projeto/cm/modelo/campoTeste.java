package com.projeto.cm.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.projeto.cm.excecao.ExplosaoExeption;

public class campoTeste {

	private Campo campo;
	
	@BeforeEach
	void iniciarCampo()
	{
		campo= new Campo(3,3);
	}
	
	@Test
	void testeVizinhoRealDistanciaEsq() {
		Campo vizinho = new Campo(3,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);
	}
	@Test
	void testeVizinhoRealDistanciaDir() {
		Campo vizinho = new Campo(3,4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeValorPadraoAtributoMarcado()
	{
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternar()
	{
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarDuas()
	{
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void AbrirNaoMinado()
	{
		
		assertTrue(campo.abrir());
	}
	@Test
	void AbrirNaoMinadoAberto()
	{
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void AbrirNaoMinadoFechado()
	{
	
		campo.minar();
		
		assertThrows(ExplosaoExeption.class, ()->{
			
		campo.abrir();
		});
	}
	
	@Test
	void AbrirVizinho()
	{
		Campo vizinho11 = new Campo(1,1);
		
		Campo vizinho22 = new Campo(2,2);
		
		vizinho22.adicionarVizinho(vizinho11);
		
		campo.adicionarVizinho(vizinho22);
	
		campo.abrir();
		
		assertTrue(vizinho22.isAberto() && vizinho11.isAberto());
	}
	
}
