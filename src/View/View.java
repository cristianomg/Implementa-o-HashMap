package View;

import java.util.Scanner;

import Controller.Controller;

public class View {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		Controller controller = new Controller();
		while(run) {
			System.out.println("1- Cadastrar Turmas");
			System.out.println("2- Cadastrar Alunos");
			System.out.println("3- Efetuar matrícula");
			System.out.println("4- Cancelar matrícula");
			System.out.println("5- Cancelar turma");
			System.out.println("6- listar alunos na turma");
			System.out.println("7- Finalizar");
			System.out.print("Escolha uma opção: ");
			int opc = sc.nextInt();
			switch(opc) {
			case 1:
				controller.cadastrarTurma();
				break;
			case 2:
				controller.cadastrarAluno();
				break;
			case 3:
				controller.efetuarMatricula();
				break;
			case 4:
				controller.cancelarMatricula();
				break;
			case 5:
				controller.cancelarTurma();
				break;
			case 6:
				controller.listarAlunosTurma();
			case 7:
				run = false;
				break;
			default:
				System.out.println("Opção invalida, tente novamente.");
			}
			
		}
	}

}
