class Conductor:
    _conductores = []

    def __init__(self, nombre, cedula, celular, sueldo):
        #instance fields found by Java to Python Converter:
        self._nombre = nombre
        self._cedula = cedula
        self._celular = celular
        self._sueldo = sueldo
        Conductor._conductores.append(self)

    #GETs y SETs
    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    def getCedula(self):
        return self._cedula

    def setCedula(self, cedula):
        self._cedula = cedula


    def getCelular(self):
        return self._celular

    def setCelular(self, celular):
        self._celular = celular

    def getSueldo(self):
        return self._sueldo

    def setSueldo(self, sueldo):
        self._sueldo = sueldo

    @classmethod
    def getConductores(cls):
        return Conductor._conductores

    @classmethod
    def setConductores(cls, conductores):
        Conductor._conductores = conductores
