from ContaBancaria import ContaBancaria

class ContaCorrente(ContaBancaria):
    def __init__(self):
        super().__init__()
        self._limite_cheque_especial = 0.0

    # Setters
    def set_limite_cheque_especial(self, limite_cheque_especial):
        self._limite_cheque_especial = limite_cheque_especial

    # Getters
    def get_limite_cheque_especial(self):
        return self._limite_cheque_especial
    
    # Métodos

    def verificar_saldo(self):
        print(f'Saldo: R$ {self._saldo:.2f}')
        print(f'Limite do cheque especial: R$ {self._limite_cheque_especial:.2f}')
        return
    
    def sacar(self, valor):
        if self._saldo + self._limite_cheque_especial >= valor:
            self._saldo -= valor
            return True
        return False