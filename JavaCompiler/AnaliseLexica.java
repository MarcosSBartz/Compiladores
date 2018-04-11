import java.io.*;

enum TokenType{ NUM,SOMA, MULT, DIV, SUB,APar,FPar, EOF}

class Token{
  String lexema;
  TokenType token;

 Token (String l, TokenType t)
 	{ lexema=l;token = t;}	

}

class AnaliseLexica {

	BufferedReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new BufferedReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception
	{	
		Token token;
		int eof = -1;
		String currchar;
		int currchar1;
		int i=0;
		int j=0;

			do{
				currchar1 =  arquivo.read();
				if (currchar1 == '*' || currchar1 == '/' || currchar1 == '-' || currchar1 == '+')
					break;
				currchar[i] += (char) currchar1;
				i++;
			} while ((currchar[i] == '\n' || currchar[i] == ' ' || currchar[i] =='\t' || currchar[i] == '\r') || ((currchar1 != '*' && currchar1 != '/' && currchar1 != '-' && currchar1 != '+'));
			
			for(j=0;j<i;j++)
			{	
				if(currchar[j] != eof && currchar[j] !=10)
				{
		
					if (currchar[j] >= '0' && currchar <= '9')
						return (new Token (currchar, TokenType.NUM));
					else
						switch (currchar){
							case '(':
								return (new Token (currchar,TokenType.APar));
							case ')':
								return (new Token (currchar,TokenType.FPar));
							case '+':
								return (new Token (currchar,TokenType.SOMA));
							case '-':
								return (new Token (currchar,TokenType.SUB));
							case '*':
								return (new Token (currchar,TokenType.MULT));
							case '/':
								return (new Token (currchar,TokenType.DIV));
							default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
						}
				}
			}

			arquivo.close();
			
		return (new Token(currchar,TokenType.EOF));
		
	}
}
