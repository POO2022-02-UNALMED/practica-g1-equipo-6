from gestor_aplicacion.clasesPrincipales.Bus import Bus
from gestor_aplicacion.clasesPrincipales.Viaje import Viaje


class Ejecutivo(Bus):
    _ejecutivos = []

    def __init__(self, placa, conductor, sillas):
        # instance fields found by Java to Python Converter:
        self._precioKm = 500
        self._capacidad = 24
        self.name = "Ejecutivo"
        self.placa = placa
        self.conductor = conductor
        super().__init__(placa, conductor, sillas)
        self.codigo = 150
        Ejecutivo._ejecutivos.append(self)


    def getPlaca(self):
        return self.placa

    def getConductor(self):
        return self.conductor

    # get&set capacidad

    def getCapacidad(self):
        return self._capacidad

    # get_precio
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
