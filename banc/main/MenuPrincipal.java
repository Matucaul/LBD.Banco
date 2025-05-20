import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        telaPrincipal();
    }

    public static void telaPrincipal() {
        try (Scanner scanner = new Scanner(System.in)) {
            int opc;
            String senhaF = "funct";
            String senhaC = "senha";
            String senhaDig;

            while (true) {
                menuTela();
                System.out.print("Digite a opção: ");
                
                try {
                    opc = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    opc = -1;
                }

                System.out.println();

                switch (opc) {
                    case 1:
                        System.out.print("Digite a senha: ");
                        senhaDig = scanner.nextLine();
                        System.out.println();

                        if (senhaF.equals(senhaDig)) {
                            limparTela();
                            funcaoFuncionario();
                        } else {
                            System.out.println("**senha invalida**\n\n\n\n");
                            limparTela();
                        }
                        break;

                    case 2:
                        System.out.print("Digite a senha: ");
                        senhaDig = scanner.nextLine();
                        System.out.println();

                        if (senhaC.equals(senhaDig)) {
                            limparTela();
                            funcaoCliente();
                        } else {
                            System.out.println("**senha invalida**\n\n\n\n");
                            limparTela();
                        }
                        break;

                    case 3:
                        System.out.println("\nSaindo...");
                        return;

                    default:
                        System.out.println("\n**Opcao invalida.**\n\n\n\n");
                        limparTela();
                        break;
                }
            }
        }
    }

    // Simula o menu (você pode modificar conforme necessário)
    public static void menuTela() {
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1. Acessar como Funcionário");
        System.out.println("2. Acessar como Cliente");
        System.out.println("3. Sair");
    }

    // Espera em milissegundos
    public static void esperar(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Simula a limpeza da tela (não funciona em todos os terminais)
    public static void limparTela() {
        for (int i = 0; i < 50; i++) System.out.println();
    }

    // Funções simuladas
    public static void funcaoFuncionario() {
        System.out.println("Acesso do funcionário concedido!");
        // lógica aqui
    }

    public static void funcaoCliente() {
        System.out.println("Acesso do cliente concedido!");
        // lógica aqui
    }
}