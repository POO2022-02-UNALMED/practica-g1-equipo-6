from gestor_aplicacion.clasesPrincipales.Bus import Bus
from gestor_aplicacion.clasesPrincipales.Conductor import Conductor
from gestor_aplicacion.clasesHerencia.Ejecutivo import Ejecutivo
from gestor_aplicacion.clasesHerencia.EuroVans import EuroVans
from gestor_aplicacion.clasesHerencia.TecnoVans import TecnoVans


class administrarVehiculo:

    @classmethod
    def crearBus(self,typo,placa,conductor):
        

        if typo == "Ejecutivo":
            bus = Ejecutivo()
            bus._placa = placa
            bus._conductor = conductor

        elif typo == "TecnoVans":
            bus = TecnoVans()
            bus._placa = placa
            bus._conductor = conductor

        elif typo == "EuroVans":
            bus = EuroVans()
            bus._placa = placa
            bus._conductor = conductor

        return 1

    @classmethod
    def eliminarBus(self,placa):
        vali = 0
        for  buses in Bus.placa:
            if placa == Bus.placa:
                del Bus.placa
                vali=1
        return vali

    @classmethod
    def mostrarBuses(self,typo):
        vali = 0
        for  buses in Bus.placa:
            if placa == Bus.placa:
                del Bus.placa
                vali=1
        return vali