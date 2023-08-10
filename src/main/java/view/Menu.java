package view;
import Controller.EstudanteController;
import Model.Estudante;

import java.util.Scanner;

public class Menu {

    private static EstudanteController controller = new EstudanteController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Estudante");
            System.out.println("2. Listar Estudantes");
            System.out.println("3. Actualizar Estudante");
            System.out.println("4. Remover Estudante");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarEstudante();
                    break;
                case 2:
                    listarEstudantes();
                    break;
                case 3:
                    atualizarEstudante();
                    break;
                case 4:
                    removerEstudante();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    private static void cadastrarEstudante() {
        System.out.println("Digite o número de matrícula:");
        int nrMatricula = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();

        System.out.println("Digite o apelido:");
        String apelido = scanner.nextLine();

        System.out.println("Digite o contacto:");
        String contacto = scanner.nextLine();

        System.out.println("Digite o endereço:");
        String endereco = scanner.nextLine();

        boolean resultado = controller.guardarEstudante(nrMatricula, nome, apelido, contacto, endereco);

        if (resultado) {
            System.out.println("Estudante cadastrado com sucesso.");
        } else {
            System.out.println("Erro ao cadastrar estudante.");
        }
    }

    private static void listarEstudantes() {
        System.out.println("Lista de Estudantes:");
        for (Estudante estudante : controller.listarEstudantes()) {
            System.out.println(estudante);
        }
    }

    private static void atualizarEstudante() {
        System.out.println("Digite o número de matrícula do estudante a ser atualizado:");
        int nrMatricula = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.println("Digite o novo nome:");
        String nome = scanner.nextLine();

        System.out.println("Digite o novo apelido:");
        String apelido = scanner.nextLine();

        System.out.println("Digite o novo contacto:");
        String contacto = scanner.nextLine();

        System.out.println("Digite o novo endereço:");
        String endereco = scanner.nextLine();

        boolean resultado = controller.atualizarEstudante(nrMatricula, nome, apelido, contacto, endereco);

        if (resultado) {
            System.out.println("Estudante atualizado com sucesso.");
        } else {
            System.out.println("Erro ao atualizar estudante.");
        }
    }

    private static void removerEstudante() {
        System.out.println("Digite o número de matrícula do estudante a ser removido:");
        int nrMatricula = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        boolean resultado = controller.removerEstudante(nrMatricula);

        if (resultado) {
            System.out.println("Estudante removido com sucesso.");
        } else {
            System.out.println("Erro ao remover estudante.");
        }
    }
}
