package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor // Cria o construtor vazio
@AllArgsConstructor // Cria o construtor com todos os atributos
@Data   // Cria os getters e setters
public class MissoesModel {

    // Id gerado pelo banco de dados automaticamente de forma sequencial numerica
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Dificuldade")
    private String dificuldade;

    // Uma missão tem tem varios Ninjas
    @OneToMany(mappedBy = "missao")
    @JoinColumn(name = "ninjas_id") // Chave estrangeira
    private List<NinjaModel> ninjas;

}
