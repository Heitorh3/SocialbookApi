/* Cadastrando um autor */
INSERT INTO `socialbook`.`autor` (`nacionalidade`, `nome`) VALUES ('Brasileira', 'Carlos Drumont de Andrade');
INSERT INTO `socialbook`.`autor` (`nacionalidade`, `nome`) VALUES ('Brasileira', 'Emilio Dias');
INSERT INTO `socialbook`.`autor` (`nacionalidade`, `nome`) VALUES ('Brasileira', 'Fernando Sabino');

/* Cadastrando um livro */
INSERT INTO `socialbook`.`livro` (`editora`, `nome`, `autor_id`) VALUES ('Saraiva', 'Rest aplicado', '1');
INSERT INTO `socialbook`.`livro` (`editora`, `nome`, `autor_id`) VALUES ('Algaworks', 'Git passo-a-passo', '1');
INSERT INTO `socialbook`.`livro` (`editora`, `nome`, `autor_id`) VALUES ('SBS', 'Certificação JAVA', '1');

/* Cadastro de um comentário */
INSERT INTO `socialbook`.`comentario` (`texto`, `livro_id`) VALUES ('Esse livro é muito bom!', '1');
