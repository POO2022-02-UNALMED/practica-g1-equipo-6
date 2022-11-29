from gestor_aplicacion.manejoErrores.excepcionesApp import EmptyInputException, ExceptionPopUp, NumericException, MatchingData
from gestor_aplicacion.manejoErrores.excepcionesApp import NotExistException, CharNotAvailableException, DocumentNotExistException
from gestor_aplicacion.manejoErrores.excepcionesApp import NotExistChairException

class Validador():
    def __init__(self):
        self._esValido = False

    def validarCampoVacio(self, *args):
        try:
            for arg in args:
                if arg == "":
                    self._esValido = False
                    raise EmptyInputException
            self._esValido = True
        except EmptyInputException as e:
            ExceptionPopUp(e)

    def validarCampoNumerico(self, value):
        try:
            if value == "":
                return
            if not(value.isdigit()):
                self._esValido = False
                raise NumericException
            self._esValido = True
        except NumericException as e:
            ExceptionPopUp(e.message)

    def validarOrigenDestino(self, value1, value2):
        try: 
            if value1 == "" or value2 == "":
                return
            if value1 == value2:
                self._esValido = False
                raise MatchingData
            self._esValido = True
        except MatchingData as e:
            ExceptionPopUp(e)

    def validarExisteViaje(self, origen, destino, viajes):
        try: 
            for viajesFiltro in viajes:
                if(viajesFiltro.getOrigen() == origen and viajesFiltro.getDestino() == destino):
                    self._esValido = True
                    return
            raise NotExistException
        except NotExistException as e:
            ExceptionPopUp(e)
            
    def validarDisponibleSilla (self,sillaNueva, bus):
        try: 
            if sillaNueva in bus.getSillaNoDisponibles():
                self._esValido = False 
                raise CharNotAvailableException
            self._esValido = True
        except CharNotAvailableException as e:
            ExceptionPopUp(e)
    
    def validarExistenciaSilla ( self, sillaNueva, bus):
        try: 
            if sillaNueva not in bus.getSillas():
                self._esValido = False
                raise NotExistChairException
            self._esValido = True
        except NotExistChairException as e:
            ExceptionPopUp(e)
    
    def validarDocumento(self, numDocumento, tiquete):
        try: 
            if numDocumento == "":
                return
            if len(tiquete.getTiquetesComprados()) ==0:
                self._esValido = False
                raise DocumentNotExistException
            else:
               if numDocumento not in str(tiquete.getTiquetesComprados()):
                   self._esValido = False
                   print(tiquete.getTiquetesComprados())
                   raise DocumentNotExistException
            self._esValido = True
        except DocumentNotExistException as e:
            ExceptionPopUp(e)

    

    def getValidacion(self):
        return self._esValido
    
    def setValidacion(self, valido):
        self._esValido = valido
