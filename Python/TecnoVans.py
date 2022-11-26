from Bus import Bus
from Viaje import Viaje

class TecnoVans(Bus):

    def __init__(self,placa,conductor,sillas,precioKm=800,codigo=200,capacidad=22):
        tecnosV = []
        super().__init__(placa,conductor,sillas)
        TecnoVans.tecnosV.append(self)

    #get&set capacidad
    def getCapacidad(self):
        return self._capacidad

    #get&set PrecioKm
    def getPrecioKm(self):
        return self._precioKm

    #get&set codigo
    def getCodigo(self):
        return self.codigo

    #MetodoSillasDispo
    def sillasDisponibles(self):
        for tiquete in Viaje.getTiquetesTodos():
            if tiquete.getEstado() == False:
                print("la silla: "+tiquete.getSillaTiquete()+"esta disponible")
            
    def sillaTiquete(self, tiquete):
        return tiquete.getSillaTiquete()