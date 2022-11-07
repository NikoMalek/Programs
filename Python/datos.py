class todo():
    def __init__(self,n,a,c,num):
        self.nombre = n
        self.apellido = a
        self.codigo = c
        self.numero = num
    def persona(self):
        print (self.nombre,self.apellido)

    def telefono(self):
        print (self.codigo,self.numero)

juan = todo("Juan","Perez","+569","55555555")
juan.persona()
juan.telefono()