package Model;

public class Data {
    private int dia;
    private int mes;
    private int ano;
    private int hora;
    private int minuto;
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public Data(int dia, int mes, int ano, int hora, int minuto) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.minuto = minuto;
    }

    public String imprimirData() {
        return "data: "+dia+"/"+mes+"/"+ano+"\nhorario: "+hora+":"+minuto;
    }

    public Data Comparar (Data data, Data data2){
        if (data.getAno() > data2.getAno() || data.getAno() == data2.getAno() && data.getMes() > data2.getMes()
        || data.getAno() == data2.getAno() && data.getMes() == data2.getMes() && data.getDia() > data2.getDia()){
            return data;
        }else {
            if (data.getDia() == data2.getDia() && data.getHora() > data2.getHora()||data.getDia() == data2.getDia() &&
                    data.getHora() == data2.getHora() && data.getMinuto() > data2.getMinuto()){
                return data;
            }
            else {
                return data2;
            }
        }
    }
}
