package br.com.uneb.tebdfaculdademobile.model;

import java.io.Serializable;

public class DisciplinaValue implements Serializable {

    private long id;
    private String disciplina;

    public DisciplinaValue() {}

    public DisciplinaValue(long id, String disciplina) {
        this.id = id;
        this.disciplina = disciplina;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
//        return "DisciplinaValue{" +
//                "id=" + id +
//                ", disciplina='" + disciplina + '\'' +
//                '}';

        return id + " - " + disciplina;
    }
}
