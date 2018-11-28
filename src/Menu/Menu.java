package Menu;

import java.util.Scanner;

public class Menu {

    public static void menu(){
        Scanner scan = new Scanner(System.in);
        int op;
        do {
            System.out.println("1 - Criar Leilao: ");
            System.out.println("2 - Registrar Cliente");
            System.out.println("3 - Registrar Produto no leilao");
            System.out.println("4 - Dar Lance em um leilao");
            System.out.println("5 - Consultar Leiloes");
            System.out.println("6 - Fazer Alterecao em registros");
            System.out.println("7 - Ver lista de Lances do produto");
            System.out.println("8 - Buscar por Leilao especifico");
            System.out.println("10 - Filtro de Busca em leilao");
            System.out.println("11 - Registrar Instituicao");
            op = scan.nextInt();
        }while (op !=100 );

    }
}
