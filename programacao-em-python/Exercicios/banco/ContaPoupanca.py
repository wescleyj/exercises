from ContaBancaria import ContaBancaria

class ContaPoupanca(ContaBancaria):
    def __init__(self, numero, saldo, cliente):
        super().__init__(numero, saldo, cliente)
        self._taxa_juros = 0.005

        def get_taxa_juros(self):
            return self._taxa_juros
        
        def set_taxa_juros(self, taxa_juros):
            self._taxa_juros = taxa_juros

        def aplicar_juros(self):
            self._saldo += self._saldo * self._taxa_juros