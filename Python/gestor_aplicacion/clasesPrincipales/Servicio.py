from enum import Enum

class Servicio(Enum):
    MALETAS_EXTRA = 5000
    ALMOHADA = 2500
    AURICULARES = 3000
    VIAJAR_CON_MASCOTA = 10000

    def getPrecio(cls):
        return Servicio.value

    
