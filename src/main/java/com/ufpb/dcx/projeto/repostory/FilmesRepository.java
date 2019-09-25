package com.ufpb.dcx.projeto.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ufpb.dcx.projeto.model.Filme;

@Repository
public interface FilmesRepository extends JpaRepository<Filme,Integer>{

}
