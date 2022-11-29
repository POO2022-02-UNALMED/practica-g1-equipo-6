import pickle
from gestor_aplicacion.clasesPrincipales.Tiquete import Tiquete
from gestor_aplicacion.clasesPrincipales.Bus import Bus
from gestor_aplicacion.clasesPrincipales.Pasajero import Pasajero
from gestor_aplicacion.clasesPrincipales.Ruta import Ruta
from gestor_aplicacion.clasesPrincipales.Viaje import Viaje
from gestor_aplicacion.clasesPrincipales.Conductor import Conductor
import pathlib
import os


class Serializador:
    @classmethod
    def serializar(cls,tipo):
        if tipo=="Bus":
            pickfile = open("baseDatos/temp/buses.txt", "wb")
            serializa = Bus._buses
            pickle.dump(serializa, pickfile,)
            pickfile.close

        elif tipo=="Conductor":
            pickfile = open("baseDatos/temp/conductores.txt", "wb")
            serializa = Conductor._conductores
            pickle.dump(serializa, pickfile)
            pickfile.close
        
        elif tipo=="Pasajero":
            pickfile = open("baseDatos/temp/pasajeros.txt", "wb")
            serializa = Pasajero._pasajeros
            pickle.dump(serializa, pickfile)
            pickfile.close
        
        elif tipo=="Ruta":
            pickfile = open("baseDatos/temp/rutas.txt", "wb")
            serializa = Ruta._rutas
            pickle.dump(serializa, pickfile)
            pickfile.close
        
        elif tipo=="Tiquete":
            pickfile = open("baseDatos/temp/tiquetes.txt", "wb")
            serializa = Tiquete._tiquetes
            pickle.dump(serializa, pickfile)
            pickfile.close

        elif tipo == "Viaje":
            pickfile = open("baseDatos/temp/viajes.txt","wb")
            serializa = Viaje.getViajes()
            pickle.dump(serializa,pickfile)
            pickfile.close
        
    def SerializarTodo():
        Serializador.serializar("Bus")
        Serializador.serializar("Conductor")
        Serializador.serializar("Pasajero")
        Serializador.serializar("Ruta")
        Serializador.serializar("Tiquete")
        Serializador.serializar("Viaje")

