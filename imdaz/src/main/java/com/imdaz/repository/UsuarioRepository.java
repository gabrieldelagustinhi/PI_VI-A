package com.imdaz.repository;

import com.imdaz.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE EXTRACT(DAY FROM u.dataNascimento) = :dia AND EXTRACT(MONTH FROM u.dataNascimento) = :mes")
    List<Usuario> findByDiaAndMesAniversario(int dia, int mes);

}
