from Bus import Bus
from Viaje import Viaje

class Ejecutivo(Bus):

    def __init__(self,placa,conductor,sillas,precioKm=500,codigo=150,capacidad=26):
        ejecutivos = []
        super().__init__(placa,conductor,sillas)
        Ejecutivo.ejecutivos.append(self)

    #get&set capacidad
    def getCapacidad(self):
        return self._capacidad
    def setCapacidad(self, capacidad):
        self._capacidad = capacidad

    #get_precio
    def getPrecioKm(self):
        return self._precioKm
    def setPrecio(self, precioKm):
        self._precioKm = precioKm

    #get&set codigo
    def getCodigo(self):
        return self.codigo
    def setCodigo(self, codigo):
        self.codigo = codigo

    #Metodo_sillasdisponibles
    def sillasDisponibles(self):
        for tiquete in Viaje.getTiquetesTodos():
            if tiquete.getEstado() == False:
                print("la silla: "+tiquete.getSillaTiquete()+"esta disponible")
    def sillaTiquete(self, tiquete):
        return tiquete.getSillaTiquete()
