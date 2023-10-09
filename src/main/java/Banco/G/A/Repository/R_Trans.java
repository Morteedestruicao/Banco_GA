package Banco.G.A.Repository;

import Banco.G.A.Model.M_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Trans extends JpaRepository<M_Usuario, Long> {
    @Query(value = "UPDATE pessoa SET dinheiro 0 =''+ M_Pessoa.getdinheiro''", nativeQuery = true)
    M_Usuario deposito(@Param("dinheiro") Long dinheiro, @Param("valorTransacao") Long valorTransacao);
}
