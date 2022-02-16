#language: pt
#encoding: iso-8859-1

Funcionalidade: Pesquisar clientes
 como um usuario do sistema eu quero
 pesquisar clintes para que eu possa
 gerenciar clientes
 
 Esquema do Cenario: Pesquisa de clientes por CPF
 Dado Acessar a pagina depesquisa de clintes
 E Informar o CPF <cpf>
 Quando solicitar a realizacao da pesquisa
 Entao sistema o nome do cliente <nome>
 E Sistema exibe a data de nascimento do cliente <datanascimento>
 E sistema exibe o email do cliente <email>
 
 Exemplos: 
 | cpf              | nome           | datanascimento | email                   |
 | "123.456.789-00" | "Ana Paula"    | "10/02/1990"   | "anapaula@gmail.com"    |
 | "456.789.123-00" | "Pedro Carlos" | "12/06/1985"   | "pedrocarlos@gmail.com" |
 | "789.123.456-00" | "Maria Souza"  | "20/08/1984"   | "mariasouza@gmail.com"  |
 