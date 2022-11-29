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
            pickfile = open("baseDatos/temp/buses.txt", "rb")
            Bus._buses = pickle.load(pickfile)
            pickfile.close

        elif tipo == "Conductor":
            pickfile = open( "baseDatos/temp/conductores.txt", "rb")
            Conductor._conductores = pickle.load(pickfile)
            pickfile.close

        elif tipo == "Pasajero":
            pickfile = open("baseDatos/temp/pasajeros.txt", "rb")
            Pasajero._pasajeros = pickle.load(pickfile)
            pickfile.close

        elif tipo == "Ruta":
            pickfile = open("baseDatos/temp/rutas.txt", "rb")
            Ruta._rutas = pickle.load(pickfile)
            pickfile.close

        elif tipo == "Tiquete":
            pickfile = open("baseDatos/temp/tiquetes.txt", "rb")
            Tiquete._tiquetes = pickle.load(pickfile)
            pickfile.close

        elif tipo == "Viaje":
            pickfile = open("baseDatos/temp/viajes.txt","rb")
            Viaje.setViajes(pickle.load(pickfile))
            pickfile.close

    def DeserializarTodo():
        Deserializador.deserializar("Bus")
        Deserializador.deserializar("Conductor")
        Deserializador.deserializar("Pasajero")
        Deserializador.deserializar("Ruta")
        Deserializador.deserializar("Tiquete")
        Deserializador.deserializar("Viaje")
