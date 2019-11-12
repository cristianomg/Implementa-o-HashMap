package Model;

import estrutura.FilaComListaDuplamenteEncadeada.FilaComLista;
import estrutura.Interfaces.Fila;
import estrutura.ListaDuplamenteEncadeada.classes.ListaDuplamenteEncadeada;

public class Turma {

	private String codigoTurma;
	private int numeroMaximoAlunos;
	private ListaDuplamenteEncadeada<Aluno> alunosMatriculados = new ListaDuplamenteEncadeada<Aluno>();
	private Fila<Aluno> alunosEmEspera = new FilaComLista();
	
	
	public Turma(String codigoTurma, int numeroMaximoAlunos) {
		super();
		this.codigoTurma = codigoTurma;
		this.numeroMaximoAlunos = numeroMaximoAlunos;
	}
	
	public void cadastrarAluno (Aluno aluno) {
		if (alunosMatriculados.tamanho() < numeroMaximoAlunos) {
			alunosMatriculados.adicionar(aluno);
			System.out.println("Aluno não entrou na fila de espera");
		}else {
			alunosEmEspera.enfileirar(aluno);
			System.out.println("Aluno entrou na fila de espera");
		}
	}
	
	public void cancelarMatricula(Aluno aluno) {
		alunosMatriculados.remover(alunosMatriculados.existe(aluno));
		if (alunosMatriculados.tamanho() < numeroMaximoAlunos) {
			if (alunosEmEspera.tamanho() > 0) {
				alunosMatriculados.adicionar(alunosEmEspera.desenfileirar());
		}
		}
	}

	public String getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	public int getNumeroMaximoAlunos() {
		return numeroMaximoAlunos;
	}

	public void setNumeroMaximoAlunos(int numeroMaximoAlunos) {
		this.numeroMaximoAlunos = numeroMaximoAlunos;
	}

	public ListaDuplamenteEncadeada<Aluno> getAlunosMatriculados() {
		return alunosMatriculados;
	}

	public void setAlunosMatriculados(ListaDuplamenteEncadeada<Aluno> alunosMatriculados) {
		this.alunosMatriculados = alunosMatriculados;
	}

	public Fila<Aluno> getAlunosEmEspera() {
		return alunosEmEspera;
	}

	public void setAlunosEmEspera(Fila<Aluno> alunosEmEspera) {
		this.alunosEmEspera = alunosEmEspera;
	}
	
	
	
}
