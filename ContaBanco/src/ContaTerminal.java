import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Lendo o número da conta
            System.out.print("Digite o Número da conta: ");
            while (!scanner.hasNextInt()) { // Valida se é um número inteiro
                System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
                scanner.next(); // Consome a entrada inválida
            }
            int num = scanner.nextInt();
            scanner.nextLine(); // Consome o caractere de nova linha
            System.out.println("Você digitou: " + num);

            // Lendo o número da agência
            System.out.print("Digite o Número da agência (ex.: 067-8): ");
            String agencia = scanner.nextLine();
            while (!agencia.matches("\\d{3}-\\d")) { // Valida o formato ex.: 123-4
                System.out.println("Entrada inválida! Use o formato 123-4.");
                System.out.print("Digite o Número da agência: ");
                agencia = scanner.nextLine();
            }
            System.out.println("Você digitou: " + agencia);

            
            System.out.print("Digite seu Nome: ");
            String nomeCliente = scanner.nextLine();
            while (nomeCliente.trim().isEmpty()) { // Valida se o nome não está vazio
                System.out.println("Entrada inválida! O nome não pode estar vazio.");
                System.out.print("Digite seu Nome: ");
                nomeCliente = scanner.nextLine();
            }
            System.out.println("Você digitou: " + nomeCliente);

            // Lendo o saldo
            System.out.print("Digite o Saldo atual (ex.: 237.45): ");
            String saldoTexto = scanner.nextLine();
            while (!saldoTexto.matches("\\d+(\\.\\d+)?|\\d+(,\\d+)?")) { // Valida formato decimal
                System.out.println("Entrada inválida! Digite um valor decimal (ex.: 237.45).");
                System.out.print("Digite o Saldo atual: ");
                saldoTexto = scanner.nextLine();
            }
            double saldo = Double.parseDouble(saldoTexto.replace(",", "."));
            System.out.println("Você digitou: " + saldo);

            // Exibindo a mensagem final
            System.out.println("\nOlá " + nomeCliente + ", obrigado por criar uma conta em nosso banco.");
            System.out.println("Sua agência é " + agencia + ", conta " + num + " e seu saldo " + saldo + " já está disponível para saque.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado. Por favor, reinicie o programa.");
        } finally {
            scanner.close(); 
        }
    }
}
