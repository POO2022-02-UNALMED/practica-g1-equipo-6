from tkinter import messagebox

class ExceptionPopUp():
    def __init__(self, mensaje):
        self._mensaje = mensaje
        messagebox.showinfo(title = "Error en la aplicación", message = mensaje)


class EmptyInputException(Exception):
    def __init__(self, message="Error: Debes de llenar todos los datos del formulario"):
        self.message = message
        super().__init__(self.message)


class NumericException(Exception):
    def __init__(self, message="Error: Debes de insertar datos numericos"):
        self.message = message
        super().__init__(self.message)

class MatchingData(Exception):
    def __init__(self, message = "Error: Debes insertar datos distintos"):
        self.message = message
        super().__init__(self.message)

class NotExistException(Exception):
    def __init__(self, message = "Error: No hay viajes disponibles "):
        self.message = message
        super().__init__(self.message)

class CharNotAvailableException(Exception):
    def __init__(self, message = "Error: Silla no disponible "):
        self.message = message
        super().__init__(self.message)

class DocumentNotExistException(Exception):
    def __init__(self, message = "Error: El documento ingresado no tiene tiquetes comprados "):
        self.message = message
        super().__init__(self.message)

class NotExistChairException (Exception):
    def __init__(self, message = "Error: La silla que desea no existe"):
        self.message = message
        super().__init__(self.message)
