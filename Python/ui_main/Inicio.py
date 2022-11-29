import tkinter as tk
from tkinter import ttk


class Inicio(tk.Frame):
    def __init__(self, master, contenedor):
        tk.Frame.__init__(self, contenedor)

        textUsuario = """Instrucciones de Uso:

- Querido Usuario, a traves de esta aplicacion (TransPOOrte), que
esta desarrollada bajo el paradigma de programacion orientada a objetos, se
lleva a cabo la implementacion de diferentes funciones que permiten administrar
una flota de autobuses (Compra de tiquetes, gestion de conductores,
viajes y buses, visualizacion de estadisticas y
calcular la rentabilidad de cada viaje). 
A continuacion, se explica cada uno de estos servicios a los cuales
puedes acceder:   


- Visualizacion de estadisticas: Permite observar porcentaje
de ocupacion por viaje. En este sentido, dependiendo del porcentaje de 
ocupacion de cada viaje se modifica la frecuencia
(mayor al 85% aumenta la frecuencia en 1 hora, si esta entre el 40%-60%
disminuira la frecuencia del viaje en 2 horas).

- Gestion de conductores: Accede al registro de los
conductores existentes y activos. Tambien se encuentran otro tipo de opciones
como asignar una tarea, despedir al empleado y visualizar el historial de
viajes asignados, entre otras.

- Gestionar viaje: Con la ayuda del numero de cedula se accede
a los tiquetes ya comprados y se puede realizar cambios especificos
como modificarr un tiquete, tambien permite crear y eliminar viajes .


- Compra de tiquetes: El usuario puede comprar un tiquete segun
la disponibilidad de pasajes, de acuerdo con la ciudad origen y la ciudad
destino deseada, tambien le permite al usuario realizar cambio de silla o 
adquirir un servico del tiquete comprado ingresando la cedula con la cual 
se realiza la compra, y por ultimo da la opcion de ver los viajes disponibles 
por tipo de bus . 

- Calcular rentabilidad por viaje: Esta opción calcula la rentabilidad de un 
viaje seleccionado en función del valor del tiquete en ese momento, calcula 
el costo operativo del viaje y resta el valor del tiquete para mostrar así 
la utilidad del viaje. También nos muestra el porcentaje de ocupación del 
vehículo, la ocupación promedio de la ruta  y su utilidad promedio."""

        label = tk.Label(self, text=textUsuario, font=('Times', '20'))
        label.pack(pady=0, padx=0)
