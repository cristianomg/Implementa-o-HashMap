# Implementa-o-HashMap
## Implementação da estrutura de dados HashMap e utilização da mesma em um sistema de cadastro de turmas e alunos


<p>Implemente em Java um programa para controlar as turmas de um cursinho. O sistema é composto por uma Tabela Hash que armazena as turmas, onde, para cada turma, temos uma estrutura de dados para armazenar os alunos e outra para armazenar a fila de espera. Além disto, o sistema usa outra estrutura para armazenar o cadastro dos alunos.<p>
<p>O Programa deverá permitir:<p>


1. Cadastrar turmas
2. Cadastrar aluno
3. Efetuar matrícula
4. Cancelar matrícula
5. Cancelar turma
6. Listar alunos na turma
7. Listar turmas
<p>
Observações:
<p>
- Para cadastrar turmas deverá ser solicitado o código da turma e o número máximo de
alunos;
- Para efetuar uma matrícula deverá ser solicitado o código da turma e o RG do aluno. Se
a turma estiver cheia, a pessoa vai para a fila de espera, caso contrário a pessoa é inserida
na lista de alunos. Após efetuar a reserva do aluno, informe se ele foi para a fila de espera
ou não;
- Para cancelar uma matrícula deverá ser solicitado o código da turma e o RG do aluno. A
pessoa deverá ser removida da lista de alunos e, se a fila de espera não estiver vazia, o
primeiro aluno da fila ocupa automaticamente a vaga liberada;
- Para cancelar uma turma deverá ser solicitado o código da turma. A turma deverá ser
removida da lista assim como todos os seus alunos;
- Na listagem dos alunos deverá ser solicitado o código da turma e impresso o nome de
todos os alunos dessa turma (não entra os que estão na fila de espera):
- Na listagem das turmas deverá ser impresso um relatório com o seguinte cabeçalho:
código da turma, número de vagas, número de alunos e tamanho da fila de espera.