BEGIN {
	FS = ":"
	total_geral = 0
	NR_total = 0
}
NR == 1 {
	printf "%-25s %-16s %8s %8s %8s %8s\n", "Nome", "Telefone", "Jan", "Fev", "Mar", "Total"
	print "-------------------------------------------------------------------------"
}
{
	total_candidato = $3 + $4 + $5
	printf "%-25s %-16s %8.2f %8.2f %8.2f %8.2f\n", $1, $2, $3, $4, $5, total_candidato
	total_geral += total_candidato
	contribuicoes[NR] = $3
	contribuicoes[NR + 0.1] = $4
	contribuicoes[NR + 0.2] = $5
	NR_total += 3
}
END {
	print ""
	print "Relatório"
	print "-------------------------------------------------------------------------"
	printf "Total recebido: %.2f\n", total_geral
	menor = contribuicoes[1]
	maior = contribuicoes[1]
	soma_contribuicoes = 0
	for (i in contribuicoes) {
		valor = contribuicoes[i]
		if (valor < menor) {
			menor = valor
		}
		if (valor > maior) {
			maior = valor
		}
		soma_contribuicoes += valor
	}
	media = soma_contribuicoes / NR_total
	printf "Contribuição (menor, média, maior): %.2f, %.2f, %.2f\n", menor, media, maior
}
