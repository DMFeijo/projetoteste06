#language: pt
#encoding: iso-8859-1

Funcionalidade: Contratacao de funcionario
 como um usuario do sistema eu quero realizar
 contratacao de funcionario para que eu 
 possa gerenciar funcionarios
 
 Esquema do Cenario: Definir tipo de contratacao do funcionario
 Dado Acessar a pagina de edicao de tipo de contratacao
 E Selecionar o funcionario <funcionario>
 E Selecionar o tipo de contratacao <tipo> 
 Quando Solicitar realizacao do cadastro
 Então Sistema exibe a mensagem "Dados atualizados com sucesso"
 
 Exemplos: 
 | funcionario           | tipo              |
 | "Eduardo Souza"       | "Estagio"         |
 | "Fabiana da Silva"    | "CLT"             |
 | "Luciana de Oliveira" | "Pessoa Jurídica" |