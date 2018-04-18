DIGITO	[0-9]
LETRA	[a-zA-Z]
RESERVADA "main"
ID	{LETRA}({LETRA}|{DIGITO})*
OPERACAO [+ \- * / < >]
OPEQUAL [=][=]
OPAND [&][&]
OPOR [|][|]


%%
{RESERVADA} {printf("RESERVADA: %s\n",yytext);}	
{DIGITO}+		{printf("Inteiro: %s\n",yytext);}
{DIGITO}+"."{DIGITO}+	{printf("Real: %s\n",yytext);} 
{ID}			{printf("var: %s\n",yytext);}
{OPERACAO}      {printf("operador: %s\n",yytext);}
{OPAND} {printf("operador: %s\n",yytext);}
{OPOR} {printf("operador: %s\n",yytext);}
{OPEQUAL} {printf("operador: %s\n",yytext);}


%%
int yywrap();

main(){
  yylex();
}

int yywrap(){
 return 1;
}
