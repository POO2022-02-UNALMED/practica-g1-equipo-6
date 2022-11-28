class Pasajero:
    _pasajeros = []
    def __init__(self, nombre, apellido, cedula, edad, correo):
        #instance fields found by Java to Python Converter:
        self._nombre = nombre
        self._apellido = apellido
        self._cedula = cedula
        self._edad = edad
        self._correo = correo
        Pasajero._pasajeros.append(self)
    # -----GETTERS AND SETTERS----- 
    def getNombre(self):
        return self._nombre
    def setNombre(self, nombre):
        self._nombre = nombre
    def getApellido(self):
        return self._apellido
    def setApellido(self, apellido):
        self._apellido = apellido
    def getCedula(self):
        return self._cedula
    def setCedula(self, cedula):
        self._cedula = cedula
    def getEdad(self):
        return self._edad
    def setEdad(self, edad):
        self._edad = edad
    def getCorreo(self):
        return self._correo
    def setCorreo(self, correo):
        self._correo = correo
    @classmethod
    def getPasajeros(cls):
        return Pasajero._pasajeros

    def __str__(self) -> str:
        return "Nombre del pasajero: {}\nNo Documento: {} ".format(
            self._nombre+self._apellido, self._cedula
        )
