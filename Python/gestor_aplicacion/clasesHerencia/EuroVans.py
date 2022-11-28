from gestor_aplicacion.clasesPrincipales.Viaje import Viaje
from gestor_aplicacion.clasesPrincipales.Bus import Bus


class EuroVans(Bus):
    _euroV = []

    def __init__(self, placa, conductor, sillas):
        # instance fields found by Java to Python Converter:
        self._precioKm = 1000
        self._capacidad = 16
        super().__init__(placa, conductor, sillas)
        self.codigo = 250
        EuroVans._euroV.append(self)

    # get&set capacidad
    def getCapacidad(self):
        return self._capacidad

    def getPrecioKm(self):
        return self._precioKm
    # get&set codigo

    def getCodigo(self):
        return self.codigo

    def setCodigo(self, codigo):
        self.codigo = codigo

    def sillasDisponibles(self):
        for tiquete in Viaje.getTiquetesTodos():
            if tiquete.getEstado() == False:
                print("la silla: "+tiquete.getSillaTiquete()+"esta disponible")

    def sillaTiquete(self, tiquete):
        return tiquete.getSillaTiquete()
