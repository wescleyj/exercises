#!/bin/bash

# Variaveis que serao utilizadas no programa
RULES="rules.conf"                              # Arquivo de regras
LOG="organizer.log"                             # Arquivo de log
SIMULACAO=true

# Array associativo para rastrear arquivos já movidos (Evita duplicidade)
declare -A processados

# Verifica argumentos passados (Simulacao vs Execucao)
case "$1" in
	"-y")
		SIMULACAO=false
		;;
	"")
		echo "Modo de Simulacao Ativo. Use -y para executar."
		;;
	*)
		echo "Argumento invalido. Tente ./organize [-y]"
		exit 1
		;;
esac

# Verifica a existencia do arquivo rules.conf
if [[ ! -e "$RULES" ]]; then
	echo "O arquivo de regras ($RULES) não foi encontrado"
	exit 1
fi

# Lê o arquivo linha a linha ate o EOF
while read -r linha; do
	# Ignora linhas vazias ou comentarios
	[[ -z "$linha" || "$linha" == \#* ]] && continue

	# Transforma a linha em um array para contar colunas
	colunas=($linha)
	qtd=${#colunas[@]}

	# Define as variaveis com base na quantidade de colunas
	if [ "$qtd" -eq 2 ]; then
		TIPO="${colunas[0]}"
		REGEX_NOME=""
		DESTINO="${colunas[1]}"
	elif [ "$qtd" -eq 3 ]; then
		TIPO="${colunas[0]}"
		REGEX_NOME="${colunas[1]}"
		DESTINO="${colunas[2]}"
	else
		continue
	fi

	# Expansão para corrigir o "~" no destino
	DESTINO="${DESTINO/#\~/$HOME}"

	# Define o nome do script limpo (sem ./)
	MEU_NOME=$(basename "$0")

	# Itera sobre os arquivos da pasta atual
	for arquivo in *; do
		# 1. Filtro de Segurança: Ignora script, config, log e o
		# próprio diretório destino
		if [ ! -f "$arquivo" ] || [ "$arquivo" == "$RULES" ] \
			|| [ "$arquivo" == "$MEU_NOME" ] || [ "$arquivo" == "$LOG" ];
			then
			continue
		fi

		# 2. Filtro de Duplicidade: Se já foi processado nesta execução, pula
		if [[ -n "${processados[$arquivo]}" ]]; then
			continue
		fi

		# Obtém o tipo Mime
		MIMETYPE=$(file --mime-type -b "$arquivo")

		# Logica de Filtro (Mime/Extensao E Nome opcional)
		if [[ "$MIMETYPE" =~ "$TIPO" ]] || [[ "$arquivo" =~ \."$TIPO"$ ]]; then

			if [ -n "$REGEX_NOME" ]; then
				if [[ ! "$arquivo" =~ $REGEX_NOME ]]; then
					continue
				fi
			fi

			echo "Processando: $arquivo ($MIMETYPE) -> $DESTINO"

			# Marca o arquivo como processado para não cair em outras regras
			processados["$arquivo"]=1

			if "$SIMULACAO"; then
				continue
			else
				# Cria diretorio e move arquivos
				if [ ! -d "$DESTINO" ]; then
					mkdir -p "$DESTINO"
				fi

				if mv "$arquivo" "$DESTINO"; then
						echo "$(date "+%d/%m/%Y %H:%M:%S") - " \
						"Movido: $arquivo" \
						" -> $DESTINO" >> "$LOG"
				else
					echo "Erro ao mover: $arquivo" >&2
				fi
			fi
		fi
	done
done < "$RULES"

# Exibe resumo final lendo do log
if [ "$SIMULACAO" = false ] && [ -f "$LOG" ]; then
	echo "---"
	echo "Total de arquivos movidos hoje:"
	grep "$(date "+%d/%m/%Y")" "$LOG" | wc -l
fi
