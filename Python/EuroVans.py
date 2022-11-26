from Bus import Bus
from Viaje import Viaje

class EuroVans(Bus):

    def _initialize_instance_fields(self,placa,conductor,sillas,precioKm=1000,codigo=250,capacidad=14):
        eurosV = []
        super().__init__(placa,conductor,sillas)
        EuroVans.eurosV.append(self)

    #get&set capacidad
    def getCapacidad(self):
        return self._capacidad
    def setCapacidad(self, capacidad):
        self.capacidad = capacidad

    #get&set precio   
    def getPrecioKm(self):
        return self._precioKm
    def setPrecioKm(self, PrecioKm):
        self.PrecioKm = PrecioKm

    #get&set codigo
    def getCodigo(self):
        return self.codigo
    def setCodigo(self, codigo):
        self.codigo = codigo

    #Metodo_SillasDisponibles
    def sillasDisponibles(self):
        for tiquete in Viaje.getTiquetesTodos():
            if tiquete.getEstado() == False:
                print("la silla: "+tiquete.getSillaTiquete()+"esta disponible")
    def sillaTiquete(self, tiquete):
        return tiquete.getSillaTiquete()

