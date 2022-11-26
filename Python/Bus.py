class Bus:

    #Constructor
    def __init__(self,placa,conductor,sillas,km=0,precioKm=0,capacidad=0,codigo=0):
        self.km = 0
        self.precioKm = 0
        self.capacidad = 0
        self._codigo = 0
        self.placa = placa
        self.conductor = conductor
        self._sillas = sillas
        _buses = [] #Agregue este atributo valen
        _sillaNoDisponibles = []


    #get&set buses
    @staticmethod
    def getBuses():
        return Bus._buses
    @staticmethod
    def setBuses(buses):
        Bus._buses = buses

    #get&set placa
    def getPlaca(self):
        return self.placa
    def setPlaca(self, placa):
        self.placa=placa

    #get&set conductor
    def getConductor(self):
        return self.conductor
    def setConductor(self, conductor):
        self.conductor=conductor

    #get&set sillas
    def getSillas(self):
        return self._sillas
    def setSillas(self, sillas):
        self._sillas = sillas

    #get&set capacidad
    def getCapacidad(self):
        return self.capacidad
    def setCapacidad(self, capacidad):
        self.capacidad=capacidad

    #get&set sillanodisponible
    @staticmethod
    def getSillaNoDisponibles():
        return Bus._sillaNoDisponibles
    @staticmethod
    def setSillaNoDisponibles(sillaNoDisponibles):
        Bus._sillaNoDisponibles.append(sillaNoDisponibles)

    #get&set km
    def getKm(self):
        return self.km
    def setKm(self, km):
        self.km = km

    #get&set precio
    def getPrecioKm(self):
        return self.precioKm
    def setPrecioKm(self, precioKm):
        self.precioKm = precioKm

    #get&set precio
    def getCodigo(self):
        return self._codigo
    def setCodigo(self, codigo):
        self._codigo = codigo

