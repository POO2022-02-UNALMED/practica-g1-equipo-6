class Ruta:
    _rutas = []
    _paradas=[]
    def __init__(self, origen, destino, km, paradas):
        #instance fields found by Java to Python Converter:
        self._idRuta = 0
        self._nombre = None
        self._origen=origen
        self._destino=destino
        self._km=km
        Ruta._paradas = paradas
        Ruta._rutas.append(self)
    @classmethod
    def quitarRuta(cls, ruta):
        if Ruta._rutas:
            for c in Ruta._rutas:
                if c._nombre == ruta:
                    Ruta._rutas.remove(c) #No corre en una clase afuera, analizar m�todo

    # hV es la ruta con su respectivo historico de viajes
    #Lo mejor ser�a implementar un toString para retornar toda la ruta y es mejor que sea un m�todo de clase?
   

    def setIdRuta(self, idRuta):
        self._idRuta = idRuta
    def getIdRuta(self):
        return self._idRuta

    def getNombre(self):
        return self._nombre
    def setNombre(self, nombre):
        self._nombre = nombre

    @classmethod
    def getRutas(cls):
        return Ruta._rutas
    @classmethod
    def setRutas(cls,rutas):
        Ruta._rutas = rutas


    def getOrigen(self):
        return self._origen
    def setOrigen(self, origen):
        self._origen = origen
    def getDestino(self):
        return self._destino
    def setDestino(self, destino):
        self._destino = destino
    def getKm(self):
        return self._km
    def setKm(self, km):
        self._km = km
    def toString(self):
        return "Ruta: "+self._nombre + " idRuta: "+ str(self._idRuta)
