package com.luigui.app.escuela.repositorios;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luigui.app.escuela.entidades.Usuario;

@Repository
public interface IUsuarioRepositorio extends CrudRepository<Usuario, Long>{

}
