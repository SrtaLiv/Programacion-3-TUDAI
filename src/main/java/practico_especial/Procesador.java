package practico_especial;

public class Procesador {
    int idProcesador;
    int codigoProcesador;
    Boolean estaRefrigerado;
    int anioFuncionamiento;
    List<Tarea> tareaList;

    public Procesador(int idProcesador, int codigoProcesador, Boolean estaRefrigerado, int anioFuncionamiento) {
        this.idProcesador = idProcesador;
        this.codigoProcesador = codigoProcesador;
        this.estaRefrigerado = estaRefrigerado;
        this.anioFuncionamiento = anioFuncionamiento;
    }

    public List<Tarea> getTareaList() {
        return tareaList;
    }

    public void setTareaList(List<Tarea> tareaList) {
        this.tareaList = tareaList;
    }

    public int getIdProcesador() {
        return idProcesador;
    }

    public void setIdProcesador(int idProcesador) {
        this.idProcesador = idProcesador;
    }

    public int getCodigoProcesador() {
        return codigoProcesador;
    }

    public void setCodigoProcesador(int codigoProcesador) {
        this.codigoProcesador = codigoProcesador;
    }

    public Boolean getEstaRefrigerado() {
        return estaRefrigerado;
    }

    public void setEstaRefrigerado(Boolean estaRefrigerado) {
        this.estaRefrigerado = estaRefrigerado;
    }

    public int getAnioFuncionamiento() {
        return anioFuncionamiento;
    }

    public void setAnioFuncionamiento(int anioFuncionamiento) {
        this.anioFuncionamiento = anioFuncionamiento;
    }
}
