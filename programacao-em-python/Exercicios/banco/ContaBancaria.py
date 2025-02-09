class ContaBancaria:
    def __init__(self):
        self._numero_conta = 0
        self._titular = ''
        self._saldo = 0.0
        self._ativo = False
    
    # Setters
    def set_numero_conta(self, numero_conta):
        self._numero_conta = numero_conta
    
    def set_titular(self, titular):
        self._titular = titular
    
    def set_saldo(self, saldo):
        self._saldo = saldo

    # Getters

    def get_numero_conta(self):
        return self._numero_conta
    
    def get_titular(self):
        return self._titular
    
    def get_ativo(self):
        return self._ativo


    # Métodos

    def ativar_conta(self):
        self._ativo = True
    
    def depositar(self, valor):
        self._saldo += valor

    def sacar(self, valor):
        if self._saldo >= valor:
            self._saldo -= valor
            return True
        return False
    
    def verificar_saldo(self):
        print(f'Saldo: R$ {self._saldo:.2f}')
        return