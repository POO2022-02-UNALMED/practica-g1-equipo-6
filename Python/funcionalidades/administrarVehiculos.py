from gestor_aplicacion.clasesPrincipales.Bus import Bus
from gestor_aplicacion.clasesPrincipales.Conductor import Conductor
from gestor_aplicacion.clasesHerencia.Ejecutivo import Ejecutivo
from gestor_aplicacion.clasesHerencia.EuroVans import EuroVans
from gestor_aplicacion.clasesHerencia.TecnoVans import TecnoVans


class administrarVehiculo:

    @classmethod
    def crearBus(self,typo,placa,conductor):
        

        if typo == "Ejecutivo":
<<<<<<< Updated upstream
            Ejecutivo(placa,conductor,[])
=======
            busE = Ejecutivo(placa,conductor,[])
>>>>>>> Stashed changes

        elif typo == "TecnoVans":
            busT = Ejecutivo(placa,conductor,[])

        elif typo == "EuroVans":
            busEu = Ejecutivo(placa,conductor,[])

        return 1

    @classmethod
    def eliminarBus(self,placa):
        vali = 0
        for  buses in Bus.placa:
            if placa == Bus.placa:
                del Bus.placa
                vali=1
        return vali