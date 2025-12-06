package dev.java10x.cadastrodeninjas.Ninjas;

import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor // Cria o construtor vazio
@AllArgsConstructor // Cria o construtor com todos os atributos
@Data   // Cria os getters e setters
public class NinjaModel {

    // Id gerado pelo banco de dados automaticamente de forma sequencial numerica
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Idade")
    private int idade;

    @Column(unique = true, name = "E-mail")
    private String email;

    // Muitos ninjas tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Chave estrangeira
    private MissoesModel missao;

}
