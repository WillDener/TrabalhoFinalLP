package Menu;

import Model.*;
import Repositorio.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int op,res;
        String str;
        double x;
        LeiloesRepositorio leiloesRepositorio = new LeiloesRepositorio();
        InstituicaoRepositorio instituicaoRepositorio = new InstituicaoRepositorio();
        ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
        VeiculoRepositorio veiculoRepositorio = new VeiculoRepositorio();
        ImovelRepositorio imovelRepositorio = new ImovelRepositorio();
        do {
            System.out.println("1 - Criar Leilao");
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

            switch (op) {
                case 1:
                    Leilao leilao = new Leilao();
                    if (leilao.getInst() == null) {
                        System.out.println("Nenhuma instituicao está vinculada," +
                                " deseja vincular alguma instituicao insira: 1 " +
                                " ou registrar uma nova insira 2");
                        op = scan.nextInt();
                        switch (op) {
                            case 1:
                                System.out.println("insira o CNPJ da instituicao para buscar ");
                                str = scan.next();
                                if (instituicaoRepositorio.Consultainstituicao(str) != null) {
                                    leilao.setInst(instituicaoRepositorio.Consultainstituicao(str));
                                    break;
                                } else {
                                    System.out.println("Nenhuma Instituicao Registrada com esse CNPJ\n");
                                    break;
                                }
                            case 2:
                                Instituicao instituicao = new Instituicao();
                                System.out.println("Insira o Nome da instituicao financeira: ");
                                str = scan.next();
                                instituicao.setNome(str);
                                System.out.println("Insira o CNPJ da instituicao financeira: ");
                                str = scan.next();
                                instituicao.setCnpj(str);
                                leilao.setInst(instituicao);
                                break;
                            default:
                                System.out.println("Erro");
                                break;
                        }

                    }
                    if (leilao.getVeiculos() == null) {
                        System.out.println("Nao possui nenhum veiculo relacionado ao leilao\n" +
                                "deseja criar relacionar veiculos ao leilao insira: 1\n" +
                                "ou caso queria criar um novo post de veiculo para inserir insira: 2\n");
                        op = scan.nextInt();
                        switch (op) {
                            case 1:
                                List<Veiculo> veiculoList = new ArrayList<>();
                                System.out.println("Informe o documento do veiculo: ");
                                str = scan.next();
                                if (veiculoRepositorio.buscarPorDocumentoVeiculo(str) != null) {
                                    veiculoList.add(veiculoRepositorio.buscarPorDocumentoVeiculo(str));
                                    leilao.setVeiculos(veiculoList);
                                } else {
                                    System.out.println("Nenhum registro encontrado");
                                }
                                break;
                            case 2:
                                Veiculo veiculo = new Veiculo();
                                System.out.println("Insira o nome do veiculo: ");
                                str = scan.next();
                                veiculo.setNome(str);
                                System.out.println("Insira a descricao do Veiculo: ");
                                str = scan.next();
                                veiculo.setDescricao(str);
                                System.out.println("Insira o Documento do veiculo: ");
                                str = scan.next();
                                veiculo.setDocumento(str);
                                System.out.println("Insira a Placa do veiculo: ");
                                str = scan.next();
                                veiculo.setPlaca(str);
                                System.out.println("Insira o Ano do carro: ");
                                op = scan.nextInt();
                                veiculo.setAnoLancamento(op);
                                System.out.println("Informe o valor do veiculo: ");
                                x = scan.nextDouble();
                                veiculo.setPreco(x);
                                System.out.println("informe o tipo de veiculo: ");
                                str = scan.next();
                                veiculo.setTipo(Veiculo.TipoCarro.valueOf(str));
                                System.out.println("Deseja criar um lista de lances ja pre cadastrados insira 1" +
                                        "\n ou caso não queria insira 2");
                                op = scan.nextInt();
                                List<Lance> lances = new ArrayList<>();
                                do {
                                    switch (op) {
                                        case 1:
                                            Lance lance = new Lance();
                                            lance.setProduto(veiculo);
                                            System.out.println("Cliente que fara o lance ja possui cadastro : s or n ");
                                            str = scan.next();
                                            if (str.equals("s")) {
                                                System.out.println("informe o login e senha:");
                                                String login, senha;
                                                login = scan.next();
                                                senha = scan.next();
                                                lance.setCliente(clienteRepositorio.Consultar(login, senha));
                                            }
                                            if (str.equals("n")) {
                                                System.out.println("Cadastre um cleinte: ");
                                                String login, nome, senha, cpf;
                                                System.out.println("Informe  o nome, login, senha e cpf: ");
                                                nome = scan.next();
                                                login = scan.next();
                                                senha = scan.next();
                                                cpf = scan.next();
                                                Cliente cliente = new Cliente(nome, cpf, login, senha);
                                                lance.setCliente(cliente);
                                            } else {
                                                System.out.println("Informacao nao reconhecida");
                                            }
                                            lances.add(lance);
                                            break;
                                        case 2:
                                            break;
                                    }
                                } while (op != 2);
                                veiculo.setLances(lances);

                        }
                    }
                    if (leilao.getImovels() == null) {
                        System.out.println("Nao possui nenhum imovel relacionado ao leilao\n" +
                                "deseja criar relacionar veiculos ao leilao insira: 1\n" +
                                "ou caso queria criar um novo post de veiculo para inserir insira: 2\n");
                        op = scan.nextInt();
                        switch (op) {
                            case 1:
                                List<Imovel> imovelList = new ArrayList<>();
                                System.out.println("Informe o documento do imovel: ");
                                str = scan.next();
                                if (imovelRepositorio.ConsultarPorDoc(str) != null) {
                                    imovelList.add(imovelRepositorio.ConsultarPorDoc(str));
                                    leilao.setImovels(imovelList);
                                } else {
                                    System.out.println("Nenhum registro encontrado");
                                }
                                break;
                            case 2:
                                Imovel imovel = new Imovel();
                                System.out.println("Insira o nome do imovel: ");
                                str = scan.next();
                                imovel.setNome(str);
                                System.out.println("Insira a descricao do imovel: ");
                                str = scan.next();
                                imovel.setDescricao(str);
                                System.out.println("Insira o Documento do imovel: ");
                                str = scan.next();
                                imovel.setDocumento(str);
                                System.out.println("Insira o ano de construcao: ");
                                op = scan.nextInt();
                                imovel.setAnoConstrucao(op);
                                System.out.println("Informe o valor do imovel: ");
                                x = scan.nextDouble();
                                imovel.setPreco(x);
                                System.out.println("informe o tipo de imovel: ");
                                str = scan.next();
                                imovel.setTipo(Imovel.TipoImovel.valueOf(str));
                                System.out.println("Deseja criar um lista de lances ja pre cadastrados insira 1" +
                                        "\n ou caso não queria insira 2");
                                op = scan.nextInt();
                                List<Lance> lances = new ArrayList<>();
                                do {
                                    switch (op) {
                                        case 1:
                                            Lance lance = new Lance();
                                            lance.setProduto(imovel);
                                            System.out.println("Cliente que fara o lance ja possui cadastro : s or n ");
                                            str = scan.next();
                                            if (str.equals("s")) {
                                                System.out.println("informe o  login e senha:");
                                                String login, senha;
                                                login = scan.next();
                                                senha = scan.next();
                                                lance.setCliente(clienteRepositorio.Consultar(login, senha));
                                            }
                                            if (str.equals("n")) {
                                                System.out.println(" Cadastre um cleinte: ");
                                                String login, nome, senha, cpf;
                                                System.out.println("Informe  o nome, login, senha e cpf: ");
                                                nome = scan.next();
                                                login = scan.next();
                                                senha = scan.next();
                                                cpf = scan.next();
                                                Cliente cliente = new Cliente(nome, cpf, login, senha);
                                                lance.setCliente(cliente);
                                            } else {
                                                System.out.println("Informacao nao reconhecida");
                                            }
                                            lances.add(lance);
                                            break;
                                        case 2:
                                            break;
                                    }
                                } while (op != 2);
                                imovel.setLances(lances);
                                break;
                        }
                    }
                    if (leilao.getDataInicio() == null) {
                        System.out.println("insira a data e horario de inicio do leilao: DD/MM/YYYY HH:MI ");
                        int dia, mes, ano, hora, min;
                        dia = scan.nextInt();
                        mes = scan.nextInt();
                        ano = scan.nextInt();
                        hora = scan.nextInt();
                        min = scan.nextInt();
                        leilao.setDataInicio(new Data(dia, mes, ano, hora, min));
                    }
                    if (leilao.getDataTermino() == null) {
                        System.out.println("insira a data e horario de termino do leilao: DD/MM/YYYY HH:MI ");
                        int dia, mes, ano, hora, min;
                        dia = scan.nextInt();
                        mes = scan.nextInt();
                        ano = scan.nextInt();
                        hora = scan.nextInt();
                        min = scan.nextInt();
                        leilao.setDataTermino(new Data(dia, mes, ano, hora, min));
                    }
                    if (leilao.getEndereco() == null){
                        System.out.println("Informe o endereco do leilao: \n informe a rua, cidade, estado e cep");
                        String rua, cidade, estado,cep;
                        rua = scan.next();
                        cidade = scan.next();
                        estado = scan.next();
                        cep = scan.next();
                        leilao.setEndereco(new Endereco(rua,cidade,estado,cep));
                    }
                    System.out.println("informe a data atal para encerrar e finalizar o registro");
                    int dia,mes,ano,hora,min;
                    dia = scan.nextInt();
                    mes = scan.nextInt();
                    ano = scan.nextInt();
                    hora = scan.nextInt();
                    min = scan.nextInt();
                    leilao.setDataAtual(new Data(dia,mes,ano,hora,min));
                    break;
                case 2:
                    System.out.println("ta certo!");
                    break;
            }

        }while (op !=100 );

    }
}
