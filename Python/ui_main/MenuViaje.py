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

    def agregarViaje(self):
        self.master.limpiarFrame(self.main)
        
        entryIDVar = tk.StringVar()
        entryHLlegadaVar = tk.StringVar()
        entryHsalidaVar = tk.StringVar()
        entryFrecuenciaVar = tk.StringVar()
        entryCostoVar = tk.StringVar()

        def submit():
            ID = entryIDVar.get()
            HLlegada = entryHLlegadaVar.get()
            HSalida = entryHsalidaVar.get()
            Frecuencia = entryHsalidaVar.get()
            Costo = entryHsalidaVar.get()
            validador = Validador()
            validador.validarCampoVacio(ID, HLlegada, HSalida, Frecuencia, Costo)

        lblTitulo = ttk.Label(self.main, text="Agregar Viaje", font=("Segoe UI", 20))
        lblID = ttk.Label(self.main, text="ID del viaje")
        entryID = ttk.Entry(self.main, textvariable=entryIDVar)
        lblHLlegada = ttk.Label(self.main, text="Hora de inicio del viaje (HH:MM)")
        entryHLlegada = ttk.Entry(self.main, textvariable=entryHLlegadaVar)
        lblHSalida = ttk.Label(self.main, text="Hora de llegada al destino del viaje (HH:MM)")
        entryHSalida = ttk.Entry(self.main, textvariable=entryHsalidaVar)
        lblFrecuencia = ttk.Label(self.main, text="Frecuencia del viaje")
        entryFrecuencia = ttk.Entry(self.main, textvariable=entryHsalidaVar)
        lblCosto = ttk.Label(self.main, text="Costo del viaje")
        entryCosto = ttk.Entry(self.main, textvariable=entryHsalidaVar)
        
        lblTitulo.pack(pady=(0, 20))
        lblID.pack()
        entryID.pack()
        lblHLlegada.pack()
        entryHLlegada.pack()
        lblHSalida.pack()
        entryHSalida.pack() 
        lblFrecuencia.pack()
        entryFrecuencia.pack() 
        lblCosto.pack()
        entryCosto.pack()       

        btnSubmit = ttk.Button(
                self.main, 
                text="Submit", 
                command=submit
        )
        btnSubmit.pack()

    def modificarViaje(self):
        self.master.limpiarFrame(self.main)
        lblTitulo = ttk.Label(self.main, text="Modificar Viaje", font=("Segoe UI", 20))
        lblTypo = ttk.Label(self.main, text="¿Que desea modificar?")
        lblTitulo.pack(pady=(0, 20))
        lblTypo.pack()
        ttk.Radiobutton(self.main, text = "Fecha", value = 1).pack()
        ttk.Radiobutton(self.main, text = "Precio", value = 2).pack()

    def cancelarViaje(self):
        self.master.limpiarFrame(self.main)
        lblTitulo = ttk.Label(self.main, text="Eliminar Viaje", font=("Segoe UI", 20))
        lblTitulo.pack(pady=(0, 20))