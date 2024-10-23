package br.com.dlima;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	ClienteServiceTeste.class,
	ClienteDAOTeste.class,
	ProdutoServiceTeste.class
})
public class AllTestes {}
