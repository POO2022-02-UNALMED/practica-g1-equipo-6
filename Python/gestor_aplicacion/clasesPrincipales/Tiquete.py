from datetime import datetime

class Tiquete:

    _tiquetes=[]
    _tiquetesComprados=[]

    def __init__(self, idTiquete : int=0, comprador = None, sillaTiquete =None, viaje = None, valor : int =0, valorServicio: int =0, fechaCompra : datetime = datetime.now()):
        self._idTiquete = idTiquete
        self._comprador = comprador
        self._sillaTiquete = sillaTiquete
        self._viaje = viaje
        self._valor = valor
        self._estado = False
        self._valorServicio = valorServicio
        self._fechaCompra = fechaCompra
        Tiquete._tiquetes.append(self)


    @classmethod
    def asignarTiquete(cls, pasajero, tiquete):
        tiquete.setComprador(pasajero) #cambie comprador por pasajero
        tiquete.setFechaCompra(datetime.now())
        tiquete.setEstado(True)
        #tiquete.getViaje().getDestino()
        Tiquete._tiquetesComprados.append(tiquete) #Añadi este

        return tiquete
    
    def getId(self):
        return self._idTiquete

    def getValorServicio(self):
        return self._valorServicio
    
    def getSillaTiquete(self):
        return self._sillaTiquete

    def getViaje(self):
        return self._viaje

    def getPasajero(self):
        return self._pasajero

    def getEstado(self):
        return self._estado
    def setEstado(self, estado):
        self._estado = estado

    def setComprador(self, comprador):
        self._pasajero = comprador

    def setValor(self, valor):
        self._valor=valor

    def getValor(self):
        return self._valor

    def setFechaCompra(self, fechaCompra):
        self._fechaCompra = fechaCompra

    @classmethod
    def getTiquetes(cls):
        return cls._tiquetes



    def getCodigo(self):
        return self._codigo

    def setCodigo(self, codigo):
        self._codigo = codigo

    def setPasajero(self, pasajero):
        self._pasajero = pasajero

    def setValorServicio(self, valorServicio):
        self._valorServicio =  valorServicio

    @classmethod
    def getTiquetesComprados(cls):
        return Tiquete._tiquetesComprados

    @classmethod
    def setTiquetesComprados(cls,tiquetesComprados):
        Tiquete._tiquetesComprados = tiquetesComprados


    def setSillaTiquete(self, sillaTiquete):
        self._sillaTiquete = sillaTiquete

    def __str__(self) -> str:
        
       return "Tiquete No: {}\n{}\nFecha Compra: {}\nSilla: {}\nServicio: {}\n{}".format(
            self._idTiquete, self._pasajero, self._fechaCompra, self._sillaTiquete, self._valorServicio, self._viaje)
        

