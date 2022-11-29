import tkinter as tk
from tkinter import ttk
from gestor_aplicacion.clasesPrincipales.Pasajero import Pasajero
from gestor_aplicacion.manejoErrores.Validador import Validador
from gestor_aplicacion.clasesPrincipales.Viaje import Viaje
from gestor_aplicacion.clasesPrincipales.Tiquete import Tiquete
from gestor_aplicacion.clasesPrincipales.Servicio import Servicio
from gestor_aplicacion.clasesPrincipales.Bus import Bus
from tkinter import messagebox
import math

class MenuOptimizacion(tk.Frame):
    def __init__(self, master, contenedor):
        tk.Frame.__init__(self, contenedor)

        self.master = master

        self.logo = self.master.cargarImagen("bus")
        self.sidebar = ttk.Frame(self, borderwidth="2", relief="raised")
        self.main = ttk.Frame(self, borderwidth="2")

        self.sidebar.pack(side="left", fill="y")
        self.main.pack(side="right", fill="both", expand=True)

        self.crearSideBar()
        self.ObtenerPromocion()
    
    def crearSideBar(self):
        lblImage = ttk.Label(self.sidebar, image=self.logo)
        lblBrand = ttk.Label(
            self.sidebar, text="TransPOOrte", font=("Segoe UI", 15))
        btnPromocion = ttk.Button(
            self.sidebar, text="Ver Promociones", command=self.ObtenerPromocion)
        btnViajeParadas = ttk.Button(
            self.sidebar, text="Viaje con paradas", command=self.ViajesParadas)

        # Pack widgets
        lblImage.pack()
        lblBrand.pack(padx="5", pady=(0, 25))
        btnPromocion.pack(fill="x", padx="5", pady="3")
        btnViajeParadas.pack(fill="x", padx="5", pady="3")
    
    def ObtenerPromocion(self):
        self.master.limpiarFrame(self.main)
        
        entryCedulaVar = tk.StringVar()

        def submit():
            cedulaPasajero = entryCedulaVar.get()
            validador = Validador()
            validador.validarCampoVacio(cedulaPasajero)
            if (validador.getValidacion()):
                validador.validarCampoNumerico(cedulaPasajero)
            #validador.validarDocumento(cedulaPasajero, Tiquete)


            if validador.getValidacion():
                for tiquete in Tiquete.getTiquetesComprados():
                    if str(tiquete.getPasajero().getCedula()) == cedulaPasajero:
                        tiquete.setComprador(tiquete.getPasajero())
                        #capacidadcal =tiquete.getViaje().getBus().getCapacidad()
                        #validador.validarCapacidad(capacidadcal,tiquete)
                        nuevoPrecio = (tiquete.getValor()-(math.trunc((tiquete.getValor()*20) / float(100))))
                        tiquete.setValor(nuevoPrecio)
                        messagebox.showinfo(title= "Los viajes con promocion son los siguientes:", message= tiquete)
        
        lblMensajeInicio = ttk.Label(self.main, text="Adquirir promocion", font=("Segoe UI", 20))
        lblDocumento = ttk.Label(self.main, text = "Ingrese el numéro de documento con el cual realizo la\ncompra del tiquete")
        entryDocumento = ttk.Entry(self.main, textvariable= entryCedulaVar)
        
        lblMensajeInicio.pack()
        lblDocumento.pack()
        entryDocumento.pack()       

        btnSubmit = ttk.Button(
                self.main, 
                text="Submit", 
                command=submit
        )
        btnSubmit.pack()

    def ViajesParadas(self):
        self.master.limpiarFrame(self.main)
        lblMensajeInicio = ttk.Label(self.main, text="Visualizar viajes con paradas", font=("Segoe UI", 20))
        lblMensajeInicio.pack()

        cmbDestinoVar = tk.StringVar()
        cmbOrigenVar = tk.StringVar()

        def submit():
            destinoViaje = cmbDestinoVar.get()
            origenViaje = cmbOrigenVar.get()
            validador = Validador()

            validador.validarCampoVacio(destinoViaje, origenViaje)
            validador.validarOrigenDestino(destinoViaje, origenViaje)
            if validador.getValidacion():
                validador.setValidacion(False)
                validador.validarExisteViaje(origenViaje, destinoViaje, Viaje.getViajes())


            if validador.getValidacion():
                viajesFiltrados = list(
                    filter(
                        lambda viaje: viaje.getOrigen() == origenViaje
                        and viaje.getDestino() == destinoViaje,
                        Viaje.getViajes()
                    )
                )
                self.mostrarViajes(viajesFiltrados)
        
        lblDestino = ttk.Label(self.main, text="Destino")
        cmbDestino = ttk.Combobox(self.main, values= Viaje.getLugares(), textvariable= cmbDestinoVar)

        lblOrigen = ttk.Label(self.main, text="Origen")
        cmbOrigen = ttk.Combobox(self.main, values= Viaje.getLugares(), textvariable= cmbOrigenVar)


        lblOrigen.pack()
        cmbOrigen.pack()
        lblDestino.pack()
        cmbDestino.pack()

        btnSubmit = ttk.Button(
                self.main, 
                text="Submit", 
                command=submit
        )
        btnSubmit.pack()


    def mostrarViajes(self,viajesfiltrados):
        self.master.limpiarFrame(self.main)
        ttk.Label(self.main, text = "{:<20} {:<25} {:<20} {:<20} {:}".
                    format('Origen','Destino','Fecha','Precio','Paradas'), justify= "center").pack(pady = (0,15))
        for viajes in viajesfiltrados:
                parada = str(viajes.getRuta().getParadas())
                fecha = str(viajes.getFecha()).split(" ")
                ttk.Label(self.main, text = "{:<20} {:<25} {:<20} {:<20} {:<20}".
                    format(viajes.getOrigen(), viajes.getDestino(), fecha[0], viajes.getPrecio(), parada[0])).pack(pady = (0,15))
        btnVolver = ttk.Button(self.main, text = "Volver", command= lambda: self.volverViajeBus()).pack()
    