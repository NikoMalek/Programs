class datos():
  def __init__(self):
    self.nombre = input("Nomber: ")
    self.telefono = input("Celular sin +56: ")
  def confirmaciontele(self):
    if len(self.telefono)==9:
      return True
    else:
      return False
  def print_nt(self):
      if self.confirmaciontele() == True:
        print(self.nombre,"+56",self.telefono)
      else:
        print("telefono incorrecto ingrese denuevo....")
        self.__init__()
        self.confirmaciontele()
        self.print_nt()

inicio = datos()
inicio.confirmaciontele()
inicio.print_nt()
