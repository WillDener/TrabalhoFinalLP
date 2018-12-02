package Menu;

import Model.*;
import Repositorio.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int op,dia,mes,ano,hora,min;
        String str , login, senha , nome , cpf, rua, cidade, estado,cep ;
        double x,maximo,minimo;
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
            System.out.println("8 - Filtro de Busca em leilao");
            System.out.println("9 - Registrar Instituicao financeira");
            System.out.println("100 - sair");
            op = scan.nextInt();
            switch (op) {
                case 1:
                    Leilao leilao = new Leilao();
                    if (leilao.getInst() == null) {
                        System.out.println("Nenhuma instituicao está vinculada");
                        do {
                            System.out.println(" deseja vincular alguma instituicao insira: 1\n " +
                                    " ou registrar uma nova insira 2\n" + "para sair insira e processeguir 3\n");
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
                                    System.out.println("instituicao vinculada ao leilao com sucesso!");
                                    instituicaoRepositorio.AdicionarInstituicao(instituicao);
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Erro");
                                    break;
                            }

                        } while (op != 3);
                    }
                    if (leilao.getVeiculos() == null) {
                        System.out.println("Nao possui nenhum veiculo relacionado ao leilao\n");
                        do {

                            System.out.println("deseja criar relacionar veiculos ao leilao insira: 1\n" +
                                    "ou caso queria criar um novo post de veiculo para inserir insira: 2\n"
                                    + "caso queira sair e processeguir insira 3");
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
                                    System.out.println("informe o tipo de veiculo:<CARRO/MOTOCICLETA> ");
                                    str = scan.next();
                                    veiculo.setTipo(Veiculo.TipoCarro.valueOf(str));
                                    List<Lance> lances = new ArrayList<>();
                                    do {
                                        System.out.println("Deseja criar um lista de lances ja pre cadastrados insira 1" +
                                                "\n ou caso não queria insira 2");
                                        op = scan.nextInt();
                                        switch (op) {
                                            case 1:
                                                Lance lance = new Lance();
                                                lance.setProduto(veiculo);
                                                System.out.println("Cliente que fara o lance ja possui cadastro : s or n ");
                                                str = scan.next();
                                                if (str.equals("s")) {
                                                    System.out.println("informe o login e senha:");
                                                    login = scan.next();
                                                    senha = scan.next();
                                                    lance.setCliente(clienteRepositorio.Consultar(login, senha));
                                                    System.out.println("informe o valor do lance: ");
                                                    x = scan.nextDouble();
                                                    lance.setValor(x);
                                                    lances.add(lance);
                                                    break;
                                                }
                                                if (str.equals("n")) {
                                                    System.out.println("Cadastre um cleinte: ");
                                                    System.out.println("Informe  o nome, login, senha e cpf: ");
                                                    nome = scan.next();
                                                    login = scan.next();
                                                    senha = scan.next();
                                                    cpf = scan.next();
                                                    Cliente cliente = new Cliente(nome, cpf, login, senha);
                                                    lance.setCliente(cliente);
                                                    System.out.println("Cliente Registrado");
                                                    clienteRepositorio.AdiconarCliente(cliente);
                                                    System.out.println("informe o valor do lance.");
                                                    x = scan.nextDouble();
                                                    lance.setValor(x);
                                                    lances.add(lance);
                                                    break;
                                                } else {
                                                    System.out.println("Informacao nao reconhecida");
                                                }
                                                break;
                                            case 2:
                                                break;
                                        }
                                    } while (op != 2);
                                    veiculo.setLances(lances);
                                case 3:
                                    break;
                            }
                        } while (op != 3);
                    }
                    if (leilao.getImovels() == null) {
                        System.out.println("Nao possui nenhum imovel relacionado ao leilao\n");

                        do {
                            System.out.println("deseja criar relacionar imoveis ao leilao insira: 1\n" +
                                    "ou caso queria criar um novo post de imovel para inserir insira: 2\n" +
                                    "caso queira sair e processeguir insira 3:");
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
                                    System.out.println("informe o tipo de imovel:<CASA/APARTAMENTO/EDIFICIO/TERRENO> ");
                                    str = scan.next();
                                    imovel.setTipo(Imovel.TipoImovel.valueOf(str));
                                    List<Lance> lances = new ArrayList<>();
                                    do {
                                        System.out.println("Deseja criar um lista de lances ja pre cadastrados insira 1" +
                                                "\n ou caso não queria insira 2");
                                        op = scan.nextInt();
                                        switch (op) {
                                            case 1:
                                                Lance lance = new Lance();
                                                lance.setProduto(imovel);
                                                System.out.println("Cliente que fara o lance ja possui cadastro : s or n ");
                                                str = scan.next();
                                                if (str.equals("s")) {
                                                    Cliente auxliar;
                                                    System.out.println("informe o  login e senha:");
                                                    login = scan.next();
                                                    senha = scan.next();
                                                    auxliar = clienteRepositorio.Consultar(login, senha);
                                                    lance.setCliente(auxliar);
                                                    System.out.println("informe o valor do lance");
                                                    x = scan.nextDouble();
                                                    lance.setValor(x);
                                                    lances.add(lance);
                                                    break;
                                                }
                                                if (str.equals("n")) {
                                                    System.out.println(" Cadastre um cleinte: ");
                                                    System.out.println("Informe  o nome, login, senha e cpf: ");
                                                    nome = scan.next();
                                                    login = scan.next();
                                                    senha = scan.next();
                                                    cpf = scan.next();
                                                    Cliente cliente = new Cliente(nome, cpf, login, senha);
                                                    lance.setCliente(cliente);
                                                    clienteRepositorio.AdiconarCliente(cliente);
                                                    System.out.println("informe o valor do lance ");
                                                    x = scan.nextDouble();
                                                    lance.setValor(x);
                                                    lances.add(lance);
                                                    break;
                                                } else {
                                                    System.out.println("Informacao nao reconhecida");
                                                }
                                                break;
                                            case 2:
                                                break;
                                        }
                                    } while (op != 2);
                                    imovel.setLances(lances);
                                case 3:
                                    break;
                            }
                        } while (op != 3);
                    }
                    if (leilao.getDataInicio() == null) {
                        System.out.println("insira a data e horario de inicio do leilao: dia , mes, ano , hora ,minuto ");
                        dia = scan.nextInt();
                        mes = scan.nextInt();
                        ano = scan.nextInt();
                        hora = scan.nextInt();
                        min = scan.nextInt();
                        leilao.setDataInicio(new Data(dia, mes, ano, hora, min));
                    }
                    if (leilao.getDataTermino() == null) {
                        System.out.println("insira a data e horario de termino do leilao: dia , mes, ano , hora ,minuto ");
                        dia = scan.nextInt();
                        mes = scan.nextInt();
                        ano = scan.nextInt();
                        hora = scan.nextInt();
                        min = scan.nextInt();
                        leilao.setDataTermino(new Data(dia, mes, ano, hora, min));
                    }
                    if (leilao.getEndereco() == null) {
                        System.out.println("Informe o endereco do leilao: \n informe a rua, cidade, estado e cep");
                        rua = scan.next();
                        cidade = scan.next();
                        estado = scan.next();
                        cep = scan.next();
                        leilao.setEndereco(new Endereco(rua, cidade, estado, cep));
                    }
                    System.out.println("informe a data atal para encerrar e finalizar o registro");
                    dia = scan.nextInt();
                    mes = scan.nextInt();
                    ano = scan.nextInt();
                    hora = scan.nextInt();
                    min = scan.nextInt();
                    leilao.setDataAtual(new Data(dia, mes, ano, hora, min));
                    leiloesRepositorio.AdicionarLeilao(leilao);
                    break;
                case 2:
                    System.out.println(" Cadastre um cleinte: ");
                    System.out.println("Informe  o nome, login, senha e cpf: ");
                    nome = scan.next();
                    login = scan.next();
                    senha = scan.next();
                    cpf = scan.next();
                    Cliente cliente = new Cliente(nome, cpf, login, senha);
                    clienteRepositorio.AdiconarCliente(cliente);
                    System.out.println("cliente Registrado!");
                    break;
                case 3:
                    System.out.println("Qual categoria de produto deseja cadastrar: veiculo ou imovel");
                    String cat = scan.next();
                    if (cat.equals("veiculo")) {
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
                        System.out.println("informe o tipo de veiculo: <CARRO/MOTOCICLETA> ");
                        str = scan.next();
                        veiculo.setTipo(Veiculo.TipoCarro.valueOf(str));
                        List<Lance> lances = new ArrayList<>();
                        do {
                            System.out.println("Deseja criar um lista de lances ja pre cadastrados insira 1" +
                                    "\n ou caso não queria insira 2");
                            op = scan.nextInt();
                            switch (op) {
                                case 1:
                                    Lance lance = new Lance();
                                    lance.setProduto(veiculo);
                                    System.out.println("Cliente que fara o lance ja possui cadastro : s or n ");
                                    str = scan.next();
                                    if (str.equals("s")) {
                                        System.out.println("informe o login e senha:");
                                        String email, pass;
                                        email = scan.next();
                                        pass = scan.next();
                                        lance.setCliente(clienteRepositorio.Consultar(email, pass));
                                        System.out.println("informe o valor");
                                        x = scan.nextDouble();
                                        lance.setValor(x);
                                        lances.add(lance);
                                        break;
                                    }
                                    if (str.equals("n")) {
                                        System.out.println("Cadastre um cleinte: ");
                                        System.out.println("Informe  o nome, login, senha e cpf: ");
                                        nome = scan.next();
                                        login = scan.next();
                                        senha = scan.next();
                                        cpf = scan.next();
                                        Cliente cliente1 = new Cliente(nome, cpf, login, senha);
                                        lance.setCliente(cliente1);
                                        System.out.println("Cliente Registrado!");
                                        clienteRepositorio.AdiconarCliente(cliente1);
                                        System.out.println("informe o valor do lance");
                                        x = scan.nextDouble();
                                        lance.setValor(x);
                                        lances.add(lance);
                                        break;
                                    } else {
                                        System.out.println("Informacao nao reconhecida");
                                    }
                                    break;
                                case 2:
                                    break;
                            }
                            break;
                        } while (op != 2);
                        veiculo.setLances(lances);
                    }
                    if (cat.equals("imovel")) {
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
                        System.out.println("informe o tipo de imovel <CASA/APARTAMENTO/TERRENO/EDIFICIO>: ");
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
                                    System.out.println("Cliente que realizara o lance ja possui cadastro : s or n ");
                                    str = scan.next();
                                    if (str.equals("s")) {
                                        System.out.println("informe o login e senha:");
                                        login = scan.next();
                                        senha = scan.next();
                                        lance.setCliente(clienteRepositorio.Consultar(login, senha));
                                        System.out.println("informe o valor do lance: ");
                                        x = scan.nextDouble();
                                        lance.setValor(x);
                                        lances.add(lance);
                                        break;
                                    }
                                    if (str.equals("n")) {
                                        System.out.println(" Cadastre um cleinte: ");
                                        System.out.println("Informe  o nome, login, senha e cpf: ");
                                        nome = scan.next();
                                        login = scan.next();
                                        senha = scan.next();
                                        cpf = scan.next();
                                        Cliente cliente1 = new Cliente(nome, cpf, login, senha);
                                        lance.setCliente(cliente1);
                                        clienteRepositorio.AdiconarCliente(cliente1);
                                        System.out.println("informe o valor do lance");
                                        x = scan.nextDouble();
                                        lance.setValor(x);
                                        lances.add(lance);
                                        break;
                                    } else {
                                        System.out.println("Informacao nao encontrada");
                                    }
                                    break;
                                case 2:
                                    break;
                            }
                        } while (op != 2);
                        imovel.setLances(lances);
                        break;
                    } else {
                        System.out.println("Erro.");
                    }
                    break;
                case 4:
                    Lance novo = new Lance();
                    Cliente temp = new Cliente();
                    System.out.println(" Ja possui cadastro ? <s / n> :");
                    str = scan.next();
                    if (str.equals("s")) {
                        System.out.println("informe o login e senha do usuario");
                        login = scan.next();
                        senha = scan.next();
                        temp.equals(clienteRepositorio.Consultar(login, senha));
                    }
                        if (str.equals("n")) {
                            System.out.println("vamos Cadastrar um cliente no sistema:" +
                                    "\n informe o nome, cpf , login e senha");
                            nome = scan.next();
                            cpf = scan.next();
                            login = scan.next();
                            senha = scan.next();
                            temp.setNome(nome);
                            temp.setCpf(cpf);
                            temp.setLogin(login);
                            temp.setSenha(senha);
                            clienteRepositorio.AdiconarCliente(temp);
                        }
                        novo.setCliente(temp);
                        System.out.println("Diga qual a categoria de produto que deseja: <veiculo/imovel>");
                        cat = scan.next();
                        if (cat.equals("veiculo")) {
                            Veiculo veiculo;
                            System.out.println("informe o documento do produto que deseja dar o lance encima:");
                            str = scan.next();
                            veiculo = veiculoRepositorio.buscarPorDocumentoVeiculo(str);
                            if (veiculo != null) {
                                System.out.println("informe o valor do lance: ");
                                x = scan.nextDouble();
                                novo.setValor(x);
                                veiculo.addlance(novo);
                                System.out.println("lance efetuado!");
                            } else System.out.println("nenhum produto encontrado!");
                        }
                        if (cat.equals("imovel")) {
                            Imovel imovel;
                            System.out.println("informe o documento do produto que deseja dar o lance encima:");
                            str = scan.next();
                            imovel = imovelRepositorio.ConsultarPorDoc(str);
                            if (imovel != null) {
                                System.out.println("informe o valor do lance: ");
                                x = scan.nextDouble();
                                novo.setValor(x);
                                imovel.addlance(novo);
                                System.out.println("lance efetuado !");
                            } else System.out.println("Nenhum Registro encontrado!");
                        }
                        break;
                case 5:
                    System.out.println("informe que tipo de leilao deseja vizualizar:<aberto/andamento/fechado> ");
                    str = scan.next();
                    List<Leilao>list;
                    list = leiloesRepositorio.repositorio();
                    if (str.equals("aberto")){
                        for (Leilao leilao1:list){
                            if (leilao1.getStatus().equals(Leilao.StatusLeilao.ABERTO)){
                                leilao1.toStringLeilao();
                            }
                        }
                    }
                    if (str.equals("andamento")){
                        for (Leilao leilao1:list){
                            if (leilao1.getStatus().equals(Leilao.StatusLeilao.ANDAMENTO)){
                                leilao1.toStringLeilao();
                            }
                        }
                    }
                    if (str.equals("fechado")){
                        for (Leilao leilao1:list){
                            if (leilao1.getStatus().equals(Leilao.StatusLeilao.FINALIZADO)){
                                leilao1.toStringLeilao();
                            }
                        }
                    }
                    else System.out.println("Erro");
                    break;
                case 6:
                    System.out.println("O que deseja alterar <cliente/leilao/imovel/veiculo/instituicao>");
                    str = scan.next();
                    if (str.equals("cliente")){
                        Cliente aux;
                        System.out.println("informe o login e senha do cliente :");
                        login = scan.next();
                        senha = scan.next();
                        aux = clienteRepositorio.Consultar(login,senha);
                        System.out.println("repasse as novas informacoes nome, cpf, login e senha");
                        nome = scan.next();
                        cpf = scan.next();
                        login = scan.next();
                        senha = scan.next();
                        aux.setNome(nome);aux.setLogin(login);aux.setSenha(senha);aux.setCpf(cpf);
                    }
                    if (str.equals("leilao")){
                        Leilao aux;
                        System.out.println("informe a data de inicio e horario do leilao");
                        dia = scan.nextInt();mes = scan.nextInt();ano = scan.nextInt();hora = scan.nextInt();min=scan.nextInt();
                        aux = leiloesRepositorio.ConsultarDataInicio(new Data(dia,mes,ano,hora,min));
                        System.out.println("as possiveis alteracoes estao em nas datas de inicio e termino e o endereco pois o resto sao vinculos:");
                        System.out.println("informe a nova data de inicio e o horario");
                        dia = scan.nextInt();mes = scan.nextInt();ano = scan.nextInt();hora = scan.nextInt();min=scan.nextInt();
                        aux.setDataInicio(new Data (dia,mes,ano,hora,min));
                        System.out.println("informe a nova data de Termino e o horario");
                        dia = scan.nextInt();mes = scan.nextInt();ano = scan.nextInt();hora = scan.nextInt();min=scan.nextInt();
                        aux.setDataTermino(new Data (dia,mes,ano,hora,min));
                        System.out.println("informe a o endereco novo:");
                        rua = scan.next(); cidade = scan.next();estado = scan.next();cep = scan.next();
                        aux.setEndereco(new Endereco(rua,cidade,estado,cep));
                    }
                    if (str.equals("imovel")){
                        Imovel aux;
                        System.out.println("informe o documento do produto");
                        str = scan.next();
                        aux = imovelRepositorio.ConsultarPorDoc(str);
                        System.out.println("informe a o endereco novo:");
                        rua = scan.next(); cidade = scan.next();estado = scan.next();cep = scan.next();
                        aux.setEndereco(new Endereco(rua,cidade,estado,cep));
                        System.out.println("informe o ano de construcao");
                        op = scan.nextInt();
                        aux.setAnoConstrucao(op);
                        System.out.println("informe o valor do imovel:");
                        x = scan.nextDouble();
                        aux.setPreco(x);
                        System.out.println("informe o tipo do imovel");
                        str = scan.next();
                        aux.setTipo(Imovel.TipoImovel.valueOf(str));
                        System.out.println("informe o documento novo: ");
                        str =scan.next();
                        aux.setDocumento(str);
                        System.out.println("informe a nova descricao: ");
                        str = scan.next();
                        aux.setDescricao(str);
                    }
                    if (str.equals("veiculo")){
                        Veiculo aux;
                        System.out.println("informe o documento do produto");
                        str = scan.next();
                        aux = veiculoRepositorio.buscarPorDocumentoVeiculo(str);
                        System.out.println("informe o ano de lancamento");
                        op = scan.nextInt();
                        aux.setAnoLancamento(op);
                        System.out.println("informe o valor do imovel:");
                        x = scan.nextDouble();
                        aux.setPreco(x);
                        System.out.println("informe o tipo do imovel");
                        str = scan.next();
                        aux.setTipo(Veiculo.TipoCarro.valueOf(str));
                        System.out.println("informe o documento novo: ");
                        str =scan.next();
                        aux.setDocumento(str);
                        System.out.println("informe a nova descricao: ");
                        str = scan.next();
                        aux.setDescricao(str);
                    }
                    if (str.equals("instituicao")){
                        Instituicao aux;
                        System.out.println("informe o cnpj da instituicao");
                        str = scan.next();
                        aux = instituicaoRepositorio.Consultainstituicao(str);
                        System.out.println("informe o novo cnpj e o nome da instituicao: ");
                        str = scan.next();
                        aux.setCnpj(str);
                        str = scan.next();
                        aux.setNome(str);
                    }
                    else System.out.println("erro na informacao inserida.");
                    break;
                case 7:
                    List<Leilao> aux;
                    aux = leiloesRepositorio.repositorio();
                    for (Leilao leilao1:aux){
                        for (Imovel imovel:leilao1.getImovels()){
                            for (Lance lance:imovel.getLances()){
                                lance.toStringLance();
                            }
                        }
                        for (Veiculo veiculo:leilao1.getVeiculos()){
                            for (Lance lance:veiculo.getLances()){
                                lance.toStringLance();
                            }
                        }
                    }
                    break;
                case 8:
                    System.out.println("informe qual tipo de produto deseja : <veiculo/imovel>");
                    str = scan.next();
                    if (str.equals("veiculo")){
                        System.out.println("informe o valor max e min para filtramos os produtos: ");
                        maximo =scan.nextDouble();
                        minimo = scan.nextDouble();
                        List<Veiculo> encontrados;
                        encontrados = veiculoRepositorio.FiltroPorPreco(minimo,maximo);
                        for (Veiculo veiculo:encontrados){
                            veiculo.toStringVeiculo();
                        }
                    }
                    if (str.equals("imovel")){
                        System.out.println("informe o valor max e min para filtramos os produtos: ");
                        maximo = scan.nextDouble();
                        minimo = scan.nextDouble();
                        List<Imovel> encontrados;
                        encontrados = imovelRepositorio.FiltroPreco(minimo,maximo);
                        for (Imovel imovel: encontrados){
                            imovel.toStringImovel();
                        }
                    }
                    else System.out.println("erro de insercao.");
                    break;
                case 9:
                    Instituicao instituicao = new Instituicao();
                    System.out.println("informe o nome da instituicao: ");
                    str= scan.next();
                    instituicao.setNome(str);
                    System.out.println("informe o cnpj da instituicao: ");
                    str = scan.next();
                    instituicao.setCnpj(str);
                    instituicaoRepositorio.AdicionarInstituicao(instituicao);
                    break;
                case 100:
                    System.out.println("bye");
                    break;
            }

        }while (op !=100 );

    }
}
