from datetime import datetime
from gestor_aplicacion.clasesPrincipales.Tiquete import Tiquete
from gestor_aplicacion.clasesPrincipales.Bus import Bus
from gestor_aplicacion.clasesPrincipales.Ruta import Ruta

class Viaje:

    __fechasViaje = []
    __viajes = []
    __lugares = []
    __tiquetesTodos = []

    def __init__(
        self,
        _id: int,
        _costoViaje : int, 
        _horaInicio: str,
        _horaLlegada: str,
        _ruta: Ruta,
        _fecha: datetime,
        _bus: Bus,
        _enViaje: bool,
        _frecuencia: int,

    ):
        from gestor_aplicacion.clasesPrincipales.Ruta import Ruta
        from gestor_aplicacion.clasesPrincipales.Bus import Bus
        self._id = _id
        self._costoViaje = _costoViaje
        self._horaInicio = _horaInicio
        self._horaLlegada = _horaLlegada
        self._ruta = _ruta
        self._origen = _ruta.getOrigen()
        self._precio = (_ruta.getKm()* _bus.getPrecio())
        self._bus = _bus
        self._enViaje = _enViaje
        self._frecuencia = _frecuencia
        self._destino = _ruta.getDestino()
        self._fecha = _fecha

        Viaje.__fechasViaje.append(_fecha)

        for i in range(int(_bus.getCapacidad())//len(_bus.getSillas())):
            for sillaEnVehiculo in _bus.getSillas():
                Viaje.__tiquetesTodos.append(
                Tiquete(self._id, None, sillaEnVehiculo, self, self._precio)
            )

        Viaje.__viajes.append(self)

    # Getters
    def getId(self):
        return self._id

    def getCostoViaje(self):
        return self._costoViaje

    def getHoraInicio(self):
        return self._horaInicio

    def getHoraLlegada(self):
        return self._horaLlegada

    def getOrigen(self):
        return self._origen

    def getDestino(self):
        return self._destino

    def getRuta(self):
        return self._ruta

    def getFecha(self):
        return self._fecha

    def getPrecio(self):
        return self._precio

    def getBus(self):
        return self._bus

    def getEnViaje(self):
        return self._enViaje

    def getFrecuencia(self):
        return self._frecuencia
    @classmethod
    def getTiquetesTodos(self):
        return self.__tiquetesTodos
    @classmethod
    def getViajes (self):
        return self.__viajes
    @classmethod
    def setViajes(cls,viajes):
        Viaje.__viajes = viajes    

    @classmethod
    def getLugares(self):
        for viaje in self.__viajes:
            if viaje.getOrigen() not in self.__lugares:
                self.__lugares.append(viaje.getOrigen())

        for viaje in self.__viajes:
            if viaje.getDestino() not in self.__lugares:
                self.__lugares.append(viaje.getDestino)
        return self.__lugares 

    # Setters
    def setId(self, id):
        self._id = id

    def setCostoViaje(self, costoViaje):
        self._costoViaje = costoViaje

    def setHoraInicio(self, horaInicio):
        self._horaInicio = horaInicio

    def setHoraLlegada(self, horaLlegada):
        self._horaLlegada = horaLlegada

    def setOrigen(self, origen):
        self._origen = origen

    def setDestino(self, destino):
        self._destino = destino

    def setRuta(self, ruta):
        self._ruta = ruta

    def setFecha(self, fecha):
        self._fecha = fecha

    def setPrecio(self, precio):
        self._precio = precio

    def setBus(self, bus):
        self._bus = bus

    def setEnViaje(self, viaje):
        self._enViaje = viaje

    def setFrecuencia(self, frecuencia):
        self._frecuencia = frecuencia

    # Metodos de frecuencia
    def aumentarFrecuencia(self, frec):
        self.setFrecuencia(self._frecuencia + frec)

    def disminuirFrecuencia(self, frec):
        self.setFrecuencia(self._frecuencia - frec)

    # Generar tiquete
    @classmethod
    def generarTiquete(cls, cod, pasajero, sillaTiquete, viaje, valor, fechaCompra):
        return Tiquete(cod, pasajero, sillaTiquete, viaje, valor, fechaCompra)

    # Tiquete disponible
    def tiquetesDisponibles(self):
        tiqueteFinal = []
        for tiquete in self.__tiquetesTodos:
            if tiquete._estado==False:
                tiqueteFinal.append(tiquete)
        return tiqueteFinal

    # Eliminar viaje
    def eliminarViaje(self):
        Viaje.__viajes.remove(self)

    # Eliminar tiquete
    def eliminarTiquete(self, tiquete):
        tiquete = None

    # ToString
    def __str__(self) -> str:
        return "Origen: {}\nDestino: {}\nFechaViaje: {}\nPrecio: {}".format(
            self._origen, self._destino, self._fecha, self._precio
        )

    def listadoViajes(self):
        n = self.__viajes
        for i in range(n):
            print(f"[{i}] {self.__viajes[i]}" )
