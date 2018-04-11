class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			
			CodeGen backend = new CodeGen(); // tirar um gerador do codigo e colocar um interpretador, arvore sintatica que ao inves de imprimir o dado ele mostra o resultado 
			String codigo = backend.geraCodigo(arv);
			System.out.println(codigo);

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
