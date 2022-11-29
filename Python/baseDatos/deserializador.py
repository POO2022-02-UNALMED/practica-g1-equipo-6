import pickle
from gestor_aplicacion.clasesPrincipales.Tiquete import Tiquete
from gestor_aplicacion.clasesPrincipales.Bus import Bus
from gestor_aplicacion.clasesPrincipales.Pasajero import Pasajero
from gestor_aplicacion.clasesPrincipales.Ruta import Ruta
from gestor_aplicacion.clasesPrincipales.Viaje import Viaje
from gestor_aplicacion.clasesPrincipales.Conductor import Conductor
import pathlib
import os

class Deserializador:
    
    @classmethod
    def deserializar(cls, tipo):
        if tipo == "Bus":
            path = os.path.join(pathlib.Path(__file__).parent.absolute())
            pickfile = open(path+"/temp/buses.txt", "rb")
            Bus._buses = pickle.load(pickfile)
            pickfile.close

        elif tipo == "Conductor":
            path = os.path.join(pathlib.Path(__file__).parent.absolute())
            pickfile = open( path+"/temp/conductores.txt", "rb")
            Conductor._conductores = pickle.load(pickfile)
            pickfile.close

        elif tipo == "Pasajero":
            path = os.path.join(pathlib.Path(__file__).parent.absolute())
            pickfile = open(path+"/temp/pasajeros.txt", "rb")
            Pasajero._pasajeros = pickle.load(pickfile)
            pickfile.close

        elif tipo == "Ruta":
            path = os.path.join(pathlib.Path(__file__).parent.absolute())
            pickfile = open(path+"/temp/rutas.txt", "rb")
            Ruta._rutas = pickle.load(pickfile)
            pickfile.close

        elif tipo == "Tiquete":
            path = os.path.join(pathlib.Path(__file__).parent.absolute())
            pickfile = open(path+"/temp/tiquetes.txt", "rb")
            Tiquete._tiquetes = pickle.load(pickfile)
            pickfile.close

        elif tipo == "Viaje":
            path = os.path.join(pathlib.Path(__file__).parent.absolute())
            pickfile = open(path+"/temp/viajes.txt","rb")
            Viaje.setViajes(pickle.load(pickfile))
            pickfile.close

    def DeserializarTodo():
        Deserializador.deserializar("Bus")
        Deserializador.deserializar("Conductor")
        Deserializador.deserializar("Pasajero")
        Deserializador.deserializar("Ruta")
        Deserializador.deserializar("Tiquete")
        Deserializador.deserializar("Viaje")
