package Controller;

import java.util.Scanner;

import Model.Aluno;
import Model.Turma;
import estrutura.HashMap;
import estrutura.ListaDuplamenteEncadeada.classes.ListaDuplamenteEncadeada;

public class Controller {

	private HashMap<String, Turma> turmasCadastradas = new HashMap<String, Turma>();
	private ListaDuplamenteEncadeada<Aluno> alunosCadastrados = new ListaDuplamenteEncadeada<Aluno>();
	private Scanner sc = new Scanner(System.in);

	public void cadastrarTurma() {
		System.out.print("Informe o codigo da turma: ");
		String codigoTurma = sc.next();
		System.out.print("Informe o numero maximo de alunos: ");
		int numeroMaximoAlunos = sc.nextInt();
		Turma turma = new Turma(codigoTurma, numeroMaximoAlunos);
		turmasCadastradas.inserir(codigoTurma, turma);
		System.out.println("Turma Cadastrada!!");
	}

	public void cadastrarAluno() {
		System.out.print("Informe o nome do aluno: ");
		String nome = sc.next();
		System.out.print("Informe o rg do aluno: ");
		String rg = sc.next();
		alunosCadastrados.adicionar(new Aluno(nome, rg));
		System.out.println("Aluno Cadastrado !!!");
	}

	public void efetuarMatricula() {
		System.out.println("Informe o codigo da Turma: ");
		String codigoTurma = sc.next();
		Turma turma = turmasCadastradas.obter(codigoTurma);
		System.out.println(turma);
		System.out.println("Informe o RG do aluno: ");
		String rgAluno = sc.next();
		Aluno alunoMatricular = null;
		for (Aluno aluno : alunosCadastrados) {
			if (aluno.getRg().equals(rgAluno)) {
				alunoMatricular = aluno;
			}
		}
		System.out.println(turmasCadastradas.tamanho());
		if (turma != null) {
			if (alunoMatricular != null) {
				turma.cadastrarAluno(alunoMatricular);
			} else {
				System.out.println("Aluno não encontrado no sistema");
			}
		} else
			System.out.println("Turma não encontrada no sistema");
	}

	public void cancelarMatricula() {
		System.out.print("Informe o codigo da turma: ");
		String codigoTurma = sc.next();
		System.out.print("Informe o RG do aluno: ");
		String rgAluno = sc.next();
		Aluno alunoCancelarMatricula = null;
		for (Aluno aluno : alunosCadastrados) {
			if (aluno.getRg().equals(rgAluno)) {
				alunoCancelarMatricula = aluno;
			}
		}
		Turma turma = turmasCadastradas.obter(codigoTurma);
		if (turma != null) {
			if (alunoCancelarMatricula != null) {
				turma.cancelarMatricula(alunoCancelarMatricula);
				System.out.println("Matricula cancelada");
			} else
				System.out.println("Aluno não está cadastrado no sistema");
		}
	}
	
	public void cancelarTurma() {
		System.out.println("Informe o codigo da turma");
		String codigoTurma = sc.next();
		Turma turma = turmasCadastradas.obter(codigoTurma);
		turmasCadastradas.remover(codigoTurma);
	}
	
	public void listarAlunosTurma() {
		System.out.println("Informe o codigo da turma");
		String codigoTurma = sc.next();
		Turma turma = turmasCadastradas.obter(codigoTurma);
		if (turma != null) {
			for(Aluno aluno : turma.getAlunosMatriculados()) {
				System.out.println(aluno.getNome());
			}
		}
	}
}
