package br.simba.bem_estar.progresso;

import java.util.List;

public class ProgressoDTO {

    private List<SonoProgressoDTO> sono;
    private List<AguaProgressoDTO> hidratacao;
    private List<TreinoProgressoDTO> treinos;

    public ProgressoDTO(
            List<SonoProgressoDTO> sono,
            List<AguaProgressoDTO> hidratacao,
            List<TreinoProgressoDTO> treinos) {

        this.sono = sono;
        this.hidratacao = hidratacao;
        this.treinos = treinos;
    }

    public List<SonoProgressoDTO> getSono() {
        return sono;
    }

    public List<AguaProgressoDTO> getHidratacao() {
        return hidratacao;
    }

    public List<TreinoProgressoDTO> getTreinos() {
        return treinos;
    }
}