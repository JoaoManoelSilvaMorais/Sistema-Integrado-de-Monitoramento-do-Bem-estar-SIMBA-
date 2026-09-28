package br.simba.bem_estar.conquista;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConquistaService {

    private final ConquistaRepository repository;

    public ConquistaService(ConquistaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Conquista> listar() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Conquista buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Conquista não encontrada."));
    }
}
