class Bus:

    _buses = []
    _sillaNoDisponibles = []
    _sillas=[]
    
    def __init__(self, placa,conductor, sillas):
        self._km = 0
        self._preciokm =0
        self._codigo = 0
        self._conductor=conductor
        self._placa = placa
        Bus._sillas = sillas
        Bus._buses.append(self)
    #	public ArrayList<Empresa> getEmpresa() {
    #		return empresa
    #	}
    #	public void setEmpresa(ArrayList<Empresa> empresa) {
    #		this.empresa = empresa
    #	}

        Bus._buses.append(self)

    @classmethod
    def getSillas(self):
        return Bus._sillas

    @classmethod
    def setSillas(self, sillas):
        self._sillas = sillas
    @classmethod
    def getBuses(cls):
        return Bus._buses

    @classmethod
    def setBuses(cls,buses):
        Bus._buses = buses

    def getCodigo(self):
        return self.codigo

    def getPlaca(self):
        return self._placa

    def getConductor(self):
        return self._conductor

    def setCodigo(self, codigo):
        self.codigo = codigo

    @classmethod
    def getSillaNoDisponibles(cls):
        return Bus._sillaNoDisponibles

    @classmethod
    def setSillaNoDisponibles(cls,sillaNoDisponibles):
        Bus._sillaNoDisponibles.append(sillaNoDisponibles)

    def getKm(self):
        return self.km

    def setKm(self, km):
        self.km = km

    def getPrecio(self):
        return self._precioKm

    def setPrecio(self, precio):
        self._preciokm = precio

    @classmethod
    def getBuses(self):
        return self._buses