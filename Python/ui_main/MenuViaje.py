import tkinter as tk
from tkinter import ttk
from gestor_aplicacion.clasesPrincipales.Pasajero import Pasajero
from gestor_aplicacion.manejoErrores.Validador import Validador
from gestor_aplicacion.clasesPrincipales.Viaje import Viaje
from gestor_aplicacion.clasesPrincipales.Tiquete import Tiquete
from gestor_aplicacion.clasesPrincipales.Servicio import Servicio
from gestor_aplicacion.clasesPrincipales.Bus import Bus
from tkinter import messagebox


class MenuViaje(tk.Frame):
    def __init__(self, master, contenedor):
        tk.Frame.__init__(self, contenedor)

        self.master = master

        self.logo = self.master.cargarImagen("bus")
        self.sidebar = ttk.Frame(self, borderwidth="2", relief="raised")
        self.main = ttk.Frame(self, borderwidth="2")

        self.sidebar.pack(side="left", fill="y")
        self.main.pack(side="right", fill="both", expand=True)

        # Creacion de sidebar
        self.crearSideBar()
        #self.crearComprador()

    def crearSideBar(self):
        lblImage = ttk.Label(self.sidebar, image=self.logo)
        lblBrand = ttk.Label(
            self.sidebar, text="TransPOOrte", font=("Segoe UI", 15))
        btnAgregarViaje = ttk.Button(
            self.sidebar, text="Agregar Viaje", command=self.agregarViaje)
        btnModificarViaje = ttk.Button(
            self.sidebar, text="Modificar Viaje", command=self.modificarViaje)
        btnCancelarViaje = ttk.Button(
            self.sidebar, text="Cancelar Viaje", command=self.cancelarViaje)

        # Pack widgets
        lblImage.pack()
        lblBrand.pack(padx="5", pady=(0, 25))
        btnAgregarViaje.pack(fill="x", padx="5", pady="3")
        btnModificarViaje.pack(fill="x", padx="5", pady="3")
        btnCancelarViaje.pack(fill="x", padx="5", pady="3")

    def agregarViaje():
        pass
    def modificarViaje():
        pass
    def cancelarViaje():
        pass