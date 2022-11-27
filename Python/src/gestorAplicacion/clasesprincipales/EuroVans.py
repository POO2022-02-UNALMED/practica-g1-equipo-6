from Bus import Bus
from Viaje import Viaje

class EuroVans(Bus):

    def __init__(self,placa,conductor,sillas,precioKm=1000,codigo=250,capacidad=14):
        eurosV = []
        super().__init__(placa,conductor,sillas)
        EuroVans.eurosV.append(self)

    #get&set capacidad
    def getCapacidad(self):
        return self._capacidad

    #get&set precio   
    def getPrecioKm(self):
        return self._precioKm

    #get&set codigo
    def getCodigo(self):
        return self.codigo

    #Metodo_SillasDisponibles
    def sillasDisponibles(self):
        for tiquete in Viaje.getTiquetesTodos():
            if tiquete.getEstado() == False:
                print("la silla: "+tiquete.getSillaTiquete()+"esta disponible")
    def sillaTiquete(self, tiquete):
        return tiquete.getSillaTiquete()

