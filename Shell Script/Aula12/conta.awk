BEGIN {
	FS = ","
	
	# Imprime o cabeçalho com alinhamento
	printf "%-12s %-22s %-8s %-8s\n", "Data", "Histórico", "Valor", "Saldo"
	print "----------------------------------------------------"
	
	receitas = 0
	despesas = 0
}
{
	transacao = $3 + 0
	saldo += transacao
	
	# Imprime a linha de movimentação formatada (ajuste as larguras conforme necessário)
	printf "%-12s %-22s %-8.0f %-8.0f\n", $1, $2, transacao, saldo
	
	if (transacao > 0) {
		receitas += transacao
	} else {
		despesas += transacao
	}
}
END {
	print ""
	print "Relatório"
	print "----------------------------------------------------"
	printf "Receitas: %.0f\n", receitas
	printf "Despesas: %.0f\n", despesas * -1
}
