# 1. Limpar e recriar ambiente
rm -rf ~/Demonstracao
mkdir -p ~/Demonstracao
cd ~/Demonstracao

# 2. Criar arquivo de regras
cat << 'EOF' > rules.conf
pdf ~/Demonstracao/Biblioteca/PDFs
jpg ~/Demonstracao/Multimidia/Fotos_JPG
png ~/Demonstracao/Multimidia/Outras_Imagens
image ~/Demonstracao/Multimidia/Outras_Imagens
text ^PROJETO ~/Demonstracao/Trabalho/Projetos
text ~/Demonstracao/Documentos/Geral
video ~/Demonstracao/Multimidia/Videos
EOF

# 3. Criar Arquivos com "Magic Bytes" (Conteúdo Real)
# O printf escreve bytes hexadecimais que identificam o tipo do arquivo para o comando 'file'

# PDF (%PDF)
printf "%%PDF-1.4\nConteudo fake" | tee manual_usuario.pdf boleto.pdf > /dev/null

# JPG (\xff\xd8\xff)
printf "\xff\xd8\xff\xe0\x00\x10JFIF" | tee foto_praia.jpg foto_aniversario.jpg > /dev/null

# PNG (\x89PNG) - Agora será detectado como image/png
printf "\x89PNG\x0d\x0a\x1a\x0a" > print_erro.png

# BMP (BM)
printf "BM\x00\x00\x00\x00" > icone.bmp

# MP4 (ftyp) - Agora será detectado como video/mp4
printf "\x00\x00\x00\x18ftypmp42" > tutorial.mp4

# Texto (Conteúdo legível)
echo "Relatorio do projeto" > PROJETO_Estrutura.txt
echo "Requisitos do sistema" > PROJETO_Requisitos.md
echo "Leite e Pao" > lista_compras.txt
echo "Lembretes" > notas_rapidas.txt

# 4. Copia o script para o ambiente teste
cp /home/wescleyj/Documentos/terceiro_semestre/topicos_especiais_em_fundamentos_da_computacao_shell_scripting/atividades_provas/Organizacao-arquivos-automatizados/organizer.sh ~/Demonstracao

chmod +x organizer.sh

# 5. Listar estado inicial
echo "--- Ambiente Pronto ---"
ls -F
